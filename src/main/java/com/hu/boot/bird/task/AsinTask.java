package com.hu.boot.bird.task;

import com.hu.boot.bird.dao.AwsAsinDao;
import com.hu.boot.bird.dao.AwsAsinRankDao;
import com.hu.boot.bird.po.AwsAsin;
import com.hu.boot.bird.po.AwsAsinExample;
import com.hu.boot.bird.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * asin定时任务，用于拉去亚马逊数据
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

    public static String url= "https://www.amazon.de/dp/";

//    @Scheduled(cron = "0 0 0/6 * * ?")
    @Scheduled(cron = "0 0/1 * * * ?")
    //定时任务每3小时执行一次
    private void runTask() {
        log.info("【aws定时任务】: 开始执行拉取定时任务" );
        try{
            runTask1();
        }catch (Exception e){
            log.info("【aws定时任务】: 定时任务执行异常！",e );
        }
        log.info("【aws定时任务】: 执行定时任务成功！" );
    }

    private void runTask1() throws Exception{
        //1.获取待处理的商品
        List<String> runList =  getAsin();
        List<List<String>> excelList = new ArrayList<>();
        //初始化CountDownLatch，多线程一起跑，
        CountDownLatch countDownLatch = new CountDownLatch(runList.size());
        //初始化http请求头，伪装浏览器访问，避免被反爬虫
        Map<String,String> header = new HashMap<>();
        header.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        header.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
        for(String str:runList){
            new Thread(()->{
                //jsoup解析dom
                Document doc = Jsoup.parse(HttpUtil.doGet(url+str,header).trim());
                Element salesRank = doc.getElementById("SalesRank");  //选择器的形式
                String[] strings = salesRank.text().split("Nr.");
                List<String> strList = new ArrayList<>();
                strList.add(str);

                for (int i = 1; i < strings.length; i++) {
                    //把这种排名转换 19.883 in Garten (Siehe Top 100 in Garten)
                    //成 Sport & Freizeit + 8.215
                    String rank = strings[i];
                    String str1 = rank.split("in")[0].trim();
                    String str2 = rank.replace(str1+" in","").trim();
                    if(str2.contains("(")){
                        str2 = str2.split("\\(")[0].trim();
                    }
                    strList.add(str2);
                    strList.add(str1);
                }
                synchronized (AsinTask.class){
                    excelList.add(strList);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();


    }



    /**
     * 获取商品asin
     */
    private List<String> getAsin(){
        AwsAsinExample asinExample = new AwsAsinExample();
        asinExample.or();
        List<AwsAsin> list = awsAsinDao.selectByExample(asinExample);
        return list.stream().map(e->e.getAsin().trim()).collect(Collectors.toList());
    }



}
