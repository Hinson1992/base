package com.sxt.comm;

public abstract class ValDataUtil {
	
	public static boolean valUserName(String username)
	{
		return false;
	}
	
	public static boolean valNumber(String str)
	{
		return str.matches("^\\d{4}$");
	}

	 public static Integer mathRandom()
	{
		return (int)(Math.random()*9)+(int)(Math.random()*90)+(int)(Math.random()*9000)+(int)(Math.random()*900);
	}
}
