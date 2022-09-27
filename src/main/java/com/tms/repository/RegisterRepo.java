package com.tms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo {
	
	public String register(String uname, String password, String name, long mobile, String dojoName,
			String role);

	public String generateToken(String uname);

	public String activateAccount(String token, String username);

	public String checkUser(String username);

}