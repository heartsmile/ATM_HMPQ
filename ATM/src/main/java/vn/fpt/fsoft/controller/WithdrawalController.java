/**
 * 
 */
package vn.fpt.fsoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.fpt.fsoft.model.Money;
import vn.fpt.fsoft.service.WithdrawServices;

/**
 * @author QuanTA5
 *
 */
@Controller
@SessionAttributes({ "card" })
public class WithdrawalController {

	@Autowired
	private WithdrawServices withdrawService;

	@RequestMapping("/withdraw")
	public String withdrawHome() {

		return "Withdraw";
	}

	@RequestMapping("/recommendedValue")
	public String recommendedValue(
			@RequestParam(value = "moneyValue") String money, ModelMap modelMap) {

		String forward = "Welcome";

		//Card card = (Card) modelMap.get("card");

		// get value of money from request
		//System.out.println("" + money);
		
		//check balance and add to modelMap
		//(new BalanceController()).checkBalance(modelMap);
		//float balance = (Float)modelMap.get("balance");
		//if (Float.parseFloat(money) <= balance) {
			// if had enough money,
			
			// write log

			// dispense money
			//if (money != null) {
				List<Money> listMoney = withdrawService.dispenseCash(Integer
						.parseInt(money));
				for(Money m : listMoney){
					System.out.println(m.getValue() + ": " + m.getQuantity());
				}
				/*modelMap.put("listMoney", listMoney);
				// eject card
				// ejectCard(modelMap);
				// show "get receipt?" screen
				forward = "AskReceipt";
			}*/
		//} else {
			//show error screen
		//}
		return forward;
	}

	@RequestMapping("/otherValue")
	public String otherValue() {

		return "InputOtherValue";
	}

	@RequestMapping("/submitOtherValue")
	public String submitOtherValue() {
		// validate input amount

		return "OtherValue";
	}

	@RequestMapping("/ejectCard")
	public String ejectCard(ModelMap modelMap) {

		modelMap.remove("card");

		return "EjectCard";
	}

	@RequestMapping("/printReceipt")
	public String printReceipt() {

		return "PrintReceipt";
	}

	@RequestMapping("/returnMoney")
	public String returnMoney(ModelMap modelMap) {

		return "ReturnMoney";
	}
}
