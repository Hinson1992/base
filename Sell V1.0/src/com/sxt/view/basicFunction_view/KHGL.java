package com.sxt.view.basicFunction_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

public class KHGL extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static JTable table;
	static JTextField textField_1;
	private JScrollPane scrollPane;
	static Vector updateVector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KHGL dialog = new KHGL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KHGL() {
		
		setTitle("客户管理");
		setBounds(100, 100, 939, 534);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("增加客户");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Kh_add();
				}
			});
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
			btnNewButton.setBounds(66, 25, 93, 24);
			contentPanel.add(btnNewButton);
		}
		{
			JButton button = new JButton("修改客户");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table.setRowSelectionAllowed(true);
					Vector updateVector = new Vector();
					//从当前界面的table中获取到当前选中行的数据并保存到vector当中
					for(int i = 0;i<table.getColumnCount();i++)
					{
						updateVector.add(table.getValueAt(table.getSelectedRow(),i));
					}
					//通过构造方法传入并在构造方法中处理这些数据
					new Kh_update(updateVector);
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(209, 25, 93, 24);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("删除客户");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowNum = table.getSelectedRow();
					String khSelected_id = table.getValueAt(rowNum,0).toString();
					//判断删除是否成功
					if(DaoFactory.getSellDao().deleteKh(khSelected_id))
					{
						JOptionPane.showMessageDialog(KHGL.this, "删除成功!");
						String[] tableHeads = new String[] {"客户编号", "客户名称", "地址",
								 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注" };
						//获取数据模型
						TableModel model = new TableModel(tableHeads);
						//设置新增过信息后的数据模型
						model.setDataRows(DaoFactory.getSellDao().khSearch());
						//在客户管理界面更新table
						table.setModel(model);
						//调用自动调整table宽度方法
						Tools.fitTableColumns(table);
						//在客户管理界面更更新客户总数
						textField_1.setText(Integer.toString(table.getRowCount()));
					}
					else
					{
						JOptionPane.showMessageDialog(KHGL.this, "删除失败!");
					}
				
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(350, 25, 93, 24);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("退出");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(495, 25, 93, 24);
			contentPanel.add(button);
		}

		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 70, 903, 373);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JLabel label = new JLabel("客户总数：");
			label.setBounds(46, 452, 68, 24);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(124, 452, 105, 24);
			contentPanel.add(textField_1);
		}
		table = new JTable();
		//将初始table设置为不自动调整
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		String[] tableHeads = new String[] { "客户编号", "客户名称", "地址",
				 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注"};
		TableModel model = new TableModel(tableHeads);
		//设置当前的数据模型
		model.setDataRows(DaoFactory.getSellDao().khSearch());
		table.setModel(model);
		Tools.fitTableColumns(table); //调用自动填充table方法
		scrollPane.setViewportView(table);
		textField_1.setText(Integer.toString(table.getRowCount())); //获取供应商总数量
		JLabel label = new JLabel("Tips:请单击选中信息行进行修改、删除操作");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(609, 25, 304, 27);
		contentPanel.add(label);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
