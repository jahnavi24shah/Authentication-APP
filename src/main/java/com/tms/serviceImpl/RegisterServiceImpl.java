package com.tms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.repository.RegisterRepo;
import com.tms.service.RegisterService;
import com.tms.util.CommonUtility;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterRepo repo;
	
	@Autowired
	CommonUtility com;
	
	public String register(String uname, String password, String name, long mobile, String dojoName,
			String role) {
		return repo.register(uname,password,name,mobile,dojoName,role);
	}

	@Override
	public void sendEmail(String name,String uname, String regSucc, String message) {
		com.sendEmail(name,uname.toLowerCase(), regSucc, message);
	}

	@Override
	public String generateToken(String uname) {
		return repo.generateToken(uname);
	}

	@Override
	public String activateAccount(String token, String username) {
		return repo.activateAccount(token,username);
	}

	@Override
	public String checkUser(String username) {
		return repo.checkUser(username);
	}

}