package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class OtpBackendApplication {

	public static void main(String[] args) {
		System.out.println("Otp started");
		SpringApplication.run(OtpBackendApplication.class, args);
	}

}
