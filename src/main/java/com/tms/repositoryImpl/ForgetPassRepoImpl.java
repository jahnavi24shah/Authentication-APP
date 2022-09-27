package com.tms.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.dao.ForgetPassDAO;
import com.tms.repository.ForgetPassRepo;

@Repository
public class ForgetPassRepoImpl implements ForgetPassRepo{

	@Autowired
	ForgetPassDAO dao;

	@Override
	public String getForgetPass(String email) {
		String result = dao.getForgetPass(email.toLowerCase());
		return result;
	}
}
