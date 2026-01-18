package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OtpService;

@RestController
@RequestMapping("/otp")
@CrossOrigin(origins = "http://localhost:3000")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public String sendOtp(@RequestParam String email) {
        otpService.sendOtp(email);
        return "OTP Sent Successfully";
    }

    @RequestMapping(value = "/verify", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean verifyOtp(@RequestParam String email,
                            @RequestParam String otp) {
        return otpService.verifyOtp(email, otp);
    }
}
