package com.hu.boot.bird.aws.task;

import com.hu.boot.bird.aws.dao.AwsAsinDao;
import com.hu.boot.bird.aws.dao.AwsAsinRankDao;
import com.hu.boot.bird.aws.po.AwsAsin;
import com.hu.boot.bird.aws.po.AwsAsinExample;
import com.hu.boot.bird.aws.po.AwsAsinRank;
import com.hu.boot.bird.util.DateFormatEnum;
import com.hu.boot.bird.util.DateUtil;
import com.hu.boot.bird.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * asin定时任务，用于拉去亚马逊数据
 *
 * @author hutiantian
 * @date: 2019/5/25 18:47
 * @since 1.0.0
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class AsinTask {

    @Autowired
    private AwsAsinDao awsAsinDao;

    @Autowired
    private AwsAsinRankDao awsAsinRankDao;

    public static String url = "https://www.amazon.de/dp/";

    //定时任务每3小时执行一次
//    @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0 0 0/3 * * ?")
    private void runTask() {
        log.info("【aws定时任务】: 开始执行拉取定时任务");
        try {
            runTask1();
            log.info("【aws定时任务】: 执行定时任务成功！");
        } catch (Exception e) {
            log.info("【aws定时任务】: 定时任务执行异常！", e);
        }
    }

    private void runTask1() throws Exception {
        //获取待处理的商品
        List<String> goodsList = getAsin();
        //将所有线程获取到的商品列表统一保存起来入库
        /*-----在各自的线程中入库也可以，就当在加深一遍CountDownLatch的使用场景------*/
        List<AwsAsinRank> resultList = new ArrayList<>();
        //初始化CountDownLatch，多线程一起跑，
        CountDownLatch countDownLatch = new CountDownLatch(goodsList.size());
        //初始化http请求头，伪装浏览器访问，避免被反爬虫
        Map<String, String> header = new HashMap<>();
        header.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        header.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
        header.put("Referer", "http://www.baidu.com");
        Date today = new Date();
        String hour = DateUtil.toString(today,DateFormatEnum.HOUR);
        if(hour.startsWith("0")){
            hour = hour.replaceFirst("0","");
        }
        byte h = Byte.parseByte(hour);
        for (String goods : goodsList) {
            new Thread(() -> {
                log.info("正在处理商品 " + goods);
                List<AwsAsinRank> awsAsinRank;
                while ((awsAsinRank = toList(goods,header,today,h)) == null) {
                    try {
                        Thread.sleep(10000);
                        log.info("重新处理商品 " + goods);
                    } catch (Exception e) {

                    }
                }
                log.info("商品 " + goods + " 获取排行成功！");
                synchronized (AsinTask.class) {
                    resultList.addAll(awsAsinRank);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        awsAsinRankDao.batchInsert(resultList);
    }


    /**
     * 获取商品asin
     */
    private List<String> getAsin() {
        AwsAsinExample asinExample = new AwsAsinExample();
        asinExample.or();
        List<AwsAsin> list = awsAsinDao.selectByExample(asinExample);
        return list.stream().map(e -> e.getAsin().trim()).collect(Collectors.toList());
    }

    /**
     * 根据商品获取排行
     */
    private static List<AwsAsinRank> toList(String goods, Map<String, String> header,Date today,byte hour) {
        List<AwsAsinRank> asinList = new ArrayList<>();
        try {
            Document doc = Jsoup.parse(HttpsUtil.doGet(url + goods, header).trim());
            Element salesRank = doc.getElementById("SalesRank");  //选择器的形式
            String[] strings = salesRank.text().split("Nr.");
            for (int i = 1; i < strings.length; i++) {
                //把这种排名转换 19.883 in Garten (Siehe Top 100 in Garten)
                //成 Sport & Freizeit + 8.215
                String rank = strings[i];
                String rankScore = rank.split("in")[0].trim();
                String rankName = rank.replace(rankScore + " in", "").trim();
                if (rankName.contains("(")) {
                    rankName = rankName.split("\\(")[0].trim();
                }
                AwsAsinRank asinRank = AwsAsinRank.builder()
                                        .asin(goods)
                                        .rankName(rankName)
                                        .rankScore(rankScore)
                                        .grabDay(today)
                                        .grabHour(hour)
                                        .build();
                if(i==1){
                    asinRank.setType(true);
                }else {
                    asinRank.setType(false);
                }
                asinList.add(asinRank);
            }
        } catch (Exception e) {
            log.info("商品 " + goods + " 处理失败！");
            return null;
        }
        return asinList;
    }


}
