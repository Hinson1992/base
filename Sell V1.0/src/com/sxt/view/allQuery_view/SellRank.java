package com.sxt.view.allQuery_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

import java.util.Calendar;
import java.util.Vector;

public class SellRank extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox year,month,condition,operation;
	private DefaultTableModel dftm;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SellRank dialog = new SellRank();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 创建一个销售排行查询dialog
	 */
	public SellRank() {
		setBounds(100, 100, 636, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(10, 10, 54, 15);
			contentPanel.add(label);
		}
		{
			year = new JComboBox();
			year.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017","2018", "2019","2020", "2021","2022", "2023"}));
			year.setBounds(10, 10, 88, 21);
			contentPanel.add(year);
		}
		{
			month = new JComboBox();
			month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			month.setBounds(122, 10, 54, 21);
			contentPanel.add(month);
		}
		{
			JLabel lblNewLabel = new JLabel("年");
			lblNewLabel.setBounds(104, 13, 18, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("月份的销售信息，按");
			label.setBounds(183, 13, 119, 15);
			contentPanel.add(label);
		}
		{
			condition = new JComboBox();
			condition.setModel(new DefaultComboBoxModel(new String[] {"销售金额", "销售数量"}));
			condition.setBounds(302, 10, 88, 21);
			contentPanel.add(condition);
		}
		{
			JLabel label = new JLabel("进行");
			label.setBounds(400, 13, 37, 15);
			contentPanel.add(label);
		}
		{
			operation = new JComboBox();
			operation.setModel(new DefaultComboBoxModel(new String[] {"升序排列", "降序排列"}));
			operation.setBounds(428, 10, 88, 21);
			contentPanel.add(operation);
		}
		{
			JButton button = new JButton("确定");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Vector vector  = new Vector();
					String strMonth = (String) month.getSelectedItem();
					String date = year.getSelectedItem() +"-"+ strMonth;
					//选择不同的条件 金额或者数量
					String con = condition.getSelectedIndex() == 0 ? "SM_JE" : "SM_SL";
					//升序或者降序
					String opstr = operation.getSelectedIndex() == 0 ? " asc" : " desc";
					//将查询条件形参传入查询方法中
					vector=UserService.sellRankSearchInfo(con, opstr, date,vector);
					String[] tableHeads = new String[] { "商品编号", "商品名称", "销售金额",
							"销售数量","商品产地", "商品单位", "商品规格", "商品包装"};
					//新建一个数据模型
					TableModel model = new TableModel(tableHeads);
					//设置数据模型
					model.setDataRows(vector);
					//将数据填充到table中
					table.setModel(model);
					//调用自动填充table方法	
					Tools.fitTableColumns(table); 
				}
			});
			button.setBounds(521, 9, 93, 23);
			contentPanel.add(button);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 41, 600, 327);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] { "商品编号", "商品名称", "销售金额",
				"销售数量","商品产地", "商品单位", "商品规格", "商品包装" };
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	

}
