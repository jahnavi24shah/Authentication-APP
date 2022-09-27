package com.tms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ForgetPassRepo {

	public String getForgetPass(String email);
	
}
