package com.test;

import static com.driver.DriverManager.getDriver;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.driver.AndroidDriverSetup;
import com.driver.Driver;
import com.driver.DriverManager;
import com.pages.HomePage;
import com.pages.LoginPage;

import facade.LoginPageFacade;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class TC_001_UserLogin extends BaseTest

{			
		@Test
		public void userLogin() throws InterruptedException
		{
			new LoginPageFacade().navigateToLoginPage().performLogin();
			Thread.sleep(5000);

		}
		
		
}
