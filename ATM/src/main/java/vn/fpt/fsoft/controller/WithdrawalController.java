/**
 * 
 */
package vn.fpt.fsoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.constant.Constant;
import vn.fpt.fsoft.model.Money;
import vn.fpt.fsoft.service.WithdrawServices;

/**
 * @author QuanTA5
 *
 */
@Controller
@SessionAttributes({ "card", "msg" })
public class WithdrawalController {

	@Autowired
	private WithdrawServices withdrawService;

	@Autowired
	private BalanceController blController;

	@RequestMapping("/withdraw")
	public String withdrawHome() {

		return "Withdraw";
	}

	/*@RequestMapping("/recommendedValue")
	public String recommendedValue(
			@RequestParam(value = "moneyValue") String money, ModelMap modelMap) {

		String forward = "Welcome";

		// Card card = (Card) modelMap.get("card");

		// get value of money from request
		// System.out.println("" + money);

		// check balance and add to modelMap
		blController.checkBalance(modelMap);
		float balance = (Float) modelMap.get("balance");
		if (Float.parseFloat(money) <= balance) {
			// if had enough money,

			// write log

			// dispense money
			// if (money != null) {
			List<Money> listMoney = withdrawService.dispenseCash(Integer
					.parseInt(money));
			for (Money m : listMoney) {
				System.out.println(m.getValue() + ": " + m.getQuantity());
			}
			forward = "AskReceipt";
			// }
			
			 modelMap.put("listMoney", listMoney); 
			 // eject card
			 ejectCard(modelMap); 
			 // show "get receipt?" screen 
			// forward = "AskReceipt"; }
			 
		} else {
			// show error screen
		}
		return forward;
	}*/

	@RequestMapping("/otherValue")
	public String otherValue() {

		return "InputOtherValue";
	}

	@RequestMapping(value = "/submitAmountMoney", method = RequestMethod.POST)
	public @ResponseBody String submitAmountMoney(@RequestParam(value = "amountMoney") String amountMoney,
			ModelMap modelMap) {

		String jsonResult = "{\"result\": \"0\",\"message\": \"Nothing\"}";
		
		// validate input amount
		String a = amountMoney;
		int moneyAmount = Integer.parseInt(a);

		// check balance
		blController.checkBalance(modelMap);
		float balance = (Float) modelMap.get("balance");
		if (moneyAmount <= balance) {	// if had enough money
			
			// write log

			//validate moneyAmount
			if (moneyAmount % 50000 == 0) {		// If valid amount of money
				
				// dispense money
				List<Money> listMoney = withdrawService
						.dispenseCash(moneyAmount);
				
				//check if ATM has enough money
				if(listMoney.size() == 0){
					
					// ATM doesn't have enough money
					modelMap.addAttribute("msg", Constant.ATM_NOT_SERVICE);
					jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
					return jsonResult;
				}
				
				//put list Money to modelMap and it will be get in JSP page
				modelMap.put("listMoney", listMoney);
				jsonResult = "{\"result\": \"success\",\"message\": \"Withdraw success\"}";
			} else {
				
				// Invalid amount of money
				modelMap.addAttribute("msg", Constant.INVALID_AMOUNT);
				jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
			}
		} else {
			
			// Not enough money
			modelMap.addAttribute("msg", Constant.NOT_ENOUGH_MONEY);
			jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
		}

		return jsonResult;
	}

	@RequestMapping("/ejectCard")
	public String ejectCard(ModelMap modelMap) {

		modelMap.remove("card");

		return "EjectCard";
	}
	
	@RequestMapping("/askReceipt")
	public String askReceipt() {
		
		return "AskReceipt";
	}

	@RequestMapping("/printReceipt")
	public String printReceipt(ModelMap modelMap) {
		
		//eject card
		ejectCard(modelMap);
		
		return "PrintReceipt";
	}

	@RequestMapping("/returnMoney")
	public String returnMoney(ModelMap modelMap) {

		return "ReturnMoney";
	}
	
	@RequestMapping("/errorPage")
	public String errorPage(ModelMap modelMap) {

		return "ErrorPage";
	}
}
