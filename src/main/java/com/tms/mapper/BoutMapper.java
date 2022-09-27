package com.tms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tms.model.participantDO;

public class BoutMapper implements RowMapper<participantDO> {

	@Override
	public participantDO mapRow(ResultSet rs,int rowNum) throws SQLException {
		participantDO participant = new participantDO();
		participant.setSname(rs.getString("sname"));
		participant.setAge(rs.getInt("age"));
		participant.setHeight(rs.getInt("height"));
		participant.setWeight(rs.getInt("weight"));
		participant.setBelt(rs.getString("belt"));
		participant.setGender(rs.getString("gender").charAt(0));
		participant.setDojoName(rs.getString("dojoName"));
		return participant;
	}

}
