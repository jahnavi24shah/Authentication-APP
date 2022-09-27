package com.tms.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.dao.registerDAO;
import com.tms.repository.RegisterRepo;

@Repository
public class RegisterRepoImpl implements RegisterRepo {

	@Autowired
	registerDAO dao;

	public String register(String uname, String password, String name, long mobile, String dojoName,
			String role) {
		return (dao.register(uname.toLowerCase(),password,name,mobile,dojoName,role));
	}

	@Override
	public String generateToken(String uname) {
		return (dao.generateToken(uname.toLowerCase()));
	}

	@Override
	public String activateAccount(String token, String username) {
		return (dao.activateAccount(token,username.toLowerCase()));
	}

	@Override
	public String checkUser(String username) {
		return (dao.checkUser(username.toLowerCase()));
	}

}