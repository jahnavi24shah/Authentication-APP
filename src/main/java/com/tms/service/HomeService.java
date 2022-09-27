package com.tms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.model.participantDO;
import com.tms.model.userDO;

@Service
public interface HomeService {

	List<participantDO> getParticipants(String username);

	String getSenseiName(String name);

	String getDojoName(String name);

	String addParticipant(String sname, int age, int height, int weight, String gender, String belt, String dojoName,
			String senseiName, String mobile, String tournamentName, String username);

	String checkParticipant(String sname, String mobile, String username);

	participantDO getParticipantValues(String sname, String mobile);

	String deleteParticipant(String sname, String mobile);

	String updateParticipant(String sname, int age, int height, int weight, String gender, String belt, String dojoName,
			String senseiName, String mobile, int rand);

	List<participantDO> boutMaker(int minAge, int maxAge, String belt, String gender);

	userDO getUserDetails(String email);

	int getUserId(String emailId);

	String updateMyProfile(String name, String mobile, String dojoName, String role, int id);

	String changePassword(String emailId, String password);

	String getName(String name);

	String changeEmail(String oldEmail, String newEmail);

	String getPassword(String email);

}
