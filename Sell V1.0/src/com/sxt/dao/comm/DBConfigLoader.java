package com.sxt.dao.comm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBConfigLoader {
	
	private static Properties properties = new Properties();

	static{
		try {
			properties.load(new FileInputStream("config/db.config"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key)
	{
		return properties.getProperty(key);
	}
}
