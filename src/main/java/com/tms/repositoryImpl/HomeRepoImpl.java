package com.tms.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.dao.ParticipantDAO;
import com.tms.model.participantDO;
import com.tms.model.userDO;
import com.tms.repository.HomeRepo;

@Repository
public class HomeRepoImpl implements HomeRepo {

	@Autowired
	ParticipantDAO dao;
	
	@Override
	public List<participantDO> getParticipants(String username) {
		return dao.getParticipants(username.toLowerCase());
	}

	@Override
	public String getSenseiName(String name) {
		return dao.getSenseiName(name);
	}

	@Override
	public String getDojoName(String name) {
		return dao.getDojoName(name);
	}

	@Override
	public String addParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile, String tournamentName, String username) {
		return dao.addParticipant(sname, age, height, weight, gender, belt, dojoName, senseiName, mobile, tournamentName, username.toLowerCase());
	}

	@Override
	public String checkParticipant(String sname, String mobile, String username) {
		return dao.checkParticipant(sname, mobile, username.toLowerCase());
	}

	@Override
	public participantDO getParticipantValues(String sname, String mobile) {
		return dao.getParticipantValues(sname, mobile);
	}

	@Override
	public String deleteParticipant(String sname, String mobile) {
		return dao.deleteParticipant(sname, mobile);
	}

	@Override
	public String updateParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile, int rand) {
		return dao.updateParticipant(sname, age, height, weight, gender, belt, dojoName, senseiName, mobile, rand);
	}

	@Override
	public List<participantDO> boutMaker(int minAge, int maxAge, String belt, String gender) {
		return dao.boutMaker(minAge, maxAge, belt, gender);
	}

	@Override
	public userDO getUserDetails(String email) {
		return dao.getUserDetails(email.toLowerCase());
	}

	@Override
	public int getUserId(String emailId) {
		return dao.getUserId(emailId.toLowerCase());
	}

	@Override
	public String updateMyProfile(String name, String mobile, String dojoName, String role, int id) {
		return dao.updateMyProfile(name, mobile, dojoName, role, id);
	}

	@Override
	public String changePassword(String emailId, String password) {
		return dao.changePassword(emailId.toLowerCase(), password);
	}

	@Override
	public String getName(String name) {
		return dao.getName(name.toLowerCase());
	}

	@Override
	public String changeEmail(String oldEmail, String newEmail) {
		return dao.changeEmail(oldEmail, newEmail);
	}

	@Override
	public String getPassword(String email) {
		return dao.getPassword(email.toLowerCase());
	}

}