package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.sxt.dao.KcDao;
import com.sxt.dao.comm.DBConnection;

public class KcDaoImpl implements KcDao {

	@Override
	public Vector<Vector> goodsInquiry() {
		
		String sql = "select * from kc_main order by kc_id";
		Vector<Vector> data = new Vector<Vector>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		ResultSetMetaData resultSetMetaData = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSetMetaData = statement.getMetaData();
			resultSet = statement.executeQuery();
			int count = resultSetMetaData.getColumnCount();
			while (resultSet.next()) {
				Vector vector = new Vector();
				for (int i = 0; i < count; i++) {
					vector.add(resultSet.getObject(i + 1));
				}
				data.add(vector);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return data;
	}

	@Override
	public  int goodsNumUpdate(Vector vec) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String sql = "update  kc_main set kc_sl=? where kc_id=?";
		PreparedStatement statement=null;
		int b=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, vec.get(7).toString());
			statement.setString(2, vec.get(0).toString());
			     b=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, null);
		}
		return b;
	}
	
       //�޸ĵ��� 
	@Override
	public int goodsPriceUpdate(String price,String goodsName) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String sql = "update  kc_main set kc_dj=? where kc_name=?";
		PreparedStatement statement=null;
		int b=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(price));
			statement.setString(2, goodsName);
			 b=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, null);
		}
		return b;
	}
	
	@Override
	public int goodsNumUpdate(String goodsNum, String goodsName) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String sql = "update  kc_main set kc_sl=? where kc_name=?";
		PreparedStatement statement=null;
		int b=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(goodsNum));
			statement.setString(2, goodsName);
			 b=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, null);
		}
		return b;	
		
	}

}
