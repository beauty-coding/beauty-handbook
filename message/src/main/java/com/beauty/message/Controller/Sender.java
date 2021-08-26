package com.beauty.message.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/8/24 1:09 下午
 */
@RestController
public class Sender {


    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;
    /**
     * 测试outlook发送邮件，已成功
     * */
    @RequestMapping("/send")
    public String send()
    {
        SimpleMailMessage m=new SimpleMailMessage();
        m.setFrom(username);
        m.setTo("yufengwen@baijia.com");
        m.setText("test");
        m.setSubject("subject");//主题
        javaMailSender.send(m);
        return "success";
    }
}
