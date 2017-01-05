package com.sxt.view.table.model;

import java.awt.Stroke;
import java.util.Vector;

import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class KcpdTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	// private static final long serialVersionUID = -5746119024815027439L;
	private Vector<Vector> data = new Vector<Vector>();
	private  String[] head = {"商品编号", "商品名称", "产地", "商品计量单位", "商品规格",
		"包装类型", "单价", "数量"};
	private Boolean bool=false;

	public KcpdTableModel() {
		this.data = null;
	}

	public KcpdTableModel(String[] head) {
		this.head = head;
		this.data = null;
	}

	public KcpdTableModel(String[] head, Vector<Vector> data) {
		this.head = head;
		this.data = data;
	}

	public Vector<Vector> getdata() {
		return data;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return head[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (data == null) {
			return 0;
		} else
			return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if (data == null) {
			return head.length;
		} else {
			return data.get(0).size();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (data == null) {
			return -1;
		} else
			return data.get(rowIndex).get(columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (data == null) {
			setValueAt(-1, rowIndex, columnIndex);
		} else
			data.get(rowIndex).set(columnIndex, aValue);
	}

	public void setdata(final Vector<Vector> inputdata) {
		this.data = inputdata;
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (data == null) {
					setdata(data);
				}
				
				fireTableDataChanged();
			}
		});
	}

	public Boolean setCellEditable(Boolean bool) {
		this.bool=bool;
		return bool;

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (!setCellEditable(bool)){
			return false;
			}
		else{
            if(columnIndex==7)
			return true;
            else return false;
            }
		

	}

}
