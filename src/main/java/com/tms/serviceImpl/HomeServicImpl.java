package com.tms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.participantDO;
import com.tms.model.userDO;
import com.tms.repository.HomeRepo;
import com.tms.service.HomeService;

@Service
public class HomeServicImpl implements HomeService {

	@Autowired
	HomeRepo homeRepo;
	
	@Override
	public List<participantDO> getParticipants(String username) {
		return homeRepo.getParticipants(username);
	}

	@Override
	public String getSenseiName(String name) {
		return homeRepo.getSenseiName(name);
	}

	@Override
	public String getDojoName(String name) {
		return homeRepo.getDojoName(name);
	}

	@Override
	public String addParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile, String tournamentName, String username) {
		return homeRepo.addParticipant(sname,age,height,weight,gender,belt,dojoName,senseiName,mobile,tournamentName,username);
	}

	@Override
	public String checkParticipant(String sname, String mobile, String username) {
		return homeRepo.checkParticipant(sname,mobile,username);
	}

	@Override
	public participantDO getParticipantValues(String sname, String mobile) {
		return homeRepo.getParticipantValues(sname,mobile);
	}

	@Override
	public String deleteParticipant(String sname, String mobile) {
		return homeRepo.deleteParticipant(sname, mobile);
	}

	@Override
	public String updateParticipant(String sname, int age, int height, int weight, String gender, String belt,
			String dojoName, String senseiName, String mobile, int rand) {
		return homeRepo.updateParticipant(sname, age, height, weight, gender, belt, dojoName, senseiName, mobile, rand);
	}

	@Override
	public List<participantDO> boutMaker(int minAge, int maxAge, String belt, String gender) {
		return homeRepo.boutMaker(minAge, maxAge, belt, gender);
	}

	@Override
	public userDO getUserDetails(String email) {
		return homeRepo.getUserDetails(email);
	}

	@Override
	public int getUserId(String emailId) {
		return homeRepo.getUserId(emailId);
	}

	@Override
	public String updateMyProfile(String name, String mobile, String dojoName, String role, int id) {
		return homeRepo.updateMyProfile(name, mobile, dojoName, role, id);
	}

	@Override
	public String changePassword(String emailId, String password) {
		return homeRepo.changePassword(emailId, password);
	}

	@Override
	public String getName(String name) {
		return homeRepo.getName(name);
	}

	@Override
	public String changeEmail(String oldEmail, String newEmail) {
		return homeRepo.changeEmail(oldEmail,newEmail);
	}

	@Override
	public String getPassword(String email) {
		return homeRepo.getPassword(email);
	}
	
}