package com.sxt.dao.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	static {
		// 注册驱动类 -- 反射方式
		try {
			Class.forName(DBConfigLoader.getValue("db.driver.class"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 生成数据库链接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					DBConfigLoader.getValue("db.url"), DBConfigLoader.getValue("db.username"), DBConfigLoader.getValue("db.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					
				}
			}
		}
	}

}
