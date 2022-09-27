package com.tms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.repository.ForgetPassRepo;
import com.tms.service.ForgetPassService;

@Service
public class ForgetPassServiceImpl implements ForgetPassService{

	@Autowired
	ForgetPassRepo repo;

	@Override
	public String getForgetPass(String email) {
		return repo.getForgetPass(email);
	}
}