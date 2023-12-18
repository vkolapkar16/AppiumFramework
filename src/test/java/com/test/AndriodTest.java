package com.test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class AndriodTest 
{

	@Test (priority = 1)
	public void andriodLaunchTest() throws InterruptedException, MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Andriod");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName("OnePlus&");
		options.setApp(System.getProperty("user.dir")+"/Apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
	
		AndroidDriver driver = new AndroidDriver (new URL("http://127.0.0.1:4723"),options);
		Thread.sleep(10000);
    
	driver.findElement(AppiumBy.accessibilityId("open menu")).click();
	Thread.sleep(10000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Log In\"]")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Login button")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")).click();
	Thread.sleep(5000);
	String itemnos=driver.findElement(AppiumBy.accessibilityId("total number")).getText();
	assertEquals(itemnos, "2 items");
	System.out.println("No of items placed :" + itemnos);
	Thread.sleep(5000);
	String totalprice=driver.findElement(AppiumBy.accessibilityId("total price")).getText();
	assertEquals(totalprice,"$59.98");
	System.out.println("Total Price : " + totalprice);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).click();
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Test User");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("ABC Chowk");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Address Line 2 input field")).sendKeys("Laxmi Road");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Pune");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("Maharastra");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Zip Code* input field")).sendKeys("411001");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("INDIA");
	Thread.sleep(5000);
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
	//Thread.sleep(5000);
	}
}
