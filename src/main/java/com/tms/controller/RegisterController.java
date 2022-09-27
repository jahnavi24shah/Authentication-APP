package com.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService register;

	@Value("${tokenPage}")
	private String tokenPage;

	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	@PostMapping("/register")
	public String register(ModelMap model,@RequestParam String uname,@RequestParam String password,@RequestParam String name,@RequestParam long mobile,@RequestParam String dojoName,@RequestParam String role) {
		String result=register.register(uname,password,name,mobile,dojoName,role);
		if(result.equalsIgnoreCase("success")) {
			String token=register.generateToken(uname);
			String activateLink = tokenPage+token+"&username="+uname;
			String regSucc = "You have been successfully registered, An activation link is sent to your email, Please activate your account before login!";
			model.put("regSuccessMessage", regSucc);
			String message = "Welcome to TMS.\n\nThank you for using us.\n\nYou have been registered successfully!\n\nNow you can login to TMS.\n\nYour username is "+uname+"\n\nYour password is "+password+"\n\nJust one more step to begin your journey. To activate your account please click -> "+activateLink;
			register.sendEmail(name,uname,"Registration Successful. Please verify your email",message);
			return "register";
		}
		else if(result.equalsIgnoreCase("duplicate")) {
			model.put("dupErrorMessage", "Account exists already! Please Login");
			return "register";
		}
		else {
			model.put("regErrorMessage", "Error while registering! Please try Later!");
			return "register";
		}
	}

	@GetMapping("/activateAccount")
	public String activateAccount(ModelMap model,@RequestParam String token, @RequestParam String username) {
		String check=register.checkUser(username);
		if(check.equalsIgnoreCase("pending")) {
			String result=register.activateAccount(token,username);
			if(result.equalsIgnoreCase("success"))
				model.put("success", "Your account has been activated! Please Login");
			else
				model.put("error", "Token mismatch. Contact tms.serviceportal@gmail.com");
		}
		else if (check.equalsIgnoreCase("activated"))
			model.put("error", "Already activated please login!");
		else if (check.equalsIgnoreCase("empty"))
			model.put("error", "User not found! Please Register first!");
		else
			model.put("error", "Try again later");
		return "activateAccount";
	}
}
