package com.tms.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.model.participantDO;
import com.tms.model.userDO;
import com.tms.service.HomeService;
import com.tms.util.CommonUtility;
import com.tms.util.ParticipantComparator;

@Controller
public class HomeController {

	static String name = "name";
	static String active = "active";
	static String admin = "admin";
	static String isAdmin = "isAdmin";

	@Autowired
	CommonUtility com;

	@Autowired
	HomeService homeService;

	@GetMapping("/")
	public String showDashboard(ModelMap model) {
		model.put(name, getLoggedInUserName());
		model.put("dashboard", active);
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		List <participantDO> participant = homeService.getParticipants(username);
		model.put("total",participant.size());
		model.put("participant", participant);
		return "welcome";
	}

	@GetMapping("/addParticipants")
	public String showParticipantsPage(ModelMap model) {
		model.put("addParticipants", active);
		String uname=getLoggedInUserName();
		model.put(name, uname);
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String dojoName=homeService.getDojoName(getLoggedInEmail());
		model.put("dojoName", dojoName);
		String senseiName=homeService.getSenseiName(getLoggedInEmail());
		if(senseiName!=null)
			model.put("senseiName", senseiName);
		return "addParticipants";
	}

	@PostMapping("/addParticipants")
	public String addParticipants(ModelMap model,
			@RequestParam String sname,@RequestParam int age,@RequestParam int height,@RequestParam int weight,
			@RequestParam String gender,@RequestParam String belt,@RequestParam String dojoName,@RequestParam String senseiName,
			@RequestParam String mobile, @RequestParam String tournamentName) {
		model.put("addParticipants", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		String result=homeService.addParticipant(sname,age,height,weight,gender,belt,dojoName,senseiName,mobile,tournamentName,username);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessage", "Participant has been successfully registered");
		}
		else if(result.equalsIgnoreCase("duplicate")) {
			model.put("duplicateMessage", "Participant exists already! Please update if any changes");
		}
		else {
			model.put("errorMessage", "Error while registering! Please try Later!");
		}
		return "addParticipants";
	}

	@GetMapping("/update-participant")
	public String showUpdateParticipantPage(ModelMap model) {
		model.put("update", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		return "update-participant";
	}

	@PostMapping("/update-participant")
	public String checkParticipantPage(ModelMap model,@RequestParam String sname,@RequestParam String mobile) {
		model.put("update", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		String result=homeService.checkParticipant(sname,mobile,username);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessage", "Participant found! Please update");
		}
		else if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", "Error while registering! Please try Later!");
		}
		else if (result.equalsIgnoreCase("empty")) {
			model.put("emptyMessage", "Participant doesn't exist! Please register first or maybe Participant was not registered by you!");
		}
		participantDO participant=homeService.getParticipantValues(sname,mobile);
		if(participant!=null) {
			model.put("rand", participant.getRand());
			model.put("sname", participant.getSname());
			model.put("age", participant.getAge());
			model.put("height", participant.getHeight());
			model.put("weight", participant.getWeight());
			model.put("gender", participant.getGender());
			model.put("belt", participant.getBelt());
			model.put("dojoName", participant.getDojoName());
			model.put("senseiName", participant.getSenseiName());
			model.put("mobile", participant.getMobile());
		}
		return "update-participant";
	}

	@GetMapping("/update-participant-filled")
	public String updateParticipantGet(ModelMap model,@RequestParam String sname,@RequestParam String mobile) {
		model.put("update", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		String result=homeService.checkParticipant(sname,mobile,username);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessage", "Participant found! Please update");
		}
		else if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", "Error while registering! Please try Later!");
		}
		else if (result.equalsIgnoreCase("empty")) {
			model.put("emptyMessage", "Participant doesn't exist! Please register first or maybe Participant was not registered by you!");
		}
		participantDO participant=homeService.getParticipantValues(sname,mobile);
		if(participant!=null) {
			model.put("rand", participant.getRand());
			model.put("sname", participant.getSname());
			model.put("age", participant.getAge());
			model.put("height", participant.getHeight());
			model.put("weight", participant.getWeight());
			model.put("gender", participant.getGender());
			model.put("belt", participant.getBelt());
			model.put("dojoName", participant.getDojoName());
			model.put("senseiName", participant.getSenseiName());
			model.put("mobile", participant.getMobile());
		}
		return "update-participant";
	}

	@GetMapping("/delete-participant")
	public String showDeleteParticipantPage(ModelMap model) {
		model.put("delete", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		return "delete-participant";
	}

	@PostMapping("/delete-participant")
	public String deleteParticipant(ModelMap model,@RequestParam String sname,@RequestParam String mobile) {
		model.put("delete", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		String result=homeService.checkParticipant(sname,mobile,username);
		String op="empty";
		if(result.equalsIgnoreCase("success"))
		{
			op=homeService.deleteParticipant(sname,mobile);
			if(op.equalsIgnoreCase("success")) {
				model.put("successMessage", "Participant deleted!");
			}
			else if (op.equalsIgnoreCase("error")) {
				model.put("errorMessage", "Error while deleting! Please try Later!");
			}
			else if (op.equalsIgnoreCase("empty")) {
				model.put("emptyMessage", "Participant doesn't exist! Please register first!");
			}
		}
		else if(result.equalsIgnoreCase("realEmpty"))
		{
			model.put("emptyMessage", "Participant doesn't exist! Please register first!");
		}
		else if(result.equalsIgnoreCase("empty"))
		{
			model.put("emptyMessage", "Participant not registered by you!");
		}
		else if(result.equalsIgnoreCase("error"))
		{
			model.put("emptyMessage", "Error while deleting! Please try Later!");
		}
		return "delete-participant";
	}

	@GetMapping("/delete-participant-filled")
	public String deleteParticipantGet(ModelMap model,@RequestParam String sname,@RequestParam String mobile) {
		model.put("delete", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String username=getLoggedInEmail();
		String result=homeService.checkParticipant(sname,mobile,username);
		if(result.equalsIgnoreCase("success"))
			result=homeService.deleteParticipant(sname,mobile);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessage", "Participant deleted!");
		}
		else if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", "Error while deleting! Please try Later!");
		}
		else if (result.equalsIgnoreCase("empty")) {
			model.put("emptyMessage", "Participant doesn't exist! Please register first or maybe Participant was not registered by you!");
		}
		return "delete-participant";
	}

	@PostMapping("/updateParticipantValue")
	public String updateParticipantValue(ModelMap model,
			@RequestParam String sname,@RequestParam int age,@RequestParam int height,@RequestParam int weight,
			@RequestParam String gender,@RequestParam String belt,@RequestParam String dojoName,@RequestParam String senseiName,
			@RequestParam String mobile, @RequestParam int rand) {
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String result=homeService.updateParticipant(sname,age,height,weight,gender,belt,dojoName,senseiName,mobile,rand);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessageUpdate", "Participant has been successfully updated");
		}
		else {
			model.put("errorMessageUpdate", "Error while updating! Please try Later!");
		}
		return "update-participant";
	}

	@GetMapping("/boutMaker")
	public String showBoutMakerPage(ModelMap model) {
		model.put("boutMaker", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		return "boutMaker";
	}

	@GetMapping("/bout")
	public String showBoutPage(ModelMap model) {
		model.put("bout", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		return "bout";
	}

	@PostMapping("/bout")
	public String boutMaker(ModelMap model,@RequestParam int minAge, @RequestParam int maxAge, @RequestParam String belt, @RequestParam String gender) {
		model.put("bout", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		if(minAge>maxAge){
			model.put("errorMessage", "Max Age should be greater than Min Age");
		}
		else {
			List <participantDO> participant = homeService.boutMaker(minAge,maxAge,belt,gender);
			/*Collections.sort(participant, (p1, p2) -> p1.getAge() - (p2.getAge()));*/
			Collections.sort(participant, new ParticipantComparator());
			model.put("total",participant.size());
			model.put("participant", participant);
		}
		return "bout";
	}

	@GetMapping("/myProfile")
	public String showProfilePage(ModelMap model) {
		model.put("profile", active);
		model.put(name, getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String email=getLoggedInEmail();
		userDO user = homeService.getUserDetails(email);
		model.put("user", user);
		return "myProfile";
	}

	@PostMapping("/updateMyProfile")
	public String updateMyProfile(ModelMap model,@RequestParam String name,@RequestParam String mobile,
			@RequestParam String dojoName,@RequestParam String role) {
		model.put("profile", active);
		model.put("name", getLoggedInUserName());
		if(isAdmin()) {
			model.put(admin, isAdmin);
		}
		String emailId=getLoggedInEmail();
		int id=homeService.getUserId(emailId);
		String result=homeService.updateMyProfile(name,mobile,dojoName,role,id);
		if(result.equalsIgnoreCase("success")) {
			model.put("successMessage", "Profile updated successfully!");
			com.sendEmail(getLoggedInUserName(),emailId, "Your Profile has been updated successfully!\n\n", "Updated Profile details are:-\nName:- "+name+"\nMobile:- "+mobile+"\nDojo Name:- "+dojoName+"\nDesignation"+role);
		}
		else {
			model.put("errorMessage", "Error while updating! Please try Later!");
		}
		return "myProfile";
	}

	@PostMapping("/changePassword")
	public String changePassword(ModelMap model,@RequestParam String passwordOld, @RequestParam String passwordNew) {
		String emailId=getLoggedInEmail();
		String oldPassword = getLoggedInEmailPassword(emailId);
		if(!passwordNew.equals(passwordOld)) {
			if(passwordOld.equals(oldPassword)) {
				String result=homeService.changePassword(emailId,passwordNew);
				if(result.equalsIgnoreCase("success")) {
					model.put("successMessageCP", "Password changed successfully!");
					com.sendEmail(getLoggedInUserName(),emailId, "Password changed successfully!", "Password changed successfully to "+passwordNew);
				}
				else {
					model.put("errorMessageCP", "Error while changing password! Please try Later!");
				}
			}
			else
				model.put("errorMessageCP", "Incorrect Password! Please try again with correct Password!");
		}
		else
			model.put("errorMessageCP", "Password cannot be same as earlier!");
		return "myProfile";
	}

	@PostMapping("/changeEmail")
	public String changeEmail(ModelMap model,@RequestParam String newEmail,@RequestParam String password) {
		String oldEmail=getLoggedInEmail();
		if(!oldEmail.equalsIgnoreCase(newEmail))
		{
			if(password.equals(getLoggedInEmailPassword(oldEmail))) {
				String result=homeService.changeEmail(oldEmail,newEmail);
				if(result.equalsIgnoreCase("success")) {
					model.put("successMessageCE", "Email changed successfully! Please Login again!");
				}
				else {
					model.put("errorMessageCE", "Error while changing password! Please try Later!");
				}
			}
			else {
				model.put("errorMessageCE", "Incorrect Password! Please try again with correct Password!");
			}
		}
		else
			model.put("errorMessageCE", "Email cannot be same as earlier!");
		return "myProfile";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String namee = ((UserDetails) principal).getUsername();
			return homeService.getName(namee);
		}

		return principal.toString();
	}

	private String getLoggedInEmail() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	private String getLoggedInEmailPassword(String email) {
		return (homeService.getPassword(email));
	}

	public boolean isAdmin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role=auth.getAuthorities().toString();
		if(role.equalsIgnoreCase("[ROLE_ADMIN]"))
			return true;
		else
			return false;
	}

}