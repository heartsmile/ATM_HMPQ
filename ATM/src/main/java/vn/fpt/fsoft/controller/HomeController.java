package vn.fpt.fsoft.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String home(){
		
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String login(){
		
		return "login";
	}
}
