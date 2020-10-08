package com.hu.boot.bird.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
@Slf4j
public class EmailComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.default.from}")
    private String from;

    /**
     *  发送邮件附带附件
     */
    public void sendSimpleMail(String[] to, String date, List<String> excelDataList){
        MimeMessage message;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject("【FEOL PIN检查机Defect叠图】定时邮件");
            String html = "<html>\n" +
                    "<body>\n" +
                    "各位好:以下为最近2小时pin、sli散点图，数据见附件excel<br/><br/>";
            int count = 1;
//            for (ExcelData excelData : excelDataList) {
//                for (int i = 0; i < excelData.getBaoList().size(); i++) {
//                    html = html + "<img src='cid:identifier" + count + "' >";
//                    count++;
//                }
//            }
//
//            html = html+"</body></html>";
//            helper.setText(html,true);
//            count=1;
//            for (ExcelData excelData : excelDataList) {
//                for (int i = 0; i < excelData.getBaoList().size(); i++) {
//                    InputStreamSource inputStream = new ByteArrayResource(excelData.getBaoList().get(i).toByteArray());
//                    helper.addInline("identifier"+count, inputStream,"image/jpeg");
//                    count++;
//                }
//            }
//            //附件
//            for (ExcelData excelData:excelDataList){
//                if(excelData.getBao()!=null){
//                    InputStreamSource inputStream = new ByteArrayResource(excelData.getBao().toByteArray());
//                    helper.addAttachment(excelData.getExcelName()+date+".xlsx",inputStream);
//                }
//            }
            javaMailSender.send(message);
        } catch (MessagingException e) {
           log.error("邮件发送失败",e);
        }
    }

}
