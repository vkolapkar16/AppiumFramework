package facade;

import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageFacade {

	public LoginPageFacade navigateToLoginPage() {
		new HomePage().clickOnMenu().clickMenutItems("Log In");
		return this;
	}
	
	public void performLogin() {
		new LoginPage().enterUsername("bob@example.com").enterPassword("10203040").clickonLoginBtn();
	}
}
