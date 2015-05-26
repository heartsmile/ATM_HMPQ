package vn.fpt.fsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/auth")
public class UserController {

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String authentication(@RequestParam(value = "auth") String auth,@RequestParam(value = "pin") String pin){
		
		
	}
}
