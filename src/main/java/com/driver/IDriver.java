package com.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface IDriver
{
	public WebDriver getdriver() throws MalformedURLException;
}
