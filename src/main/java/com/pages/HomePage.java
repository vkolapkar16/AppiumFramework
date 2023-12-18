package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static com.driver.DriverManager.getDriver;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;




public class HomePage 
{
    @AndroidFindBy(accessibility = "open menu")
    private WebElement openmenu;
	
	public HomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	public SideMenuBar clickOnMenu()
	{
		openmenu.click();
		return new SideMenuBar();
	}

}
