package vn.fpt.fsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam(value = "j_username") String username,
			@RequestParam(value = "j_password") String password) {
		if (username.equals("admin"))
			System.out.println("admin just login!");
		return "home";
	}
}
