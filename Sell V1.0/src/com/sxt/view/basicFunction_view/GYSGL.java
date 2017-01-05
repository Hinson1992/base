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

public class GYSGL extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static JTable table;
	static JTextField textField_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GYSGL dialog = new GYSGL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GYSGL() {
		setTitle("供应商管理");
		setBounds(100, 100, 950, 534);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("增加供应商");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Gys_add();
				}
			});
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
			btnNewButton.setBounds(66, 25, 110, 24);
			contentPanel.add(btnNewButton);
		}
		{
			JButton button = new JButton("修改供应商");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table.setRowSelectionAllowed(true);
					Vector updateVector = new Vector();
					for(int i = 0;i<table.getColumnCount();i++)
					{
						updateVector.add(table.getValueAt(table.getSelectedRow(),i));
					}
					new Gys_update(updateVector);
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(209, 25,  110, 24);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("删除供应商");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int rowNum = table.getSelectedRow();
					String gysSelected_id = table.getValueAt(rowNum,0).toString();
					if(DaoFactory.getSellDao().deleteGys(gysSelected_id))
					{
						JOptionPane.showMessageDialog(GYSGL.this, "删除成功!");
						String[] tableHeads = new String[] {"供应商编号", "供应商名称", "地址",
								 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注" };
						TableModel model = new TableModel(tableHeads);
						model.setDataRows(DaoFactory.getSellDao().gysSearch());
						table.setModel(model);
						Tools.fitTableColumns(table);
						textField_1.setText(Integer.toString(table.getRowCount()));
					}
					else
					{
						JOptionPane.showMessageDialog(GYSGL.this, "删除失败!");
					}
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(350, 25,  110, 24);
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
			button.setBounds(495, 25,  110, 24);
			contentPanel.add(button);
		}
	/*	{
			JLabel label = new JLabel("   查询：");
			label.setFont(new Font("宋体", Font.PLAIN, 12));
			label.setBounds(630, 25, 54, 24);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(685, 26, 159, 24);
			contentPanel.add(textField);
			textField.setColumns(10);
		}*/
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
			JLabel label = new JLabel("供应商总数：");
			label.setBounds(46, 452, 88, 24);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(124, 452, 105, 24);
			contentPanel.add(textField_1);
		}
		table = new JTable();
		/*table.setEnabled(false);*/
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	/*	dftm = (DefaultTableModel) table.getModel();*/
		String[] tableHeads = new String[] { "供应商编号", "供应商名称", "地址",
				 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注" };
		TableModel model = new TableModel(tableHeads);
		model.setDataRows(DaoFactory.getSellDao().gysSearch());
		table.setModel(model);
		Tools.fitTableColumns(table); //调用自动填充table方法
		scrollPane.setViewportView(table);
		textField_1.setText(Integer.toString(table.getRowCount())); //获取供应商总数量
		JLabel label = new JLabel("Tips:请单击选中信息行进行修改、删除操作");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(620, 25, 305, 27);
		contentPanel.add(label);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
