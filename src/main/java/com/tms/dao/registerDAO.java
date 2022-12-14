package com.tms.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class registerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${queryUserRegistration}")
	private String queryUserRegistration;

	@Value("${queryUserAuthentication}")
	private String queryUserAuthentication;

	@Value("${queryUserAuthenticationRole}")
	private String queryUserAuthenticationRole;
	
	public static Logger logger = LoggerFactory.getLogger(registerDAO.class);
	
	public String register(String uname, String password, String name, long mobile, String dojoName,
			String role) {
		int result=0;
		int res=0;
		int res2=0;
		String op=null;
		String sql1=queryUserRegistration;
		String sql2=queryUserAuthentication;
		String sql3=queryUserAuthenticationRole;
		String auth="ROLE_USER";
		try {
			result=jdbcTemplate.update(sql1,uname,password,name,mobile,dojoName,role);
			res=jdbcTemplate.update(sql2,uname,password,true);
			res2=jdbcTemplate.update(sql3,uname,auth);
		}
		catch (DuplicateKeyException e) {
			op = "duplicate";
		}
		catch (Exception e) {
			op = "error";
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result==1 && res==1 && res2==1)
			return "success";
		else 
			return op;
	}

	public String generateToken(String email) {
		String token = RandomStringUtils.random(11, true, true);
		String sql="insert into regtoken(username,token) values (?,?)";
		try {
			jdbcTemplate.update(sql, email, token);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return token;
	}

	public String activateAccount(String token, String username) {
		String sql1="select id from regtoken where username=? and token=?";
		String sql2="update users set enabled=? where username=?";
		String sql3="delete from regtoken where username=?";
		int result=0;
		try {
			result = jdbcTemplate.queryForObject(sql1,new Object[] {username,token},Integer.class);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result>0) {
			try {
				result=jdbcTemplate.update(sql2,true,username);
				jdbcTemplate.update(sql3,username);
			}
			catch(Exception e) {
				//System.out.println(e);
				logger.error(e.toString());
				return "error";
			}
			if (result==1)
				return "success";
		}
		return "error";
	}

	public String checkUser(String username) {
		String sql = "select enabled from users where username=?";
		Boolean result=false;
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {username},Boolean.class);
		}
		catch (EmptyResultDataAccessException e) {
			return "empty";
		}
		catch (Exception e) {
			logger.error(e.toString());
			return "error";
		}
		if(result)
			return "activated";
		else
			return "pending";
	}

}