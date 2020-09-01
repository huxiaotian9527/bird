package com.hu.boot.bird.mail;

import com.hu.boot.bird.config.EmailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


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
public class TestMailTask {

    @Autowired
    private EmailConfig emailConfig;

    public static String url = "https://www.amazon.de/dp/";

    //定时任务每3小时执行一次
//    @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0/10 * * * * ?")
    private void runTask() {
        log.info("【mial定时任务】: 开始执行拉取定时任务");
        try {
            runTask1();
            log.info("【mial定时任务】: 执行定时任务成功！");
        } catch (Exception e) {
            log.info("【mial定时任务】: 定时任务执行异常！", e);
        }
    }

    private void runTask1() throws Exception {
//        emailConfig.sendSimpleMail("hutiantian@tcl.com","测试","1231321",null);

    }


}

