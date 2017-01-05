package com.sxt.dao;
public interface Sql 
{
	String SQL_SP_QUERY = "select * from tb_spinfo order by SP_ID";
	String SQL_someSP_QUERY = "select * from Tb_Spinfo where ";
	
	String SQL_KH_QUERY = "select * from KH_MAIN  order by  KH_ID";
	String SQL_someKH_QUERY = "select * from KH_MAIN  where ";
	
	String SQL_GYS_QUERY = "select * from tb_gysinfo order by TG_ID";
	String SQL_someGYS_QUERY = "select * from TB_GYSINFO where ";
	
	String SQL_RK_QUERY = "select * from  V$RKQUERY order by TRM_ID";
	String SQL_someRK_QUERY = "select * from V$RKQUERY where ";
	
	String SQL_SELL_QUERY = "select * from  V$SELLQUERY order by SD_ID";
	String SQL_someSELL_QUERY = "select * from V$SELLQUERY where ";
	
	String SQL_SELL_RANK_QUERY = "select KC_ID,KC_NAME,SM_JE,SM_SL,KC_LOC,KC_DW,KC_GG,KC_BZ from V$SELLRANKQUERY where";
	
	String SQL_SP_ADD = "insert into tb_spinfo values(?,?,?,?,?,?,?,?,?)";
	String SQL_KC_ADD = "insert into kc_main values(?,?,?,?,?,?,?,?)";
	String SQL_SP_DELETE = "delete  from tb_spinfo  where SP_ID=?";
	String SQL_SP_UPDATE = "update tb_spinfo set "
			+ "SP_ID=?,SP_NAME=?, SP_LOC=?,SP_DW=?, SP_GG=?,SP_BZ=?,SP_MEMO=?, SP_GYS=?,SP_PH=? "
			+ "where SP_ID=? ";
	
	String SQL_GYS_ADD = "insert into tb_gysinfo values(?,?,?,?,?,?,?,?,?)";
	String SQL_GYS_DELETE = "delete  from tb_gysinfo  where TG_ID=?";
	String SQL_GYS_UPDATE = "update tb_gysinfo set "
			+ "TG_ID=?,TG_NAME=?, TG_ADDRESS=?,TG_TEL=?, TG_LIAN=?,TG_YHZH=?,TG_YB=?, TG_EMAIL=?,TG_BZ=? "
			+ "where TG_ID=? ";
	
	String SQL_KH_ADD = "insert into kh_main values(?,?,?,?,?,?,?,?,?)";
	String SQL_KH_DELETE = "delete  from kh_main  where KH_ID=?";
	String SQL_KH_UPDATE = "update kh_main set "
			+ "KH_ID=?,KH_NAME=?, KH_ADDRESS=?,KH_TEL=?, KH_LIAN=?,KH_YHZH=?,KH_YB=?, KH_EMAIL=?,KH_BZ=? "
			+ "where KH_ID=? ";
	
	String SQL_PWD_UPDATE ="update DENGLU set PASSWORD=? where USERNAME=? ";
	String SQL_PWD_SELECT ="select id,username from denglu where USERNAME=";
	
	
}
