package com.example.demo.service;



import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.MailFeignClient;
import com.example.demo.bean.MailRequest;
import com.example.demo.bean.OtpEntity;
import com.example.demo.repo.OtpRepo;

@Service
public class OtpService {

    @Autowired
    private OtpRepo otpRepository;

//    @Autowired
//    private JavaMailSender mailSender;
    
    @Autowired
    MailFeignClient mfc;

    public void sendOtp(String email) {

//        otpRepository.deleteByEmail(email);

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        OtpEntity entity = new OtpEntity();
        entity.setEmail(email);
        entity.setOtp(otp);
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(entity);

        MailRequest request = new MailRequest();
        request.setTo(email);
        request.setSubject("Your OTP Verification Code");
        request.setBody("Your OTP is: " + otp + "\nValid for 5 minutes.");

        mfc.sendMail(request);
    }

    public boolean verifyOtp(String email, String otp) {

        return otpRepository.findByEmailAndOtp(email, otp)
                .filter(o -> o.getExpiryTime().isAfter(LocalDateTime.now()))
                .map(o -> {
                    otpRepository.delete(o);
                    return true;
                })
                .orElse(false);
    }
}
