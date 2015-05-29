package vn.fpt.fsoft.constant;

public interface Constant {

	String LOGIN_ERROR = "you enter the wrong password, please try again!";
	String LOGIN_LOCK= "Your card is lock";
	String CARD_INVALID = "<html>Card is invalid<br>Eject card...</html>";
	String NOT_RECOGNIZE = "<html>System does not recognize ATM card<br>Eject card...</html>";
	String REDIRECT_LOGIN_VALIDATECARD = "redirect:/auth/login";
	//QUANTA5
	String NOT_ENOUGH_MONEY = "Your current balance not enough, please try again!";
	String INVALID_AMOUNT = "Invalid amount of money, please try again!";
	String ATM_NOT_SERVICE = "Sorry, ATM is out of service, please try again later!";
	
	String NOT_PRINT_RECEIPT = "Please receive your card!";
	String PRINT_RECEIPT = "Printing receipt... Please receive your card and receipt!";
}
