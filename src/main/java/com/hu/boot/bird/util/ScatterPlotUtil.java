package com.hu.boot.bird.util;

import com.aspose.cells.Chart;
import com.aspose.cells.ImageFormat;
import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.Worksheet;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ScatterPlotUtil {

    private static double MAX_X = 750;
    private static double MAX_Y = 875;
    private static double MIN_X = -750;
    private static double MIN_Y = -925;

    /**
     * 根据坐标值，画散点图
     * @param wb excel
     * @param product 线别名称
     * @param group 产品分组
     * @param oxs x坐标值
     * @param oys y坐标值
     */
    public static void generateChart(XSSFWorkbook wb, String product, String group, List<Double> oxs, List<Double> oys, String glassId) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);         // 居中
        try {
            XSSFSheet sheet = wb.createSheet(product+"_"+group+"_散点图");
            //写第一行
            writeFirstLine(sheet,cellStyle);
            Row row;
            Cell cell;
            for (int rowIndex = 1; rowIndex < oxs.size()+1; rowIndex++) {
                row = sheet.createRow(rowIndex);
                //glass值
                cell = row.createCell(0);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(glassId);
                //x值
                cell = row.createCell(1);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(oxs.get(rowIndex-1));
                //y值
                cell = row.createCell(2);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(oys.get(rowIndex-1));
            }
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 4, 2, 10, 22 );
            XSSFChart chart = drawing.createChart(anchor);
            //char标题
            chart.setTitleText(product+" "+group+" Map");
            chart.getTitle().setOverlay(false);
            XDDFValueAxis bottomAxis = chart.createValueAxis(AxisPosition.BOTTOM);
            //横坐标设置
            bottomAxis.setMaximum(MAX_X);
            bottomAxis.setMinimum(MIN_X);
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            //纵坐标设置
            leftAxis.setMaximum(MAX_Y);
            leftAxis.setMinimum(MIN_Y);
            XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, oxs.size()+1, 1, 1));
            XDDFNumericalDataSource<Double> ys = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, oxs.size()+1, 2, 2));
            XDDFScatterChartData data = (XDDFScatterChartData) chart.createData(ChartTypes.SCATTER, bottomAxis, leftAxis);
            XDDFScatterChartData.Series series = (XDDFScatterChartData.Series) data.addSeries(xs, ys);
            series.setSmooth(true);
            series.setMarkerStyle(MarkerStyle.CIRCLE);
            series.setMarkerSize((short) 3);
            setLineNoFill(series);
            //点颜色设置
            XDDFSolidFillProperties fillMarker = new XDDFSolidFillProperties(XDDFColor.from(new byte[]{(byte)0x00, (byte)0x00, (byte)0xFF}));
            XDDFNoFillProperties noFill = new XDDFNoFillProperties();
            XDDFShapeProperties propertiesMarker = new XDDFShapeProperties();
            propertiesMarker.setFillProperties(fillMarker);
            XDDFLineProperties lineProperties = new XDDFLineProperties();
            lineProperties.setFillProperties(noFill);
            propertiesMarker.setLineProperties(lineProperties);
            chart.getCTChart().getPlotArea().getScatterChartArray(0).getSerArray(0).getMarker()
                    .addNewSpPr().set(propertiesMarker.getXmlObject());
            chart.plot(data);
        }catch (Exception e){
            log.error("生产excel失败！",e);
        }
    }

    private static void setLineNoFill(XDDFScatterChartData.Series series) {
        XDDFNoFillProperties noFillProperties = new XDDFNoFillProperties();
        XDDFLineProperties lineProperties = new XDDFLineProperties();
        lineProperties.setFillProperties(noFillProperties);
        XDDFShapeProperties shapeProperties = series.getShapeProperties();
        if (shapeProperties == null) shapeProperties = new XDDFShapeProperties();
        shapeProperties.setLineProperties(lineProperties);
        series.setShapeProperties(shapeProperties);
    }

    private static void writeFirstLine(XSSFSheet sheet, XSSFCellStyle cellStyle){
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("GLASSID");
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("X1");
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Y1");
    }

    /**
     * 从excel提取chart，转存字节流
     */
    private List<ByteArrayOutputStream> getImageData(ByteArrayOutputStream bao, int size) throws Exception{
        InputStream in = new ByteArrayInputStream(bao.toByteArray());
        com.aspose.cells.Workbook workbook = new com.aspose.cells.Workbook(in);
        List<ByteArrayOutputStream> baoList = new ArrayList<>();
        for (int i=0;i<size;i++){
            Worksheet sheet = workbook.getWorksheets().get(i);
            Chart chart = sheet.getCharts().get(0);
            chart.setShowLegend(false);
            ImageOrPrintOptions imgOpts = new ImageOrPrintOptions();
            imgOpts.setImageFormat(ImageFormat.getPng());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            chart.toImage(baos, imgOpts);
            baoList.add(baos);
        }
        return baoList;
    }
}

