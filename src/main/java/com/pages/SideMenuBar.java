package com.pages;

import static com.utils.GenericUtils.getXpath;

import org.openqa.selenium.By;

public class SideMenuBar extends  BasePage
{
	private String  dragAndDrop="//android.widget.TextView[contains(@text,'%s')]";
	
	public void clickMenutItems(String menuname)
	{
		String newxpath = getXpath(dragAndDrop, menuname);
		click(By.xpath(newxpath), menuname);
	}
	
	
}
