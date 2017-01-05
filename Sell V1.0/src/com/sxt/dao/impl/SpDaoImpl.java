package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.sxt.dao.SpDao;
import com.sxt.dao.comm.DBConnection;

public class SpDaoImpl implements SpDao {

	@Override
	public Vector<Vector> spInquiry() {
		// TODO Auto-generated method stub
		String sql = "select kc_name,kc_loc,kc_dw,kc_gg,kc_bz,kc_dj from kc_main";
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
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return data;
	}
//增加销售单
	@Override
	public Boolean addXSD(Vector vector) {
		// TODO Auto-generated method stub
		String sql="insert into sell_main values(?,?,?,?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count=0;
		try {
			statement=connection.prepareStatement(sql);
			for (int i = 0; i < vector.size(); i++) {
				statement.setObject(i+1, vector.get(i));
			}
			count=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count>0) {
		return true;	
		}
		else return false;
	}
	@Override
	public Boolean addXSXD(Vector vector) {
		// TODO Auto-generated method stub
		String sql="insert into sell_main values(?,?,?,?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count=0;
		try {
			statement=connection.prepareStatement(sql);
			for (int i = 0; i < vector.size(); i++) {
				statement.setObject(i+1, vector.get(i));
			}
			count=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count>0) {
		return true;	
		}
		else return false;
	}
	
	//增加销售单
		@Override
		public Boolean addJHD(Vector vector) {
			// TODO Auto-generated method stub
			String sql="insert into ruku_main values(?,?,?,?,?,?,?,?,?)";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				for (int i = 0; i < vector.size(); i++) {
					statement.setObject(i+1, vector.get(i));
				}
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count>0) {
			return true;	
			}
			else return false;
		}
		/*@Override
		public Boolean addJHXD(Vector vector) {
			// TODO Auto-generated method stub
			String sql="insert into sell_main values(?,?,?,?,?,?,?,?,?)";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				for (int i = 0; i < vector.size(); i++) {
					statement.setObject(i+1, vector.get(i));
				}
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count>0) {
			return true;	
			}
			else return false;
		}
*/
		@Override
		public Vector<Vector> xsdInquiry() {
			String sql = "select * from sell_main";
			Connection connection = DBConnection.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			ResultSetMetaData resultSetMetaData = null;
			int count = 0;
			Vector<Vector> vector=new Vector<Vector>();
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				resultSetMetaData = resultSet.getMetaData();
				count = resultSetMetaData.getColumnCount();
				while (resultSet.next()) {
					Vector rowve = new Vector();
					for (int i = 0; i < count; i++) {
						rowve.add(resultSet.getObject(i + 1));
					}
					vector.add(rowve);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vector;
		}
		@Override
		public Boolean addXSTD(Vector vector) {
			// TODO Auto-generated method stub
			String sql="insert into xsth_main values(?,?,?,?,?,?,?,?,?)";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				for (int i = 0; i < vector.size(); i++) {
					statement.setObject(i+1, vector.get(i));
				}
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count>0) {
			return true;	
			}
			else return false;
		}
		
		@Override
		public Boolean addJHTD(Vector vector) {
			// TODO Auto-generated method stub
			String sql="insert into rkth_main values(?,?,?,?,?,?,?,?,?)";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				for (int i = 0; i < vector.size(); i++) {
					statement.setObject(i+1, vector.get(i));
				}
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count>0) {
			return true;	
			}
			else return false;
		}
		@Override
		public Vector<Vector> jhdInquiry() {
			String sql = "select * from ruku_main";
			Connection connection = DBConnection.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			ResultSetMetaData resultSetMetaData = null;
			int count = 0;
			Vector<Vector> vector=new Vector<Vector>();
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				resultSetMetaData = resultSet.getMetaData();
				count = resultSetMetaData.getColumnCount();
				while (resultSet.next()) {
					Vector rowve = new Vector();
					for (int i = 0; i < count; i++) {
						rowve.add(resultSet.getObject(i + 1));
					}
					vector.add(rowve);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vector;
		}
		
		@Override
		public Boolean deleteXSD(String xxdNum) {
			// TODO Auto-generated method stub
			String sql="delete from sell_main where sm_id=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				statement.setString(1, xxdNum);
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0) return true;
			else return false;
		}
		
		@Override
		public Boolean deleteXSXD(String xxdNum) {
			// TODO Auto-generated method stub
			String sql="delete from sell_detail where sm_id=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				statement.setString(1, xxdNum);
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0) return true;
			else return false;
		}
		
		@Override
		public Boolean deleteJHD(String jhdNum) {
			// TODO Auto-generated method stub
			String sql="delete from ruku_main where TRM_id=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				statement.setString(1, jhdNum);
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0) return true;
			else return false;
		}
		
		@Override
		public Boolean deleteJHXD(String jhdNum) {
			// TODO Auto-generated method stub
			String sql="delete from ruku_detail where TRM_id=?";
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = null;
			int count=0;
			try {
				statement=connection.prepareStatement(sql);
				statement.setString(1, jhdNum);
				count=statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0) return true;
			else return false;
		}


}
