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

/**
 * @author QuanTA5
 *
 */
@Controller
@SessionAttributes("card")
public class WithdrawalController {

	@RequestMapping("/withdraw")
	public String withdrawHome() {

		return "Withdraw";
	}

	@RequestMapping("/recommendedValue")
	public String recommendedValue(@RequestParam(value = "moneyValue") String money,
			ModelMap modelMap) {

		modelMap.get("card");
		
		System.out.println("" + money);
		
		// get value of money from request

		// check balance of account

		if (true) {
			// if had enough money,
			// write log
			// dispense money
			//xoa toan bo session
			modelMap.clear();
			// show "get receipt?" screen
		} else {
			// show error screen
		}
		return "Welcome";
	}

	@RequestMapping("/submitOtherValue")
	public String submitOtherValue() {

		return "OtherValue";
	}
}
