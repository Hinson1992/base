package com.sxt.view.allQuery_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.service.UserService;
import com.sxt.tools.JDateChooser;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SellQuery extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private DefaultTableModel dftm;
	private JComboBox comboBox, comboBox_1;
	private JDateChooser jdc1,jdc2 =null;
	private JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SellQuery dialog = new SellQuery();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 创建一个销售查询dialog
	 */
	public SellQuery() {
		setTitle("销售查询");
		setBounds(100, 100, 610, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("选择查询条件：");
		lblNewLabel.setBounds(10, 10, 101, 15);
		contentPanel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(110, 7, 119, 21);
		contentPanel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"商品名称", "商品编号", "客户名称"}));
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(239, 7, 72, 21);
		contentPanel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "等于", "包含"}));
		textField = new JTextField();
		textField.setBounds(321, 7, 156, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		jdc1 = new JDateChooser(contentPanel,40);
		jdc1.setBounds(150,28,140, 50);
		
		jdc2 = new JDateChooser(contentPanel,40);
		jdc2.setBounds(300,28,140, 50);
		rdbtnNewRadioButton = new JRadioButton("指定查询日期");
		rdbtnNewRadioButton.setBounds(20, 41, 105, 23);
		contentPanel.add(rdbtnNewRadioButton);
		JButton btnNewButton = new JButton("查  询");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String conName, conOperation, content;
				Vector vector  = new Vector();
				conName = comboBox.getSelectedItem().toString().trim();
				conOperation = comboBox_1.getSelectedItem().toString().trim();
				content = textField.getText().trim();
				String sdate=jdc1.getDateField().getText().trim();
				String edate=jdc2.getDateField().getText().trim();
				//将查询条件形参传入查询方法中
				vector=UserService.sellSearchInfo(conName, conOperation, content, vector,rdbtnNewRadioButton,sdate,edate);
				String[] tableHeads = new String[] { "销售票号", "商品编号", "商品名称", "规格",
						"单价", "数量", "金额", "客户名称", "销售日期", "操作员", "经手人", "结算方式"  };
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
		btnNewButton.setBounds(491, 6, 93, 23);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("显示全部信息");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] tableHeads = new String[] {  "销售票号", "商品编号", "商品名称", "规格",
						"单价", "数量", "金额", "客户名称", "销售日期", "操作员", "经手人", "结算方式"  };
				TableModel model = new TableModel(tableHeads);
				model.setDataRows(DaoFactory.getSellDao().sellSearch());
				//将数据填充到table中
				table.setModel(model);
				//调用自动填充table方法	
				Tools.fitTableColumns(table); 
			}
		
		});
		button.setBounds(452, 41, 132, 23);
		contentPanel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 574, 235);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] { "销售票号", "商品编号", "商品名称", "规格",
				"单价", "数量", "金额", "客户全称", "销售日期", "操作员", "经手人", "结算方式" };
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel_1 = new JLabel("从");
		lblNewLabel_1.setBounds(131, 45, 22, 15);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(jdc1);
		contentPanel.add(jdc2);
		
		
		JLabel label = new JLabel("到");
		label.setBounds(289, 45, 22, 15);
		contentPanel.add(label);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
