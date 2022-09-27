package com.tms.dao;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tms.mapper.BoutMapper;
import com.tms.mapper.ParticipantMapper;
import com.tms.mapper.UserDetailsMapper;
import com.tms.mapper.UserMapper;
import com.tms.model.participantDO;
import com.tms.model.userDO;

@Repository
public class ParticipantDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${queryAddParticipant}")
	private String queryAddParticipant;

	@Value("${queryUpdateParticipant}")
	private String queryUpdateParticipant;

	@Value("${queryGetParticipantValue}")
	private String queryGetParticipantValue;

	@Value("${queryGetBoutDetails}")
	private String queryGetBoutDetails;

	@Value("${queryGetParticipantOfUser}")
	private String queryGetParticipantOfUser;

	@Value("${queryGetCheckParticipant}")
	private String queryGetCheckParticipant;

	@Value("${queryGetBoutDetails2}")
	private String queryGetBoutDetails2;

	@Value("${queryGetBoutDetails3}")
	private String queryGetBoutDetails3;

	@Value("${queryGetBoutDetails4}")
	private String queryGetBoutDetails4;

	@Value("${queryGetBoutDetails5}")
	private String queryGetBoutDetails5;

	@Value("${queryGetBoutDetails6}")
	private String queryGetBoutDetails6;

	@Value("${queryToDeleteParticipant}")
	private String queryToDeleteParticipant;

	@Value("${queryToGetMobileNumber}")
	private String queryToGetMobileNumber;

	@Value("${queryToGetUserDetails}")
	private String queryToGetUserDetails;

	@Value("${queryToGetUserId}")
	private String queryToGetUserId;

	@Value("${queryToGetUserEmail}")
	private String queryToGetUserEmail;

	@Value("${queryToGetUpdateProfile}")
	private String queryToGetUpdateProfile;

	@Value("${queryToChangeEmailofCreds}")
	private String queryToChangeEmailofCreds;

	@Value("${queryToChangeEmailofUsers}")
	private String queryToChangeEmailofUsers;

	@Value("${queryToChangeEmailofAuth}")
	private String queryToChangeEmailofAuth;

	@Value("${queryToChangeEmailofPart}")
	private String queryToChangeEmailofPart;

	@Value("${queryToChangePasswordOfCreds}")
	private String queryToChangePasswordOfCreds;

	@Value("${queryToChangePasswordOfUsers}")
	private String queryToChangePasswordOfUsers;

	@Value("${queryToGetDojoName}")
	private String queryToGetDojoName;

	@Value("${queryToGetSenseiName}")
	private String queryToGetSenseiName;

	@Value("{queryToGetPassword}")
	private String queryToGetPassword;

	@Value("{queryToGetName}")
	private String queryToGetName;

	public static Logger logger = LoggerFactory.getLogger(ParticipantDAO.class);

	public String addParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile,String tournamentName, String username) {
		String sql=queryAddParticipant;
		String op=null;
		int result=0;
		Long mob=Long.parseLong(mobile);
		Random random = new Random(); 
		int rand=random.nextInt(10000);
		try {
			result = jdbcTemplate.update(sql,rand,sname,age,height,weight,gender,belt,dojoName,senseiName,mob,tournamentName,username);
		}
		catch(DuplicateKeyException e) {
			op="duplicate";
		}
		catch (Exception e) {
			op = "error";
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result==1)
			return "success";
		else 
			return op;
	}

	public String updateParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile, int rand) {
		String sql=queryUpdateParticipant;
		int result=0;
		Long mobi=Long.parseLong(mobile);
		try {
			result = jdbcTemplate.update(sql,sname,age,height,weight,gender,belt,dojoName,senseiName,mobi,rand);
		}
		catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
			return "error";
		}
		if(result==1)
			return "success";
		else 
			return "error";
	}

	public String checkParticipant(String sname, String mobile, String username) {
		String sql=queryGetCheckParticipant;
		int result=0;
		String op=null;
		Long mob=Long.parseLong(mobile);
		try {
			result = jdbcTemplate.queryForObject(sql,new Object[] {sname,mob,username},Integer.class);
		}
		catch (EmptyResultDataAccessException e) {
			try {
				sql="select rand from participants where sname=? and mobile=?";
				result=jdbcTemplate.queryForObject(sql,new Object[] {sname,mob},Integer.class);
			}
			catch (EmptyResultDataAccessException e2) {
				return "realEmpty";
			}
			catch (Exception e1) {
				//System.out.println(e1);
				logger.error(e1.toString());
			}
			if(result>0) {
				op="empty";
				return "empty";
			}
		}
		catch (Exception e) {
			op="error";
			//System.out.println(e);
			logger.error(e.toString());
			return op;
		}
		if(result>1) {
			op="success";
			return "success";
		}
		return op;
	}

	public participantDO getParticipantValues(String sname, String mobile) {
		participantDO participant = null;
		String sql=queryGetParticipantValue;
		try {
			participant=jdbcTemplate.queryForObject(sql,new Object[] {sname,mobile},new ParticipantMapper());
		}
		catch (Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return participant;
	}

	public List<participantDO> boutMaker(int minAge, int maxAge, String belt, String gender) {
		List <participantDO> participant = null;
		String sql = queryGetBoutDetails;
		String sql2=queryGetBoutDetails2;
		String sql3=queryGetBoutDetails3;
		if(belt.equalsIgnoreCase("all")) {
			sql = queryGetBoutDetails4;
			sql2=queryGetBoutDetails5;
			sql3=queryGetBoutDetails6;
		}
		try {
			if(!belt.equalsIgnoreCase("all")) {
				if(minAge==18)
					participant=jdbcTemplate.query(sql2, new Object[] {minAge,belt,gender},new BoutMapper());
				else if(maxAge==18)
					participant=jdbcTemplate.query(sql3, new Object[] {minAge,belt,gender},new BoutMapper());
				else
					participant=jdbcTemplate.query(sql, new Object[] {minAge,maxAge,belt,gender},new BoutMapper());
			}
			else {
				if(minAge==18)
					participant=jdbcTemplate.query(sql2, new Object[] {minAge,gender},new BoutMapper());
				else if(maxAge==18)
					participant=jdbcTemplate.query(sql3, new Object[] {minAge,gender},new BoutMapper());
				else
					participant=jdbcTemplate.query(sql, new Object[] {minAge,maxAge,gender},new BoutMapper());
			}
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return participant;
	}

	public List<participantDO> getParticipants(String username) {
		List<participantDO> participant=null;
		String sql = queryGetParticipantOfUser;
		try {
			participant = jdbcTemplate.query(sql,new Object[] {username},new UserMapper());
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return participant;
	}

	public String deleteParticipant(String sname, String mobile) {
		String sql=queryToDeleteParticipant;
		int result=0;
		String op=null;
		Long mob=Long.parseLong(mobile);
		try {
			result = jdbcTemplate.update(sql,sname,mob);
		}
		catch (EmptyResultDataAccessException e) {
			op="empty";
			return op;
		}
		catch (Exception e) {
			op="error";
			//System.out.println(e);
			logger.error(e.toString());
			return op;
		}
		if(result==1) {
			op="success";
			return op;
		}
		return op;
	}

	public Long getMobile(String sname) {
		String sql=queryToGetMobileNumber;
		Long mob=null;
		try {
			mob=jdbcTemplate.queryForObject(sql,new Object[] {sname},Long.class);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return mob;
	}

	public userDO getUserDetails(String email) {
		String sql=queryToGetUserDetails;
		userDO user = new userDO();
		try {
			user=jdbcTemplate.queryForObject(sql, new Object[] {email},new UserDetailsMapper());
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return user;
	}

	public int getUserId(String email) {
		String sql=queryToGetUserId;
		int result=0;
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {email}, Integer.class);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return result;
	}

	public String getUserEmail(int id) {
		String sql=queryToGetUserEmail;
		String result=null;
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		return result;
	}

	public String updateMyProfile(String name, String mobile, String dojoName, String role, int id) {
		String sql=queryToGetUpdateProfile;
		int result=0;
		try {
			result=jdbcTemplate.update(sql,name,mobile,dojoName,role,id);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result==1)
			return "success";
		else
			return "error";
	}

	public String changePassword(String emailId, String password) {
		String sql=queryToChangePasswordOfCreds;
		String sql2=queryToChangePasswordOfUsers;
		int result=0;
		try {
			result=jdbcTemplate.update(sql,password,emailId);
			result=jdbcTemplate.update(sql2,password,emailId);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result==1)
			return "success";
		else
			return "error";
	}

	public String changeEmail(String oldEmail, String newEmail) {
		String sql1=queryToChangeEmailofCreds;
		String sql2=queryToChangeEmailofUsers;
		String sql3=queryToChangeEmailofAuth;
		String sql4=queryToChangeEmailofPart;
		int result=0;
		try {
			result=jdbcTemplate.update(sql1, newEmail, oldEmail);
			result=jdbcTemplate.update(sql2, newEmail, oldEmail);
			result=jdbcTemplate.update(sql3, newEmail, oldEmail);
			result=jdbcTemplate.update(sql4, newEmail, oldEmail);
		}
		catch(Exception e) {
			//System.out.println(e);
			logger.error(e.toString());
		}
		if(result>0)
			return "success";
		else
			return "error";
	}

	public String getDojoName(String name) {
		String sql= queryToGetDojoName;
		try {
			name=jdbcTemplate.queryForObject(sql, new Object[] {name} ,String.class);
		}
		catch (Exception e)
		{
			//System.out.println(name +" "+e);
			logger.error(e.toString());
		}
		return name;
	}

	public String getSenseiName(String name) {
		String sql= queryToGetSenseiName;
		String role="INSTRUCTOR";
		try {
			name=jdbcTemplate.queryForObject(sql, new Object[] {name,role} ,String.class);
			return name;
		}
		catch (Exception e)
		{
			//System.out.println(name +" "+e);
			logger.error(e.toString());
			return null;
		}
	}

	public String getName(String name) {
		String sql= "select name from creds where username=?";
		try {
			name=jdbcTemplate.queryForObject(sql, new Object[] {name} ,String.class);
		}
		catch (Exception e)
		{
			//System.out.println(name +" "+e);
			logger.error(e.toString());
		}
		return name;
	}

	public String getPassword(String email) {
		String sql="select password from users where username=?";
		String password=null;
		try {
			password=jdbcTemplate.queryForObject(sql, new Object[] {email}, String.class);
		}
		catch(Exception e) {
			//System.out.println(password+" "+e);
			logger.error(e.toString());
		}
		return password;
	}

}