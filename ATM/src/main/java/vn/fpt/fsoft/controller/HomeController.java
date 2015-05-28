package vn.fpt.fsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/welcome")
	public String welcome(ModelMap modelMap) {

		return "Welcome";
	}

	@RequestMapping(value = "/home")
	public String home(ModelMap modelMap) {

		return "Home";
	}

	@RequestMapping(value = "/login")
	public String login() {

		return "login";
	}

}
