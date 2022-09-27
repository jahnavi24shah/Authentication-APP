package com.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.service.ForgetPassService;
import com.tms.util.CommonUtility;

@Controller
public class SessionController {

	@Autowired
	CommonUtility com;

	@Autowired
	ForgetPassService service;

	@GetMapping("/login")
	public String showLoginPage(ModelMap model,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
            HttpServletRequest request) {
		if(error!=null) {
			model.addAttribute("error","Invalid username or password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	@GetMapping("/forget-password")
	public String showForgetPassPage() {
		return "forget-password";
	}

	@PostMapping("/forget-password")
	public String  getForgetPass(ModelMap model,@RequestParam String email) {
		String result = service.getForgetPass(email);
		if (result.equalsIgnoreCase("error")) {
			model.put("errorMessage", result);
			return "forget-password";
		}
		else if (result.equalsIgnoreCase("register")) {
			model.put("newUserMessage", "User does not exist! Please Register first");
			return "forget-password";
		}
		else {
			model.put("userPassword", "Your password has been sent on your registered email! Please check uou email.");
			com.sendEmail(" ",email, "Password to log in TMS", "Your password is "+result);
			return "forget-password";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

}