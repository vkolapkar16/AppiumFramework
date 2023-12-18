package com.driver;

import static com.driver.DriverManager.getDriver;
import static com.driver.DriverManager.setDriver;
import static com.driver.DriverManager.unload;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.utils.PropertyUtils;

import net.bytebuddy.dynamic.DynamicType.Default.Unloaded;

public class Driver 
{
	private Driver() {}
	
	public static WebDriver driver;
	
	public static void initDriver() throws MalformedURLException
	{
		if(isNull(getDriver())) {
		String modevalue = PropertyUtils.getValue("mode");	
		WebDriver driver = DriverFactory.get(Modes.valueOf(modevalue.toUpperCase()));
		setDriver(driver);
		}
	}
	
	public static void quitDriver() throws MalformedURLException
	{
		if(nonNull(getDriver())) 
		{
			getDriver().quit();
			unload();
		}
	}
	
}
