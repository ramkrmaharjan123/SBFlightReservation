package com.kcing.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.dao.UserRepository;
import com.kcing.location.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegisterUser() {
		
		return "login/registerUser";
	}
	

//	@RequestMapping("/registerUser")
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,ModelMap modelMap) {
		User createUser = userRepository.save(user);
		
		modelMap.addAttribute("msg","Successfully created userID:"+createUser.getUserId());
		
		return "login/login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		
		if(user != null && user.getPassword().equals(password)) {
			return "flights";
		}else {
			modelMap.addAttribute("loginFailMSG","Invalid UserID or Password");
		}
		
		return "login/login";
	}

}
