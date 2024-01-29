package com.community.exchange.skill.controller;




import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.exchange.skill.DAO.Message;
import com.community.exchange.skill.DAO.Profile;
import com.community.exchange.skill.DAO.User;
import com.community.exchange.skill.exception.RegistractionException;
import com.community.exchange.skill.service.RegistractionService;
import com.community.exchange.skill.service.SkillService;
import com.community.exchange.skill.service.UserService;





@Controller
public class UserController {
	
	@Autowired UserService userService;
	@Autowired RegistractionService registrationService;
	@PostMapping("/addUser")
	public String addUser(
		@Valid @ModelAttribute("user") User user,  BindingResult result, Model model ) throws RegistractionException {
			
			System.out.println("inside registration controller");

			        if(result.hasErrors()){
			        	System.out.println(result);
			            return "registration";
			        }

			        
					try {
						registrationService.addUser(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RegistractionException("registration failed please contact admin for support");
					}
					model.addAttribute("dataSaved", "Registration successful");
					return "login";
				}
	
		
@PostMapping("/sendRequest")

public String sendingRequest(@ModelAttribute ("message") Message message, Model model,HttpSession session) {
	System.out.println("inside send message controller"+message.getReceiverUserName());
	userService.sendMessage(message,(String)session.getAttribute("userName"));
	model.addAttribute("requestSuccess", "Request Sent to the provider");
	return "home";
}

@GetMapping("/inbox")
public String showInbox(Model model, HttpSession session) {
    String receiverUserName = (String) session.getAttribute("userName");
    List<Message> messages = userService.getMessagesForUser(receiverUserName);
    model.addAttribute("messages", messages);
    return "inbox";
}
  
	}


