package com.sxt.dao;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;

import com.sxt.pojo.KcInfo;

public interface SellDao {
	boolean login(String username,String password);
	Vector<Vector> spSearch(); //查询所有商品信息
	Vector<Vector> spSearch(String sql); //查询指定条件商品信息
	Vector<Vector> khSearch(); //查询所有客户信息
	Vector<Vector> khSearch(String sql); //查询指定条件客户信息
	Vector<Vector> gysSearch(); //查询所有供应商信息
	Vector<Vector> gysSearch(String sql); //查询指定条件供应商信息
	Vector<Vector> rkSearch(); //查询所有入库信息
	Vector<Vector> rkSearch(String sql); //查询指定条件入库信息
	Vector<Vector> sellSearch(); //查询所有销售信息
	Vector<Vector> sellSearch(String sql); //查询所有销售信息
	Vector<Vector> sellRankSearch(String sql);//销售排行查询
	boolean addSp(Vector sp);  //新增商品信息
	boolean deleteSP(String spSelected_id); //删除商品
	boolean updateSp(Vector sp); //修改商品信息
	boolean addGys(Vector gysinfo);  //新增商品信息
	boolean deleteGys(String gysSelected_id); //删除供应商
	boolean updateGys(Vector gysinfo); //修改商品信息
	boolean addKh(Vector khinfo);  //新增客户信息
	boolean deleteKh(String khSelected_id); //删除客户
	boolean updateKh(Vector khinfo); //修改客户信息
	boolean updatePwd(String userName,String newPwd); //修改商品信息
	Vector<String> selectUser(String userName);
	/*int datebaseBackUp(String sql); //数据库备份
*/	int query(String QueryStr); //查询最大ID
	int getNum(String id); //获取删除的当前列的商品剩余数量
	public int sdQuery(String QueryStr);//查询销售详单的最大的ID
	public Boolean addXSXD(String SD_ID,String KC_ID,String SM_DJ,String SM_ID1,String SM_SL);//增加销售详单
	public Boolean addJHXD(String TRM_ID,String KC_ID,String TRTM_DJ,String TRTM_ID1,String TRTM_SL);//增加销售详单
	public Vector<Vector> xxsdSearch(String xsDH);//根据销售单号查询销售明细详单
	public int xtmQuery(String QueryStr);//查询销售退货单的最大的ID
	public String cxKhName(String KH_ID);//通过客户id查询客户的名称
	public String cxGysName(String TG_ID);//通过供应商id查询供应商的名称
	public Vector<Vector> jhxdSearch(String xsDH);//通过进货单号获取进货信息
	boolean addKc(KcInfo kcInfo);  //新增商品信息
}
