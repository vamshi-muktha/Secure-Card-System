package com.example.demo.bean;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OtpEntity {





	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String email;
	    private String otp;
	    private LocalDateTime expiryTime;

	    public Long getId() { return id; }
	    public String getEmail() { return email; }
	    public String getOtp() { return otp; }
	    public LocalDateTime getExpiryTime() { return expiryTime; }

	    public void setEmail(String email) { this.email = email; }
	    public void setOtp(String otp) { this.otp = otp; }
	    public void setExpiryTime(LocalDateTime expiryTime) { this.expiryTime = expiryTime; }
	}


