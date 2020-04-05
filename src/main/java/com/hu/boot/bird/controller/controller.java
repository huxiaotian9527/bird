package com.hu.boot.bird.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * jvm堆溢出测试
 * @Author hutiantian
 * @Date 2019/5/22 13:50:58
 */
@RestController
@RequestMapping("/out")
@Slf4j
public class controller {

@RequestMapping(value = "/memory", method = RequestMethod.GET)
    public String outOfMemory(){
        int i = 0;
        List<List<String>> list = new ArrayList<>();
        while (true){
            log.info("【outOfMemoryTest】: 执行第"+i+"次");
            i++;
            List<String> list1 = new ArrayList<>(1000*1000*10);
            list.add(list1);
            if(i>1000*1000*1000*1000){
                break;
            }
        }
        return "I am out enough!";
    }

}
