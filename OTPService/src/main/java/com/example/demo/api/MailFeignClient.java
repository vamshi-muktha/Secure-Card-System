package com.example.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.bean.MailRequest;

@FeignClient(name = "mail-service", url = "${mail.service.url}")
public interface MailFeignClient {

    @PostMapping("/mail/send")
    String sendMail(@RequestBody MailRequest request);
}
