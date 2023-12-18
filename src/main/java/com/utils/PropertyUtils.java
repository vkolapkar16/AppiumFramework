package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyUtils
{
	private static final Properties properties = new Properties();
	
	private static Map<String,String> MAP = new HashMap<>();
	
	static {
		
		 try(FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						 +"/src/test/resources/config/driverconfig.properties"))
		 { 
			properties.load(file);
			for (Entry<Object, Object> entry : properties.entrySet()) {
				String key = String.valueOf(entry.getKey());
				String value = String.valueOf(entry.getValue());
				MAP.put(key, value);
				
			}
		 }
		 
		 catch (IOException e) {
			 e.printStackTrace();
			 System.exit(0);
		 }
	}
	
		 public static String getValue(String key)
		 {
			 return MAP.get(key);
		 }

}
