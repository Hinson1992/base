package com.sxt.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.GysInfo;
import com.sxt.pojo.KhInfo;
import com.sxt.pojo.StockInfo;

public class UserService {

	public static boolean login(String username, String password) {

		return DaoFactory.getSellDao().login(username, password);
	}

	public static Vector stockSearchInfo(String conName, String conOperation,
			String content, Vector vector) {
		if (conOperation.equals("等于")) {
			if (conName.equals("商品名称"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_name='" + content + "'");
			if (conName.equals("供应商名称"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_gys='" + content + "'");
			if (conName.equals("产地"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_loc='" + content + "'");
			if (conName.equals("包装"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_bz='" + content + "'");
		} else {
			if (conName.equals("商品名称"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_name like '%" + content + "%'");
			if (conName.equals("供应商名称"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_gys like '%" + content + "%'");
			if (conName.equals("产地"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_loc like '%" + content + "%'");
			if (conName.equals("包装"))
				vector = DaoFactory.getSellDao().spSearch(
						"sp_bz like '%" + content + "%'");
		}
		return vector;
	}

	public static Vector khSearchInfo(String conName, String conOperation,
			String content, Vector vector) {
		if (conOperation.equals("等于")) {
			if (conName.equals("编号"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_id='" + content + "'");
			if (conName.equals("名称"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_name='" + content + "'");
			if (conName.equals("地址"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_address='" + content + "'");
		} else {
			if (conName.equals("编号"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_id like '%" + content + "%'");
			if (conName.equals("名称"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_name like '%" + content + "%'");
			if (conName.equals("地址"))
				vector = DaoFactory.getSellDao().khSearch(
						"kh_address like '%" + content + "%'");
		}
		return vector;
	}

	public static Vector gysSearchInfo(String conName, String conOperation,
			String content, Vector vector) {
		if (conOperation.equals("等于")) {
			if (conName.equals("编号"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_id='" + content + "'");
			if (conName.equals("名称"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_name='" + content + "'");
			if (conName.equals("地址"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_address='" + content + "'");
		} else {
			if (conName.equals("编号"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_id like '%" + content + "%'");
			if (conName.equals("名称"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_name like '%" + content + "%'");
			if (conName.equals("地址"))
				vector = DaoFactory.getSellDao().gysSearch(
						"tg_address like '%" + content + "%'");
		}
		return vector;
	}

	public static Vector rkSearchInfo(String conName, String conOperation,
			String content, Vector vector, JRadioButton rdbtnNewRadioButton,
			String sDate, String eDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date sdate = null;
		java.sql.Date edate = null;
		try {
			sdate = new java.sql.Date(format.parse(sDate).getTime());
			edate = new java.sql.Date(format.parse(eDate).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conOperation.equals("等于")) {
			if (conName.equals("商品编号")) {
				if (rdbtnNewRadioButton.isSelected()) {

					vector = DaoFactory.getSellDao().rkSearch(
							"kc_id='" + content + "'" + 
					"and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().rkSearch(
							"kc_id='" + content + "'");
				}

			}
			if (conName.equals("商品名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().rkSearch(
							"KC_NAME='" + content + "'" + "and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().rkSearch(
							"KC_NAME='" + content + "'");
				}

			if (conName.equals("供应商名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().rkSearch(
							"TG_NAME='" + content + "'" + "and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				}

				else {
					vector = DaoFactory.getSellDao().rkSearch(
							"TG_NAME='" + content + "'");
				}
		} else {
			if (conName.equals("商品编号"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().rkSearch(
							"kc_ID like '%" + content + "%'"
									+ "and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				}

				else {
					vector = DaoFactory.getSellDao().rkSearch(
							"kc_ID like '%" + content + "%'");
				}

			if (conName.equals("商品名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().rkSearch(
							"KC_NAME like '%" + content + "%'"
									+ "and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().rkSearch(
							"KC_NAME like '%" + content + "%'");
				}

			if (conName.equals("供应商名称"))
				if (!rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().rkSearch(
							"TG_NAME like '%" + content + "%'"
									+"and TRTM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and TRTM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().rkSearch(
							"TG_NAME like '%" + content + "%'");
				}

		}
		return vector;
	}
	
	public static Vector sellSearchInfo(String conName, String conOperation,
			String content, Vector vector, JRadioButton rdbtnNewRadioButton,
			String sDate, String eDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date sdate = null;
		java.sql.Date edate = null;
		try {
			sdate = new java.sql.Date(format.parse(sDate).getTime());
			edate = new java.sql.Date(format.parse(eDate).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conOperation.equals("等于")) {
			if (conName.equals("商品编号")) {
				if (rdbtnNewRadioButton.isSelected()) {

					vector = DaoFactory.getSellDao().sellSearch(
							"kc_id='" + content + "'" + 
					"and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().sellSearch(
							"kc_id='" + content + "'");
				}

			}
			if (conName.equals("商品名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().sellSearch(
							"KC_NAME='" + content + "'" + "and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().sellSearch(
							"KC_NAME='" + content + "'");
				}

			if (conName.equals("客户名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().sellSearch(
							"KH_NAME='" + content + "'" + "and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				}

				else {
					vector = DaoFactory.getSellDao().sellSearch(
							"KH_NAME='" + content + "'");
				}
		} else {
			if (conName.equals("商品编号"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().sellSearch(
							"kc_ID like '%" + content + "%'"
									+ "and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				}

				else {
					vector = DaoFactory.getSellDao().sellSearch(
							"kc_ID like '%" + content + "%'");
				}

			if (conName.equals("商品名称"))
				if (rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().sellSearch(
							"KC_NAME like '%" + content + "%'"
									+ "and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().sellSearch(
							"KC_NAME like '%" + content + "%'");
				}

			if (conName.equals("客户名称"))
				if (!rdbtnNewRadioButton.isSelected()) {
					vector = DaoFactory.getSellDao().sellSearch(
							"KH_NAME like '%" + content + "%'"
									+"and SM_DATE>=to_date('"+ sDate +"','yyyy-MM-dd') and SM_DATE<=to_date('" + eDate +"','yyyy-MM-dd')");
				} else {
					vector = DaoFactory.getSellDao().sellSearch(
							"KH_NAME like '%" + content + "%'");
				}

		}
		return vector;
	}
	
	public static Vector sellRankSearchInfo(String con, String opstr,
			String date, Vector vector) {
		String sql =" trunc(sm_date,'mm')= to_date('"+date+"','yyyy-mm')order by "+con+" "+opstr;
		vector = DaoFactory.getSellDao().sellRankSearch(sql);
		return vector;
	}
	
	public static boolean spAdd(StockInfo si)
	{
		Vector vector = new Vector();
		vector.add(si.getId());
		vector.add(si.getSpname());
		vector.add(si.getCd());
		vector.add(si.getDw());
		vector.add(si.getGg());
		vector.add(si.getBz());
		vector.add(si.getMemo());
		vector.add(si.getGysname());
		vector.add(si.getPh());	
		return DaoFactory.getSellDao().addSp(vector);
	}
	
	public static boolean spUpdate(StockInfo si)
	{
		Vector vector = new Vector();
		vector.add(si.getId());
		vector.add(si.getSpname());
		vector.add(si.getCd());
		vector.add(si.getDw());
		vector.add(si.getGg());
		vector.add(si.getBz());
		vector.add(si.getMemo());
		vector.add(si.getGysname());
		vector.add(si.getPh());	
		return DaoFactory.getSellDao().updateSp(vector);
	}
	
	public static boolean gysAdd(GysInfo gysinfo)
	{
		Vector vector = new Vector();
		vector.add(gysinfo.getId());
		vector.add(gysinfo.getName());
		vector.add(gysinfo.getDz());
		vector.add(gysinfo.getTel());
		vector.add(gysinfo.getLxr());
		vector.add(gysinfo.getYhzh());
		vector.add(gysinfo.getYb());
		vector.add(gysinfo.getEmail());
		vector.add(gysinfo.getBz());	
		return DaoFactory.getSellDao().addGys(vector);
	}
	
	public static boolean gysUpdate(GysInfo gysinfo)
	{
		Vector vector = new Vector();
		vector.add(gysinfo.getId());
		vector.add(gysinfo.getName());
		vector.add(gysinfo.getDz());
		vector.add(gysinfo.getTel());
		vector.add(gysinfo.getLxr());
		vector.add(gysinfo.getYhzh());
		vector.add(gysinfo.getYb());
		vector.add(gysinfo.getEmail());
		vector.add(gysinfo.getBz());	
		return DaoFactory.getSellDao().updateGys(vector);
	}
	
	public static boolean khAdd(KhInfo khInfo)
	{
		Vector vector = new Vector();
		vector.add(khInfo.getId());
		vector.add(khInfo.getName());
		vector.add(khInfo.getDz());
		vector.add(khInfo.getTel());
		vector.add(khInfo.getLxr());
		vector.add(khInfo.getYhzh());
		vector.add(khInfo.getYb());
		vector.add(khInfo.getEmail());
		vector.add(khInfo.getBz());	
		return DaoFactory.getSellDao().addKh(vector);
	}
	
	public static boolean khUpdate(KhInfo khInfo)
	{
		Vector vector = new Vector();
		vector.add(khInfo.getId());
		vector.add(khInfo.getName());
		vector.add(khInfo.getDz());
		vector.add(khInfo.getTel());
		vector.add(khInfo.getLxr());
		vector.add(khInfo.getYhzh());
		vector.add(khInfo.getYb());
		vector.add(khInfo.getEmail());
		vector.add(khInfo.getBz());	
		return DaoFactory.getSellDao().updateKh(vector);
	}
	
	
}
