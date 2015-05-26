package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.constant.UserConstant;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Controller
@RequestMapping(value = "/auth")
@SessionAttributes(value = "card")
public class UserController {

	@Autowired
	private CardReader cardReader;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
	public String auth(@RequestParam(value = "pin") String pin, ModelMap map) {
		String forward = "asdfsdf";
		Card card = (Card) map.get("card");
		int attempt = card.getAttempt();

		card.setCardNo(card.getCardNo());
		card.setPIN(pin);
		cardReader.setCard(card);
		

		if (attempt <= 3) {
			
			if (cardReader.validatePIN()) {
				
			} else {
				
				if(attempt == 3){
					card.block();
					cardReader.swallowCard();
					map.put("attempt", attempt);
					map.put("message", UserConstant.LOGIN_LOCK);
				}else{
					map.put("message", UserConstant.LOGIN_ERROR + attempt);
				}
				
				forward = "login";
			}
		} 

		return forward;
	}
}
