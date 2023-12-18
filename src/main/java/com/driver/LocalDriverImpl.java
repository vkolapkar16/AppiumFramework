package com.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LocalDriverImpl implements IDriver 
{

	@Override
	public WebDriver getdriver() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName", "Android");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("deviceName", "OnePlus");
        options.setCapability("app", System.getProperty("user.dir") + "/Apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        return new AndroidDriver (new URL("http://127.0.0.1:4723"),options);
		
		
	}

}
