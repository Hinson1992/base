/*
 * StorehouseDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sxt.view.kcgl_view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.view.table.model.KcpdTableModel;

/**
 * 
 * @author __USER__
 */
public class KcpdDialog extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6477103977514100822L;
	private JToolBar jToolBar;
	private JLabel jb1;
	private JLabel jb2;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private  JTable jTable1;
	private  JTable jTable2;
	private JButton jButton1;
	private JButton jButton2;
	private   KcpdTableModel storehouseModel1=null;
	private   KcpdTableModel storehouseModel2=null;
	private   KcpdTableModel st = new KcpdTableModel();
	private  static Vector<Vector> table1vector;
	private  static Vector<Vector> table2vector;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;

	/** Creates new form StorehouseDialog */
	public KcpdDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("库存盘点");
		setModal(true);
		setName("store_dialog");
		setResizable(false);
		setPreferredSize(new Dimension(809, 483));
		setLayout(new BorderLayout());

		jToolBar = new JToolBar();
		jb1 = new JLabel("         ");
		jb1.setSize(800, 80);
		jToolBar.add(jb1);
		getContentPane().add(jToolBar, BorderLayout.NORTH);

		jPanel1 = new JPanel(new BorderLayout());
		getContentPane().add(jPanel1, BorderLayout.CENTER);
		
		StoreJsearchBar storeJsearchBar = new StoreJsearchBar();
		/*JLabel jLabel1=new JLabel("盘点员:");
		storeJsearchBar.add(jLabel1);*/
		/*storeJsearchBar.add(new JTextField(10));*/
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	    JTextField jt=new JTextField(df.format(new Date()), 8);
	    jb2 = new JLabel();
	    jt.setEditable(false);
		storeJsearchBar.add(new JLabel("盘点时间"));
		storeJsearchBar.add(jt);     
		storeJsearchBar.add(new JLabel("商品总数:"));
		storeJsearchBar.add(jb2);
		jPanel1.add(storeJsearchBar, BorderLayout.NORTH);

		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 2));

		jTable1 = new JTable();
		jTable2 = new JTable();
		
		storehouseModel1 = new KcpdTableModel();
		storehouseModel2 = st;
		table1vector = DaoFactory.getKcDao().goodsInquiry();
		jb2.setText(Integer.toString(table1vector.size()));
		storehouseModel1.setdata(table1vector);
		jTable1.setModel(storehouseModel1);

		jTable2.setModel(storehouseModel2);
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// 设置表格的列宽
		for (int i = 0; i < jTable1.getColumnCount(); i++) {

			jTable1.getColumnModel().getColumn(i).setMinWidth(70);
			jTable2.getColumnModel().getColumn(i).setMinWidth(70);
		}

		jScrollPane1 = new JScrollPane(jTable1);
		jScrollPane1
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jScrollPane2 = new JScrollPane(jTable2);
		jScrollPane2
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jScrollPane2
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jPanel3 = new JPanel(new GridLayout());

		jButton1 = new JButton("确定");
		jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// jbutton1确定按钮添加事件 选中若干行并点击确定将若干行移到右边进行显示
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jTable1.getSelectedRow() != -1) {;
					int[] arr = jTable1.getSelectedRows();
					table2vector=DaoFactory.getKcDao().goodsInquiry();
					setTable(table1vector, table2vector, arr);
					storehouseModel2.setCellEditable(true);	
				}
			}
		});
		
		jPanel3.add(new JLabel());
		jPanel3.add(new JLabel());
		jPanel3.add(jButton1);
		jPanel3.add(new JLabel());
		jPanel3.add(new JLabel());
//		jPanel3.add(jLabel2);
		jButton2 = new JButton("确定");
		jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jPanel3.add(jButton2);
		jButton2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(table2vector!=null){
					int updatecount=0;
				for (int i = 0; i < table2vector.size(); i++) {
					updatecount += DaoFactory.getKcDao().goodsNumUpdate(
							table2vector.get(i));
				}
				table1vector = DaoFactory.getKcDao()
						.goodsInquiry();
				table2vector=null;
				storehouseModel1.setdata(table1vector);
				storehouseModel2.setdata(table2vector);
				jTable1.setModel(storehouseModel1);
				jTable2.setModel(storehouseModel2);
				repaint();
			}}
		});

		jPanel1.add(jPanel3, BorderLayout.SOUTH);
		jPanel1.add(jPanel2, BorderLayout.CENTER);

		jPanel2.add(jScrollPane1);
		jPanel2.add(jScrollPane2);

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	
	//封装一个从一个表格移动正行数据到另外一个表格的方法
	public void setTable(Vector<Vector> a, Vector<Vector> b, int[] arr) {
		int count = 0;
		for (int index : arr) {
			index -= count;
			a.remove(index);
			count = count + 1;

		}
		if (a.size() != 0) {
			b.removeAll(a);
			storehouseModel1.setdata(a);
			storehouseModel2.setdata(b);
			jTable2.setModel(storehouseModel2);
			jTable1.setModel(storehouseModel1);

		} else {
			KcpdTableModel st=(KcpdTableModel)jTable1.getModel();
			st.getdata().clear();
			jTable1.setModel(st);
			jTable1.updateUI();//更新表格内容 
			storehouseModel2.setdata(b);
			jTable2.setModel(storehouseModel2);
		}
		jScrollPane1.repaint();
		jScrollPane2.repaint();
		
	}
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				KcpdDialog dialog = new KcpdDialog(
						new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	// End of variables declaration//GEN-END:variables

}