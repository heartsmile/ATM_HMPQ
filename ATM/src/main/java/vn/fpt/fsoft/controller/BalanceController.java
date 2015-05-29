package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.service.UserService;

@Component
@Controller
@SessionAttributes("card")
public class BalanceController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkbalance")
	public String checkBalance(ModelMap modelMap){
		Card card = (Card) modelMap.get("card");
		Float balance = userService.getAccount(card).getBalance();
		modelMap.addAttribute("balance", balance.intValue());
		return "checkbalance";
	}
	
}
