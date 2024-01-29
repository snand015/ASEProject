package com.community.exchange.skill.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.community.exchange.skill.DAO.Login;
import com.community.exchange.skill.DAO.User;
import com.community.exchange.skill.exception.ApplicationException;
import com.community.exchange.skill.exception.UserNotFoundException;
import com.community.exchange.skill.service.UserService;



@Controller
@SessionAttributes("login")

public  class HomeController{
	@Autowired UserService userService;
	
	
	@GetMapping("/skillapp")
	public String gotoHome() {
		System.out.println("inside controller");
		return "index";
	}
	
	
	@PostMapping ("/login")
	public String gotoLogin( @ModelAttribute("login") Login login, HttpSession session ) throws  UserNotFoundException{
		System.out.println("inside login home"+login.getUserName());
	
		User user=userService.validateUser(login);
		
		System.out.println("landing on home");
		session.setAttribute("userName",login.getUserName() );
        	return "home";
        

		
	}

@GetMapping("/skill_profile")
public String createSkillProfile() {
	return "profile";
	
}
    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("Ending user session");
        session.removeAttribute("userName" );
        session.invalidate();
        //System.out.println(session.getAttribute("login"));
      

        return "index";

    }

	@GetMapping ("/register")
	public String gotoRegistration() {
		System.out.println("inside registration of home");
		return "createAccount";
	}
}