package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.dao.StockDao;
import vn.fpt.fsoft.model.Card;

@Controller
@SessionAttributes("card")
public class HomeController {
	
	@Autowired
	private Card card;
	
	@RequestMapping(value = "/welcome")
	public String welcome(ModelMap modelMap){	
		card.setCardNo("123");
		card.setAccountNo("563658956854752");
		card.setPIN("1235");
		modelMap.put("card", card);
		
		//stDao.getMoneyList(1);
		
		return "Welcome";
	}
	
	@RequestMapping(value = "/home")
	public String home(ModelMap modelMap){
		
		modelMap.put("card", card);
		
		return "Home";
	}
	
	@RequestMapping(value = "/login")
	public String login(){
		
		return "login";
	}

	
}
