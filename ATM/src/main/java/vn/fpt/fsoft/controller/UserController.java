package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.constant.Constant;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;
import vn.fpt.fsoft.service.UserService;

@Controller
@RequestMapping(value = "/auth")
@SessionAttributes(value = "card")
public class UserController {

	@Autowired
	private CardReader cardReader;
	@Autowired
	private Card card;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
	public String auth(@RequestParam(value = "pin") String pin, ModelMap map) {
		String forward = "Welcome";
		Card temp = (Card) map.get("card");
		int attempt = card.getAttempt();
		
		card.setCardNo(temp.getCardNo());
		card.setPIN(pin);
		cardReader.setCard(card);
		
		if(!userService.auth(cardReader, card, attempt)){
			
			if(attempt == 3){
				map.addAttribute("message", Constant.LOGIN_LOCK);
			}else{
				map.addAttribute("message", Constant.LOGIN_ERROR);
			}
			
			forward = "login";
		}
		
		map.addAttribute("attempt", attempt);
		map.addAttribute("card", card);

		return forward;
	}
}
