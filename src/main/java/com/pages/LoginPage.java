package com.pages;

import static com.driver.DriverManager.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;import com.driver.AndroidDriverSetup;
import com.driver.DriverManager;
import com.driver.LocalDriverImpl;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage{

	 @AndroidFindBy(accessibility= "Username input field")
	 private WebElement usernamefield;
	 
	 @AndroidFindBy(accessibility= "Password input field")
	 private WebElement passwordfield;
	 
	 @AndroidFindBy(accessibility= "Login button")
	 private WebElement loginbtn;
	 
	 public LoginPage(){
			PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	 
	 public LoginPage enterUsername(String Username) {
		 sendkeys(usernamefield, Username);
		 return this;
	 }
	 
	 public LoginPage enterPassword(String password) {
		 sendkeys(passwordfield, password);
		 return this;
	 }

	 public void clickonLoginBtn() {
		 click(loginbtn, "Login");
	 }
	 
}
