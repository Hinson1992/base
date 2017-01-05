package com.sxt.view.allQuery_view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

public class GysQuery extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	JComboBox comboBox,comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GysQuery dialog = new GysQuery();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GysQuery() {
		setTitle("供应商信息查询");
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "编号","名称","地址"}));
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
				//将查询条件传入查询方法中
				vector=UserService.gysSearchInfo(conName, conOperation, content, vector);
				String[] tableHeads = new String[] { "供应商编号", "供应商名称", "地址",
						 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注"  };
				//新建一个数据模型
				TableModel model = new TableModel(tableHeads);
				//设置数据模型
				model.setDataRows(vector);
				//将数据显示在界面table中
				table.setModel(model);
				//调用自动调整表格宽度方法
				Tools.fitTableColumns(table); //调用自动填充table方法
			}
		});
		btnNewButton.setBounds(437, 6, 70, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("显示全部信息");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String[] tableHeads = new String[] { "供应商编号", "供应商名称", "地址",
							 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注" };
					//新建一个数据模型
					TableModel model = new TableModel(tableHeads);
					//设置数据模型
					model.setDataRows(DaoFactory.getSellDao().gysSearch());
					//数据填充到table中
					table.setModel(model);
					//调用自动填充table方法
					Tools.fitTableColumns(table); 
				}
		});
		btnNewButton_1.setBounds(509, 6, 116, 23);
		contentPanel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 615, 335);
		contentPanel.add(scrollPane);
		
		/*
		 * open dialog
		 * 初始化界面
		 * **/
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		final DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] tableHeads = new String[] {  "供应商编号", "供应商名称", "地址",
				 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注"};
		dftm.setColumnIdentifiers(tableHeads);
		scrollPane.setViewportView(table);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
