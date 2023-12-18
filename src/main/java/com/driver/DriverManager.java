package com.driver;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.WebDriver;

public class DriverManager
{
	private DriverManager() {}
	
	public static ThreadLocal<WebDriver> threaddriver = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		return threaddriver.get();
	}
	
	public static void setDriver (WebDriver driver)
	{
		threaddriver.set(driver);
	}
	
	public static void unload ()
	{
		threaddriver.remove();
	}

}
