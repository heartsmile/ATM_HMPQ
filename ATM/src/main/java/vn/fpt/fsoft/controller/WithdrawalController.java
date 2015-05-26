/**
 * 
 */
package vn.fpt.fsoft.controller;

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
}
