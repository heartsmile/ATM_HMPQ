package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;

@Controller
@RequestMapping(value = "/card")
@SessionAttributes(value = "card")
public class CardController {

	@Autowired
	private CardReader cardReader;

	@RequestMapping(value = "/insert")
	public String home() {
		return "insertcard";
	}

	@RequestMapping(value = "/insertprocess", method = RequestMethod.POST)
	public String readCard(@RequestParam(value = "cardid") String cardNo,
			ModelMap map) {
		String forward = "insertcard";
		Card card = new Card();
		card.setCardNo(cardNo);
		cardReader.setCard(card);

		if (cardReader.acceptCard()) {
			
			if (cardReader.validateCard()) {
				map.addAttribute("card", card);
				forward = "redirect:/auth/login";
			} else {
				
				map.addAttribute("message","<html>Card is invalid<br>Eject card...</html>");
			}
			
		} else {
			
			map.addAttribute("message","<html>System does not recognize ATM card<br>Eject card...</html>");
		}

		return forward;
	}
}
