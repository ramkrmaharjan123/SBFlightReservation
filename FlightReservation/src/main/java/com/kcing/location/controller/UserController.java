package com.kcing.location.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.dao.UserRepository;
import com.kcing.location.entities.User;
import com.kcing.location.service.interfaces.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showReg")
	public String showRegisterUser() {
		
		logger.info(">>showRegisterUser");
		
		return "login/registerUser";
	}
	
	@RequestMapping("/showloginPage")
	public String showLoginPage() {
		
		return "login/login";
	}
	
	

//	@RequestMapping("/registerUser")
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,ModelMap modelMap) {
		user.setPassword(encoder.encode(user.getPassword()));
		User createUser = userRepository.save(user);
		
		modelMap.addAttribute("msg","Successfully created userID:"+createUser.getUserId());
		
		return "login/login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
//		User user = userRepository.findByEmail(email);
		boolean result = securityService.login(email, password);
//		if(user != null && user.getPassword().equals(password)) {
		if(result) {
			return "flights";
		}else {
			modelMap.addAttribute("loginFailMSG","Invalid UserID or Password");
		}
		
		return "login/login";
	}

}
