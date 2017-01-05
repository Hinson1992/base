package com.sxt.tools;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
//工具类
public class Tools 
{
	public static Font f1 = new Font("楷体",Font.PLAIN,20);
	public static Font f2 = new Font("楷体",Font.PLAIN,15);
	public static Font f3 = new Font("黑体",Font.PLAIN,16);
	 public static void fitTableColumns(JTable myTable){
		  
         JTableHeader header = myTable.getTableHeader();
            int rowCount = myTable.getRowCount();
            Enumeration columns = myTable.getColumnModel().getColumns();
            while(columns.hasMoreElements()){
                TableColumn column = (TableColumn)columns.nextElement();
                int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
                int width = (int)myTable.getTableHeader().getDefaultRenderer()
                        .getTableCellRendererComponent(myTable, column.getIdentifier()
                                , false, false, -1, col).getPreferredSize().getWidth();
                for(int row = 0; row<rowCount; row++){
                    int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
                      myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                    width = Math.max(width, preferedWidth);
                }
                header.setResizingColumn(column); // 此行很重要
                column.setWidth(width+myTable.getIntercellSpacing().width + 4);//4，值目的是使表格看起来不是那么拥挤，起到间隔作用
            }
    }
}
