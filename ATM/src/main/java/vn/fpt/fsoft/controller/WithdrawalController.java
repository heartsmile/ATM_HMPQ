/**
 * 
 */
package vn.fpt.fsoft.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.fpt.fsoft.constant.Constant;
import vn.fpt.fsoft.model.Card;
import vn.fpt.fsoft.model.Money;
import vn.fpt.fsoft.service.WithdrawServices;

/**
 * @author QuanTA5
 *
 */
@Controller
@SessionAttributes({ "card", "msg", "listMoney", "receiptRequire" })
public class WithdrawalController {
		
	final static Logger logger = Logger.getLogger(WithdrawalController.class);
	
	@Autowired
	private WithdrawServices withdrawService;

	@Autowired
	private BalanceController blController;

	@RequestMapping("/withdraw")
	public String withdrawHome() {

		return "Withdraw";
	}

	@RequestMapping("/otherValue")
	public String otherValue() {

		return "InputOtherValue";
	}

	@RequestMapping(value = "/submitAmountMoney", method = RequestMethod.POST)
	public @ResponseBody String submitAmountMoney(
			@RequestParam(value = "amountMoney") String amountMoney,
			ModelMap modelMap) {

		String jsonResult = "{\"result\": \"0\",\"message\": \"Nothing\"}";
		String accountNo = ((Card) modelMap.get("card")).getAccountNo();

		int moneyAmount = 0;
		// validate input amount
		if ("".equals(amountMoney)) {

			// Invalid amount of money
			modelMap.addAttribute("msg", Constant.INVALID_AMOUNT);
			jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
			
			logger.info(Constant.INVALID_AMOUNT);
			
			return jsonResult;
		} else {
			moneyAmount = Integer.parseInt(amountMoney);
		}

		// validate moneyAmount
		if (moneyAmount % 50000 == 0 && moneyAmount != 0
				&& moneyAmount <= 10000000) { // If valid amount of money

			logger.info("Validate amount of money success!");
			
			// check balance
			blController.checkBalance(modelMap);
			float balance = (Float) modelMap.get("balance");
			if (moneyAmount <= balance) { // if had enough money

				// write log

				// dispense money
				List<Money> listMoney = withdrawService
						.dispenseCash(moneyAmount);

				// check if ATM has enough money
				if (listMoney.size() == 0) {

					// ATM doesn't have enough money
					modelMap.addAttribute("msg", Constant.ATM_NOT_SERVICE);
					jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
					
					logger.info("ATM don't have enough money.");
					
					return jsonResult;
				}

				// charge account balance
				Float remainingBalance = (balance - moneyAmount);

				if (withdrawService.changeAcountBalance(accountNo,
						remainingBalance)) {
					logger.info("Charge money successful!");
					
					// put list Money to modelMap and it will be get in JSP page
					// (receive money)
					modelMap.put("listMoney", listMoney);
					jsonResult = "{\"result\": \"success\",\"message\": \"Withdraw success\"}";
					
					logger.info("Withdraw successful!");					
				} else {

					// charge account balance fail
					modelMap.addAttribute("msg", Constant.ATM_NOT_SERVICE);
					jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
					
					logger.info("Charge account balance fail");
					return jsonResult;
				}

			} else {

				// Not enough balance
				modelMap.addAttribute("msg", Constant.NOT_ENOUGH_MONEY);
				jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
				
				logger.info("User doesn't have enough balance.");
			}

		} else {

			// Invalid amount of money
			modelMap.addAttribute("msg", Constant.INVALID_AMOUNT);
			jsonResult = "{\"result\": \"error\",\"message\": \"...\"}";
			
			logger.info("Invalid amount of money.");
		}

		return jsonResult;
	}

	@RequestMapping("/ejectCard")
	public String ejectCard(ModelMap modelMap) {

		modelMap.remove("card");
		modelMap.remove("msg");
		logger.info("Ejecting card.");

		return "EjectCard";
	}

	@RequestMapping("/ejectCardDone")
	public String ejectCardDone(ModelMap modelMap) {

		// check if have money if session
		@SuppressWarnings("unchecked")
		List<Money> listMoney = (List<Money>) modelMap.get("listMoney");
		if (listMoney != null) {
			return "ReturnMoney";
		}

		// for print check balance receipt
		// check if receipt require in session
		String ssReceiptRequire = (String) modelMap.get("receiptRequire");
		if (ssReceiptRequire != null) {
			boolean receiptRequire = Boolean.parseBoolean(ssReceiptRequire);
			if (receiptRequire) {
				return "PrintReceipt";
			}
		}

		return "Home";
	}

	@RequestMapping("/askReceipt")
	public String askReceipt() {

		return "AskReceipt";
	}

	@RequestMapping("/addReceiptRequire")
	public String addReceiptRequire(ModelMap modelMap) {

		modelMap.put("receiptRequire", true);

		return "TransactionProcess";
	}

	@RequestMapping("/printReceipt")
	public String printReceipt(ModelMap modelMap) {

		return "PrintReceipt";
	}

	@RequestMapping("/transactionProcess")
	public String transactionProcess(ModelMap modelMap) {

		return "TransactionProcess";
	}

	@RequestMapping("/returnMoneyDone")
	public String returnMoney(ModelMap modelMap) {

		// check if receipt require in session
		if (modelMap.containsKey("receiptRequire")) {
			boolean receiptRequire = (Boolean) modelMap.get("receiptRequire");
			if (receiptRequire) {
				return "PrintReceipt";
			}
		}

		return "Home";
	}

	@RequestMapping("/errorPage")
	public String errorPage(ModelMap modelMap) {

		return "ErrorPage";
	}
}
