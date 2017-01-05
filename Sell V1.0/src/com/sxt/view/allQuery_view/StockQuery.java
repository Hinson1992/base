package com.sxt.view.allQuery_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import com.sxt.dao.Sql;
import com.sxt.dao.factory.DaoFactory;
import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

public class StockQuery extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox,comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StockQuery dialog = new StockQuery();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 创建一个商品查询dialog
	 */
	public StockQuery() {
		
		setTitle("商品信息查询");
		setBounds(100, 100, 651, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("选择查询条件：");
			lblNewLabel.setBounds(10, 10, 97, 15);
			contentPanel.add(lblNewLabel);
		}
		
		comboBox = new JComboBox();
		comboBox.setBounds(105, 7, 121, 21);
		contentPanel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "商品名称",
				"供应商名称", "产地", "包装" }));
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"等于", "包含"}));
		comboBox_1.setBounds(229, 7, 70, 21);
		contentPanel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(305, 7, 126, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String conName, conOperation, content;
				Vector vector  = new Vector();
				conName = comboBox.getSelectedItem().toString().trim();
				conOperation = comboBox_1.getSelectedItem().toString().trim();
				content = textField.getText().trim();
				//将查询条件形参传入查询方法中
				vector=UserService.stockSearchInfo(conName, conOperation, content, vector);
				String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
						"规格", "包装", "备注", "供应商全称", "批号", };
				//新建一个数据模型
				TableModel model = new TableModel(tableHeads);
				//设置新的数据模型
				model.setDataRows(vector);
				//将数据填充到table中那个
				table.setModel(model);
				//调用自动填充table方法
				Tools.fitTableColumns(table); 
			}
		});
		btnNewButton.setBounds(437, 6, 70, 23);
		contentPanel.add(btnNewButton);
		
	
		JButton btnNewButton_1 = new JButton("显示全部信息");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
						"规格", "包装", "备注", "供应商全称", "批号"};
				TableModel model = new TableModel(tableHeads);
				//设置新的数据模型
				model.setDataRows(DaoFactory.getSellDao().spSearch());
				//将数据填充到table
				table.setModel(model);
				//调用自动填充table方法
				Tools.fitTableColumns(table); 
			}
		});
		btnNewButton_1.setBounds(509, 6, 116, 23);
		contentPanel.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 615, 335);
		contentPanel.add(scrollPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				table = new JTable();
				table.setEnabled(false);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
				String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
						"规格", "包装", "备注", "供应商全称", "批号", };
				dftm.setColumnIdentifiers(tableHeads);
				scrollPane.setViewportView(table);
			}
		});
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
	} 
}
