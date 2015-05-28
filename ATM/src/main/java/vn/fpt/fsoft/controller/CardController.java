package vn.fpt.fsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.constant.Constant;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.CardReader;
import vn.fpt.fsoft.service.CardService;

@Controller
@RequestMapping(value = "/card")
@SessionAttributes(value = "card")
public class CardController {

	@Autowired
	private CardReader cardReader;
	@Autowired
	private CardService cardService;
	@Autowired
	private Card card;

	@RequestMapping(value = "/insert")
	public String home() {
		return "insertcard";
	}

	@RequestMapping(value = "/insertprocess", method = RequestMethod.POST)
	public String readCard(@RequestParam(value = "cardid") String cardNo,ModelMap map) {
		String forward = "Home";
		card.setCardNo(cardNo);
		cardReader.setCard(card);

		if (cardService.acceptCard(cardReader)) {
			
			if (cardService.validateCard(cardReader)) {
				map.addAttribute("card", card);
				forward = Constant.REDIRECT_LOGIN_VALIDATECARD;
			} else {
				
				map.addAttribute("message",Constant.CARD_INVALID);
			}
			
		} else {
			map.addAttribute("message",Constant.NOT_RECOGNIZE);
		}

		return forward;
	}
}
