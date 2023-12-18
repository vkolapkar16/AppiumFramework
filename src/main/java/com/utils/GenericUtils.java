package com.utils;

public class GenericUtils 
{
	private GenericUtils() {}
	
	public static String getXpath(String xpath,String value) {
		return String.format(xpath, value);
	}
	
	

}
