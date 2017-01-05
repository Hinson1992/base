package com.sxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.sxt.dao.Sql;
import com.sxt.comm.ValDataUtil;
import com.sxt.dao.comm.DBConnection;
import com.sxt.dao.SellDao;
import com.sxt.pojo.KcInfo;

public class SellDaoImpl implements SellDao {

	@Override
	public boolean login(String username, String password) {
		Connection connection = DBConnection.getConnection();
		String sql = "select count(*) count from denglu where (id = ? or username = ?) and password = ?"; // ?
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			
			statement = connection.prepareStatement(sql); // 当PreparedStatement对象创建时，就会对被传入的SQL语句进行预编译

			// 对SQL语句中的占位符进行数据替换
			if (ValDataUtil.valNumber(username)) {
				statement.setString(1, username);
				statement.setObject(2, null);
			} else {
				statement.setObject(1, null);
				statement.setString(2, username);
			}
			statement.setString(3, password);
			
			// 对被补充了实际数据的SQL语句进行发送至数据库执行
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		if (count > 0)
			return true;
		else
			return false;
	}

	@Override
	public Vector<Vector> spSearch() {
		Connection connection = DBConnection.getConnection();
		
		Vector<Vector> allStock = new Vector<Vector>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_SP_QUERY);

			while (resultSet.next()) {
				Vector stock = new Vector();
				stock.add(resultSet.getInt("SP_ID"));
				stock.add(resultSet.getString("SP_NAME"));
				stock.add(resultSet.getString("SP_LOC"));
				stock.add(resultSet.getString("SP_DW"));
				stock.add(resultSet.getString("SP_GG"));
				stock.add(resultSet.getString("SP_BZ"));
				stock.add(resultSet.getString("SP_MEMO"));
				stock.add(resultSet.getString("SP_GYS"));
				stock.add(resultSet.getString("SP_PH"));
				allStock.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return allStock;
	}

	@Override
	public Vector<Vector> spSearch(String sql) {
	Connection connection = DBConnection.getConnection();
		
		Vector<Vector> allStock = new Vector<Vector>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_someSP_QUERY+sql+"order by  SP_ID");

			while (resultSet.next()) {
				Vector stock = new Vector();
				stock.add(resultSet.getInt("SP_ID"));
				stock.add(resultSet.getString("SP_NAME"));
				stock.add(resultSet.getString("SP_LOC"));
				stock.add(resultSet.getString("SP_DW"));
				stock.add(resultSet.getString("SP_GG"));
				stock.add(resultSet.getString("SP_BZ"));
				stock.add(resultSet.getString("SP_MEMO"));
				stock.add(resultSet.getString("SP_GYS"));
				stock.add(resultSet.getString("SP_PH"));
				allStock.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return allStock;
	}

	@Override
	public Vector<Vector> khSearch() {
	Connection connection = DBConnection.getConnection();
		
		Vector<Vector> allClient = new Vector<Vector>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_KH_QUERY);

			while (resultSet.next()) {
				Vector client = new Vector();
				client.add(resultSet.getString("KH_ID"));
				client.add(resultSet.getString("KH_NAME"));
				client.add(resultSet.getString("KH_ADDRESS"));
				client.add(resultSet.getString("KH_TEL"));
				client.add(resultSet.getString("KH_LIAN"));
				client.add(resultSet.getString("KH_YHZH"));
				client.add(resultSet.getString("KH_YB"));
				client.add(resultSet.getString("KH_EMAIL"));
				client.add(resultSet.getString("KH_BZ"));
				allClient.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return allClient;
	}

	@Override
	public Vector<Vector> khSearch(String sql) {
Connection connection = DBConnection.getConnection();
		
		Vector<Vector> allClient = new Vector<Vector>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_someKH_QUERY+sql+"order by KH_ID");
			while (resultSet.next()) {
				Vector client = new Vector();
				client.add(resultSet.getString("KH_ID"));
				client.add(resultSet.getString("KH_NAME"));
				client.add(resultSet.getString("KH_ADDRESS"));
				client.add(resultSet.getString("KH_TEL"));
				client.add(resultSet.getString("KH_LIAN"));
				client.add(resultSet.getString("KH_YHZH"));
				client.add(resultSet.getString("KH_YB"));
				client.add(resultSet.getString("KH_EMAIL"));
				client.add(resultSet.getString("KH_BZ"));
				allClient.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return allClient;
	}

	@Override
	public Vector<Vector> gysSearch() {
		Connection connection = DBConnection.getConnection();		
		Vector<Vector> allSupplier = new Vector<Vector>();
		Statement statement = null;
		ResultSet resultSet = null;
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(Sql.SQL_GYS_QUERY);
				while (resultSet.next()) {
					Vector supplier = new Vector();
					supplier.add(resultSet.getString("TG_ID"));
					supplier.add(resultSet.getString("TG_NAME"));
					supplier.add(resultSet.getString("TG_ADDRESS"));
					supplier.add(resultSet.getString("TG_TEL"));
					supplier.add(resultSet.getString("TG_LIAN"));
					supplier.add(resultSet.getString("TG_YHZH"));
					supplier.add(resultSet.getString("TG_YB"));
					supplier.add(resultSet.getString("TG_EMAIL"));	
					supplier.add(resultSet.getString("TG_BZ"));
					allSupplier.add(supplier);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBConnection.close(connection, statement, resultSet);
			}

			return allSupplier;
		
	}

	@Override
	public Vector<Vector> gysSearch(String sql) {
		Connection connection = DBConnection.getConnection();	
		Vector<Vector> allSupplier = new Vector<Vector>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_someGYS_QUERY+sql+"order by TG_ID");
			while (resultSet.next()) {
				Vector supplier = new Vector();
				supplier.add(resultSet.getString("TG_ID"));
				supplier.add(resultSet.getString("TG_NAME"));
				supplier.add(resultSet.getString("TG_ADDRESS"));
				supplier.add(resultSet.getString("TG_TEL"));
				supplier.add(resultSet.getString("TG_LIAN"));
				supplier.add(resultSet.getString("TG_YHZH"));
				supplier.add(resultSet.getString("TG_YB"));
				supplier.add(resultSet.getString("TG_EMAIL"));	
				supplier.add(resultSet.getString("TG_BZ"));
				allSupplier.add(supplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}
		return allSupplier;
	}

	@Override
	public Vector<Vector> rkSearch() {

		Connection connection = DBConnection.getConnection();
			
			Vector<Vector> allInfo = new Vector<Vector>();

			Statement statement = null;
			ResultSet resultSet = null;
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(Sql.SQL_RK_QUERY);

				while (resultSet.next()) {
					Vector<Object> info = new Vector<Object>();
					info.add(resultSet.getString("TRM_ID"));
					info.add(resultSet.getString("KC_ID"));
					info.add(resultSet.getString("KC_NAME"));
					info.add(resultSet.getString("KC_GG"));
					info.add(resultSet.getString("KC_DJ"));
					info.add(resultSet.getString("KC_SL"));
					info.add(resultSet.getString("TRTM_JE"));
					info.add(resultSet.getString("TG_NAME"));
					info.add(resultSet.getString("TRTM_DATE"));
					info.add(resultSet.getString("TRTM_CZY"));
					info.add(resultSet.getString("TRTM_JSR"));
					info.add(resultSet.getString("TRTM_JSFS"));
			
					allInfo.add(info);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBConnection.close(connection, statement, resultSet);
			}

			return allInfo;
		
	}

	@Override
	public Vector<Vector> rkSearch(String sql) {
		Connection connection = DBConnection.getConnection();	
		Vector<Vector> allInfo = new Vector<Vector>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_someRK_QUERY+sql+"order by TRM_ID");
			while (resultSet.next()) {
				Vector<Object> info = new Vector<Object>();
				info.add(resultSet.getString("TRM_ID"));
				info.add(resultSet.getString("KC_ID"));
				info.add(resultSet.getString("KC_NAME"));
				info.add(resultSet.getString("KC_GG"));
				info.add(resultSet.getString("KC_DJ"));
				info.add(resultSet.getString("KC_SL"));
				info.add(resultSet.getString("TRTM_JE"));
				info.add(resultSet.getString("TG_NAME"));
				info.add(resultSet.getString("TRTM_DATE"));
				info.add(resultSet.getString("TRTM_CZY"));
				info.add(resultSet.getString("TRTM_JSR"));
				info.add(resultSet.getString("TRTM_JSFS"));
				allInfo.add(info);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}
		return allInfo;
	}

	@Override
	public Vector<Vector> sellSearch() {


		Connection connection = DBConnection.getConnection();
			
			Vector<Vector> allInfo = new Vector<Vector>();

			Statement statement = null;
			ResultSet resultSet = null;
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(Sql.SQL_SELL_QUERY);

				while (resultSet.next()) {
					Vector<Object> info = new Vector<Object>();
					info.add(resultSet.getString("SD_ID"));
					info.add(resultSet.getString("KC_ID"));
					info.add(resultSet.getString("KC_NAME"));
					info.add(resultSet.getString("KC_GG"));
					info.add(resultSet.getString("KC_DJ"));
					info.add(resultSet.getString("KC_SL"));
					info.add(resultSet.getString("SM_JE"));
					info.add(resultSet.getString("KH_NAME"));
					info.add(resultSet.getString("SM_DATE"));
					info.add(resultSet.getString("SM_CZY"));
					info.add(resultSet.getString("SM_JSR"));
					info.add(resultSet.getString("SM_JSFS"));
			
					allInfo.add(info);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBConnection.close(connection, statement, resultSet);
			}

			return allInfo;
		
	
	}

	@Override
	public Vector<Vector> sellSearch(String sql) {

		Connection connection = DBConnection.getConnection();	
		Vector<Vector> allInfo = new Vector<Vector>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_someSELL_QUERY+sql+"order by SD_ID");
			while (resultSet.next()) {
				Vector<Object> info = new Vector<Object>();
				info.add(resultSet.getString("SD_ID"));
				info.add(resultSet.getString("KC_ID"));
				info.add(resultSet.getString("KC_NAME"));
				info.add(resultSet.getString("KC_GG"));
				info.add(resultSet.getString("KC_DJ"));
				info.add(resultSet.getString("KC_SL"));
				info.add(resultSet.getString("SM_JE"));
				info.add(resultSet.getString("KH_NAME"));
				info.add(resultSet.getString("SM_DATE"));
				info.add(resultSet.getString("SM_CZY"));
				info.add(resultSet.getString("SM_JSR"));
				info.add(resultSet.getString("SM_JSFS"));
				allInfo.add(info);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}
		return allInfo;
	
	}

	@Override
	public Vector<Vector> sellRankSearch(String sql) {


		Connection connection = DBConnection.getConnection();	
		Vector<Vector> allInfo = new Vector<Vector>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Sql.SQL_SELL_RANK_QUERY+sql);
			while (resultSet.next()) {
				Vector<Object> info = new Vector<Object>();
				info.add(resultSet.getString("KC_ID"));
				info.add(resultSet.getString("KC_NAME"));
				info.add(resultSet.getString("SM_JE"));
				info.add(resultSet.getString("SM_SL"));
				info.add(resultSet.getString("KC_LOC"));
				info.add(resultSet.getString("KC_DW"));
				info.add(resultSet.getString("KC_GG"));
				info.add(resultSet.getString("KC_BZ"));
				allInfo.add(info);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}
		return allInfo;
	
	
	}

	@Override
	public boolean addSp(Vector sp) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_SP_ADD);
			for(int i = 0;i < sp.size();i++)
			{
				statement.setObject(i+1, sp.get(i));
			}
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateSp(Vector sp) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_SP_UPDATE);
			for(int i = 0;i < sp.size();i++)
			{
				statement.setObject(i+1, sp.get(i));
			}
			statement.setObject(sp.size()+1, sp.get(0));
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addGys(Vector gysinfo) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_GYS_ADD);
			for(int i = 0;i < gysinfo.size();i++)
			{
				statement.setObject(i+1, gysinfo.get(i));
			}
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;

	
	}

	@Override
	public boolean updateGys(Vector gysinfo) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_GYS_UPDATE);
			for(int i = 0;i < gysinfo.size();i++)
			{
				statement.setObject(i+1, gysinfo.get(i));
			}
			statement.setObject(gysinfo.size()+1, gysinfo.get(0));
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteSP(String spSelected_id) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_SP_DELETE);
			statement.setObject(1, spSelected_id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	
	}

	@Override
	public boolean deleteGys(String gysSelected_id) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_GYS_DELETE);
			statement.setObject(1, gysSelected_id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addKh(Vector khinfo) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_KH_ADD);
			for(int i = 0;i < khinfo.size();i++)
			{
				statement.setObject(i+1, khinfo.get(i));
			}
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteKh(String khSelected_id) {


		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_KH_DELETE);
			statement.setObject(1, khSelected_id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	
	}

	@Override
	public boolean updateKh(Vector khinfo) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_KH_UPDATE);
			for(int i = 0;i < khinfo.size();i++)
			{
				statement.setObject(i+1, khinfo.get(i));
			}
			statement.setObject(khinfo.size()+1, khinfo.get(0));
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	
	}

	@Override
	public boolean updatePwd(String userName,String newPwd) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_PWD_UPDATE);
			statement.setObject(1, newPwd);
			statement.setObject(2, userName);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;
	}

	@Override
	public Vector<String> selectUser(String userName) {
	Connection connection = DBConnection.getConnection();
		
		Vector<String> user = new Vector<String>();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			System.out.println(Sql.SQL_PWD_SELECT+userName);
			resultSet = statement.executeQuery(Sql.SQL_PWD_SELECT+userName);
		
			if(resultSet.next()) {
				
				user.add(resultSet.getString("ID"));
				user.add(resultSet.getString("USERNAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, resultSet);
		}

		return user;
	}

//	@Override
//	public int datebaseBackUp(String sql) {
//		int rs = 0;
//		Connection connection = DBConnection.getConnection();
//		try {
//			Statement statement = connection.createStatement();
//			rs = statement.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			DBConnection.close(connection, statement, resultSet);
//		}
//		
//        return rs;
//}
	

	public int query(String QueryStr) {
		Connection connection = DBConnection.getConnection();		
		int newId = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryStr);
			if(resultSet.next())
			{
				newId=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return newId;
	}

	@Override
	public int getNum(String id) {
		Connection connection = DBConnection.getConnection();		
		int num = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select kc.kc_sl from kc_main kc join tb_spinfo sp  on kc.kc_ID ="+id);
			if(resultSet.next())
			{
				num=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return num;
	}
	@Override
	public int sdQuery(String QueryStr) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();		
		int newId = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryStr);
			if(resultSet.next())
			{
				newId=Integer.parseInt(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return newId;
	}
 
	@Override
	public Boolean addXSXD(String SD_ID, String KC_ID, String SM_DJ,
			String SM_ID1, String SM_SL) {
		String sql="insert  into sell_detail values(?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int a=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, SD_ID);
			statement.setString(2, KC_ID);
			statement.setString(3, SM_ID1);
			statement.setString(4, SM_DJ);
			statement.setFloat(5, Integer.parseInt(SM_SL)+0f);
			a=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, null);
		}
		if(a>0)
		return true;
		else return false;
		
	}
	
	@Override
	public Boolean addJHXD(String TRM_ID, String KC_ID, String TRTM_DJ,
			String TRTM_ID1, String TRTM_SL) {
		String sql="insert  into ruku_detail values(?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int a=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, TRM_ID);
			statement.setString(2, KC_ID);
			statement.setString(3, TRTM_ID1);
			statement.setString(4, TRTM_DJ);
			statement.setFloat(5, Integer.parseInt(TRTM_SL)+0f);
			a=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, null);
		}
		if(a>0)
		return true;
		else return false;
		
	}
	@Override
	public Vector<Vector> xxsdSearch(String xsDH) {
		// TODO Auto-generated method stub
		String sql="select e1.kc_name,e1.kc_loc,e1.kc_dw,e1.kc_gg,e1.kc_bz,e2.sm_dj,e2.sm_sl from (kc_main e1 join sell_detail e2 on e1.kc_id=e2.kc_id) where sm_id=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		int a=0;
		Vector<Vector> vector=new Vector<Vector>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, xsDH);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Vector rowvector=new Vector();
				rowvector.add(resultSet.getString(1));
				rowvector.add(resultSet.getString(2));
				rowvector.add(resultSet.getString(3));
				rowvector.add(resultSet.getString(4));
				rowvector.add(resultSet.getString(5));
				rowvector.add(resultSet.getInt(6));
				rowvector.add(resultSet.getFloat(7));
				vector.add(rowvector);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return vector;
	}
	
	@Override
	public Vector<Vector> jhxdSearch(String jhDH) {
		// TODO Auto-generated method stub
		String sql="select e1.kc_name,e1.kc_loc,e1.kc_dw,e1.kc_gg,e1.kc_bz,e2.trd_dj,e2.trd_sl from (kc_main e1 join ruku_detail e2 on e1.kc_id=e2.kc_id) where trm_id=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		int a=0;
		Vector<Vector> vector=new Vector<Vector>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, jhDH);
			resultSet=statement.executeQuery();
			while (resultSet.next()) {
				Vector rowvector=new Vector();
				rowvector.add(resultSet.getString(1));
				rowvector.add(resultSet.getString(2));
				rowvector.add(resultSet.getString(3));
				rowvector.add(resultSet.getString(4));
				rowvector.add(resultSet.getString(5));
				rowvector.add(resultSet.getInt(6));
				rowvector.add(resultSet.getFloat(7));
				vector.add(rowvector);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return vector;
	}
	@Override
	public int xtmQuery(String QueryStr) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();		
		int newId = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryStr);
			if(resultSet.next())
			{
				newId=Integer.parseInt(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
		return newId;
	}
	
	@Override
	public String cxKhName(String KH_ID) {
		// TODO Auto-generated method stub
		String sql="select kh_name from kh_main where kh_id"+
            " =(select kh_id from sell_main where sm_id=?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		String kh_name=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,KH_ID );
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				kh_name=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
     
		return kh_name;
	}
	
	@Override
	public String cxGysName(String TG_ID) {
		// TODO Auto-generated method stub
		String sql="select TG_name from tb_gysinfo where tg_id"+
            " =(select tg_id from ruku_main where trm_id=?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		String gys_name=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,TG_ID );
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				gys_name=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(connection, statement, resultSet);
		}
     
		return gys_name;
	}

	@Override
	public boolean addKc(KcInfo kcInfo) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(Sql.SQL_KC_ADD);
				statement.setObject(1, kcInfo.getId());
				statement.setObject(2, kcInfo.getName());
				statement.setObject(3, kcInfo.getCd());
				statement.setObject(4, kcInfo.getDw());
				statement.setObject(5, kcInfo.getGg());
				statement.setObject(6, kcInfo.getBz());
				statement.setObject(7, kcInfo.getDj());
				statement.setObject(8, kcInfo.getSl());
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, statement, null);
		}
		if(count > 0)
			return true;
		else
			return false;

	
	}

}
