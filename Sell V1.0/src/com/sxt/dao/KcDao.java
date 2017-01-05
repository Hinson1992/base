package com.sxt.dao;

import java.util.Vector;

public interface KcDao {
	public Vector<Vector> goodsInquiry();
	public  int goodsNumUpdate(Vector vec);
	public int goodsPriceUpdate(String price,String goodsName);
	public int goodsNumUpdate(String price,String goodsName);
}
