package vn.fpt.fsoft.constant;

public interface Constant {

	String LOGIN_ERROR = "you enter the wrong password, please try again!";
	String LOGIN_LOCK= "Your card is lock";
	String CARD_INVALID = "<html>Card is invalid<br>Eject card...</html>";
	String NOT_RECOGNIZE = "<html>System does not recognize ATM card<br>Eject card...</html>";
	String REDIRECT_LOGIN_VALIDATECARD = "redirect:/auth/login";
}
