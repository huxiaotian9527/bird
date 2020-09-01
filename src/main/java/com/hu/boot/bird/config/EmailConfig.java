package com.hu.boot.bird.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Component
@Slf4j
public class EmailConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.default.from}")
    private String from;

    /**
     *  发送邮件附带附件
     */
    public void sendSimpleMail(String[] to, String subject, String content, ByteArrayOutputStream attachBao, String attachName){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content,true);
            //附件
            InputStreamSource inputStream = new ByteArrayResource(attachBao.toByteArray());
            helper.addAttachment(attachName,inputStream);
            javaMailSender.send(message);
        } catch (MessagingException e) {
           log.error("邮件发送失败",e);
        }
    }

}
