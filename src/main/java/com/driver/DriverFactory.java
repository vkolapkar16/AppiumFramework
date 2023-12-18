package com.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class DriverFactory
{
	private DriverFactory() {}
	
	public static WebDriver get(Modes mode) throws MalformedURLException 
	{
		WebDriver driver = null;
		if(mode.equals(Modes.LOCAL))
		{
			driver = new LocalDriverImpl().getdriver();
		}
		else if(mode.equals(Modes.BS))
		{
			driver = new BrowserStackImpl().getdriver();
		}
		
		return driver;
		
	}
	
}
