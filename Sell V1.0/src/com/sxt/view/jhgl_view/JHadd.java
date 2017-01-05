/*
 * PriceChangeDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sxt.view.jhgl_view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.KcInfo;


/**
 * 
 * @author __USER__
 */
public class JHadd extends javax.swing.JDialog implements
		ItemListener {
	private Vector<Vector> data;
	private Vector<String> name;

	/** Creates new form PriceChangeDialog */
	public JHadd() {
		setModal(true);
		setPreferredSize(new Dimension(600, 350));
		initComponents();
		setLocationRelativeTo(null);
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
		this.setLayout(null);
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		cd = new JTextField();
		bz = new JTextField();
		dj = new JTextField();
		jLabel16 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		gg = new JTextField();
		jc = new JTextField();
		dw = new JTextField();
		jLabel17 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1=new JTextField();
		

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("商品名称");

		jLabel2.setText("产地");
		cd.setText("jLabel6");

		jLabel3.setText("包装");
		bz.setText("jLabel7");

		jLabel4.setText("单价");
		dj.setText(" sdads");

		jComboBox1.setModel(new DefaultComboBoxModel());

		jLabel8.setText("规格");
		gg.setText("jLabel12");

		jLabel9.setText("简称");
		jc.setText("无");

		jLabel10.setText("单位");
		dw.setText("jLabel14");

		jLabel11.setText("数量");
		
		jTextField1.setText("1");

		jButton1.setText("确定");
		jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputnum = jTextField1.getText();
				
				dispose();
			}
		});

		jButton2.setText("关闭");
		jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		jLabel1.setBounds(30, 30, 90, 30);
		cd.setBounds(100, 70, 150, 30);
		bz.setBounds(100, 110, 150, 30);
		jLabel9.setBounds(360, 70, 90, 30);
		jLabel10.setBounds(360, 110, 90, 30);
		jLabel11.setBounds(360, 150, 90, 30);
		jc.setBounds(430, 70, 90, 30);
		dw.setBounds(430, 110, 90, 30);
		jTextField1.setBounds(430, 150, 90, 30);
		dj.setBounds(100, 150, 150, 30);
		jLabel16.setBounds(100, 190, 90, 30);
		jComboBox1.setBounds(100, 35, 150, 25);
		jLabel8.setBounds(360, 30, 90, 30);
		gg.setBounds(430, 30, 90, 30);
		jLabel2.setBounds(30, 70, 90, 30);
		jLabel3.setBounds(30, 110, 150, 30);
		jLabel4.setBounds(30, 150, 150, 30);
		jButton1.setBounds(150, 260, 80, 30);
		jButton2.setBounds(350, 260, 80, 30);

		name = new Vector<String>();
		data = DaoFactory.getSpDao().spInquiry();
		for (int i = 0; i < data.size(); i++) {
			String dbname = data.get(i).get(0).toString();
			name.add(dbname);
		}
		DefaultComboBoxModel dcbm = new DefaultComboBoxModel(name);
		jComboBox1.setModel(dcbm);
		jComboBox1.setEditable(true);

		// 下拉框加载时给此会话填充数据
		jComboBox1.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorRemoved(AncestorEvent event) {
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorAdded(AncestorEvent event) {
				setLableText(data, 0);
			}
		});

		this.add(dj);
		this.add(jTextField1);
		this.add(cd);
		this.add(bz);
		this.add(jLabel9);
		this.add(jLabel10);
		this.add(jLabel11);
		this.add(gg);
		this.add(jc);
		this.add(dw);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jLabel4);
		this.add(jLabel8);
		this.add(jComboBox1);
		this.add(jLabel1);
		this.add(jButton1);
		this.add(jButton2);
		jComboBox1.addItemListener(this);

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JHadd dialog = new JHadd();
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
	//获取到进货商品信息
    public  Vector getvector(){
    	if(inputnum==null){
    		inputnum=Integer.toString(0);
    	}
		for (int i = 0; i < data.size(); i++) {
			//判断是否为新商品入库
			if(data.get(i).get(0).equals(jComboBox1.getSelectedItem())){
				//新商品入库直接获取库存中信息，只修改数量
				data.get(i).add(inputnum);
				Vector myvector=data.get(i);
				return myvector;
			}
			else
			{
				//添加完整信息
				Vector myvector=new Vector();
				int id=DaoFactory.getSellDao().query("select max(kc_id) from kc_main");
				id = id+1;
				String newId = String.valueOf(id);
				KcInfo kcInfo = new KcInfo();
				kcInfo.setId(newId);
				kcInfo.setName(jComboBox1.getSelectedItem().toString());
				kcInfo.setCd(cd.getText());
				kcInfo.setDw(dw.getText());
				kcInfo.setGg(gg.getText());
				kcInfo.setBz(bz.getText());
				kcInfo.setDj(dj.getText());
				kcInfo.setSl(jTextField1.getText());
				DaoFactory.getSellDao().addKc(kcInfo);
				myvector.add(jComboBox1.getSelectedItem().toString());
				myvector.add(cd.getText());
				myvector.add(dw.getText());
				myvector.add(gg.getText());
				myvector.add(bz.getText());
				myvector.add(dj.getText());
				myvector.add(jTextField1.getText());
				return myvector;
			}
		}
    	
    	return null;	
    }
	public void setLableText(Vector<Vector> data, int i) {

		cd.setText(data.get(i).get(1).toString());

		bz.setText(data.get(i).get(4).toString());

		dj.setText(data.get(i).get(5).toString());

		gg.setText(data.get(i).get(3).toString());

		dw.setText(data.get(i).get(2).toString());

	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private JTextField gg;
	private JTextField jc;
	private JTextField dw;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private JTextField cd;
	private JTextField bz;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private JTextField dj;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private JTextField jTextField1;
	private String inputnum;

	// End of variables declaration//GEN-END:variables

	// 下拉框选择时填充会话内容的事件
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// TODO Auto-generated method stub
			int num = name.size();
			for (int i = 0; i < num; i++) {
				if (e.getItem().toString().equals(name.get(i)))
					setLableText(data, i);
		}

		}

	}

}