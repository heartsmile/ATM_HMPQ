/**
 * 
 */
package vn.fpt.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.model.Card;

/**
 * @author QuanTA5
 *
 */
@Controller
@SessionAttributes({ "card" })
public class WithdrawalController {

	@RequestMapping("/withdraw")
	public String withdrawHome() {

		return "Withdraw";
	}

	@RequestMapping("/recommendedValue")
	public String recommendedValue(
			@RequestParam(value = "moneyValue") String money, ModelMap modelMap) {

		String forward = "Welcome";

		Card card = (Card) modelMap.get("card");

		//System.out.println("" + card.getAccount());

		// get value of money from request
		System.out.println("" + money);
		// check balance of account
		// boolean isValidBalance = checkBalance(accountNo);

		if (true) {
			// if had enough money,
			
			// write log
			
			// dispense money
			
			// eject card
			modelMap.clear();

			
			// show "get receipt?" screen
			forward = "AskReceipt";
		}// else {
			// show error screen
		//}
		return forward;
	}

	@RequestMapping("/otherValue")
	public String otherValue() {
		
		return "InputOtherValue";
	}

	@RequestMapping("/submitOtherValue")
	public String submitOtherValue() {
		//validate input amount
		
		return "OtherValue";
	}
}
