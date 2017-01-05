package com.sxt.dao.factory;

import com.sxt.dao.KcDao;
import com.sxt.dao.SellDao;
import com.sxt.dao.impl.KcDaoImpl;
import com.sxt.dao.impl.SellDaoImpl;
import com.sxt.dao.impl.SpDaoImpl;

public abstract class DaoFactory {
	
	public static SellDao getSellDao()
	{
		return new SellDaoImpl();
	}
	
	public static KcDao getKcDao(){
		return new KcDaoImpl();
		
	}
	
	public static SpDaoImpl getSpDao(){
		return new SpDaoImpl();
		
	}
}
