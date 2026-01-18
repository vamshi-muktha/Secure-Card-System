package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.OtpEntity;

public interface OtpRepo extends JpaRepository<OtpEntity, Long> {

	    Optional<OtpEntity> findByEmailAndOtp(String email, String otp);

	    void deleteByEmail(String email);
	}


