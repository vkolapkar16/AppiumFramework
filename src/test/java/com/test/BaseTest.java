package com.test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;

public class BaseTest 
{
	@BeforeMethod
	public void setupTest() throws MalformedURLException
	{
		Driver.initDriver();
	}
	
	@AfterMethod
	public void tearDown() throws MalformedURLException
	{
		Driver.quitDriver();
	}

}
