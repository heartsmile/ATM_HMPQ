package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.fpt.fsoft.constant.UserConstant;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Controller
@RequestMapping(value = "/auth")
public class UserController {

	public static int login_cointer = 3;
	@Autowired
	private CardReader cardReader;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/loginprocess", method = RequestMethod.POST)
	public String auth(@RequestParam(value = "cardid") String cardID,
			@RequestParam(value = "pin") String pin, ModelMap map) {
		String forward = "asdfsdf";
		Card card = new Card();

		card.setCardNo(cardID);
		card.setPIN(pin);

		if (login_cointer > 0) {
			if (cardReader.validatePIN(card)) {
				
			} else {
				
				map.put("message", UserConstant.LOGIN_ERROR + (login_cointer - 1));
				login_cointer--;
				
				if(login_cointer == 0){
					map.put("message", UserConstant.LOGIN_LOCK);
				}
				
				forward = "login";
			}
		} 

		return forward;
	}
}
