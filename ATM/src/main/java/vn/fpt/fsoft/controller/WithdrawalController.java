/**
 * 
 */
package vn.fpt.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author QuanTA5
 *
 */
@Controller
public class WithdrawalController {
	
	@RequestMapping("/withdraw")
	public String withdrawHome() {
		
		return "WithDraw";
	}
	
	@RequestMapping("/recommendedValue")
	public String recommendedValue(HttpServletRequest request, HttpServletResponse response) {
		
		//get value of money from request
		
		//check balance of account
		if(true){
			//if had enough money, 
				//write log
				//dispense money
				//eject card
			//show "get receipt?" screen
		} else {
			//show error screen
		}
		return "";
	}
	
	@RequestMapping("/enterOther")
	public String enterOther() {
		
		return "OtherValue";
	}
	
	@RequestMapping("/submitOtherValue")
	public String submitOtherValue() {
		
		return "OtherValue";
	}
}
