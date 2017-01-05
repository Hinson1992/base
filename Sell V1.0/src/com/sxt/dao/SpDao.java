package com.sxt.dao;

import java.util.Vector;

public interface SpDao {
       public Vector<Vector> spInquiry();//查询销售单
       public Boolean addXSD(Vector vector);//新增销售单
       public Boolean addXSXD(Vector vector);//新增销售详单
       public Boolean addJHD(Vector vector);//新增进货单
       //public Boolean addJHXD(Vector vector);//新增进货详单
       public Vector<Vector> xsdInquiry();//从库存中查询销售单信息
       public Vector<Vector> jhdInquiry();//从库存中查询进货单信息
       public Boolean addXSTD(Vector vector);//新增销售退单
       public Boolean addJHTD(Vector vector);//新增进货退单
       public Boolean deleteXSD(String xxdNum);//根据参数删除销售单
       public Boolean deleteXSXD(String xxdNum);//根据参数删除销售详单
       public Boolean deleteJHD(String jhdNum);//根据参数删除进货单
       public Boolean deleteJHXD(String jhddNum);//根据参数删除进货详单
}
