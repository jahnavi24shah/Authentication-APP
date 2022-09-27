package com.tms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tms.model.userDO;


public class UserDetailsMapper implements RowMapper<userDO> {

	@Override
	public userDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		userDO user = new userDO();
		user.setName(rs.getString("name"));
		user.setMobile(rs.getLong("mobile"));
		user.setDojoName(rs.getString("dojoName"));
		user.setRole(rs.getString("role"));
		user.setEmail(rs.getString("username"));
		return user;
	}

}