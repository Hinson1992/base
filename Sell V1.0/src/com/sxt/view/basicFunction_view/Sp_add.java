package com.sxt.view.basicFunction_view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.StockInfo;
import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.login_view.LoginDialog;
import com.sxt.view.table.model.TableModel;

public class Sp_add extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox combobox1;
	private JComboBox combobox2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sp_add dialog = new Sp_add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 创建商品添加窗口dialog
	 */
	public Sp_add() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//获取数据库中当前商品的最大id
				int newId = DaoFactory.getSellDao().query("select max(sp_id) from tb_spinfo");
				//在原来基础上id+1
				newId +=1; 
				textField.setText(newId+"");
				//设置商品批号格式
				textField_8.setText("ph"+newId+"9527");
			}
		});
		setTitle("新增商品");
		setBounds(100, 100, 514, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("商品编号：");
			lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
			lblNewLabel.setBounds(29, 10, 76, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(110, 12, 124, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(321, 12, 136, 21);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(110, 43, 124, 21);
			contentPanel.add(textField_2);
		}
		{
			combobox1 = new JComboBox();
			combobox1.setModel(new DefaultComboBoxModel(new String[] {"袋", "瓶", "箱", "盒", "斤", "包", "条", "台", "架", "卷", "匹", "个", "副"}));
			combobox1.setBounds(321, 43, 136, 21);
			combobox1.setEditable(true);
			contentPanel.add(combobox1);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(110, 74, 124, 21);
			contentPanel.add(textField_4);
		}
		{
			combobox2 = new JComboBox();
			combobox2.setModel(new DefaultComboBoxModel(new String[] {"纸","竹","木","金属","搪瓷","陶瓷","塑料","橡胶"}));
			combobox2.setEditable(true);
			combobox2.setBounds(321, 74, 136, 21);
			contentPanel.add(combobox2);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(109, 140, 352, 21);
			contentPanel.add(textField_6);
		}
		{
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(110, 173, 351, 21);
			contentPanel.add(textField_7);
		}
		{
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(110, 105, 352, 21);
			contentPanel.add(textField_8);
		}
		{
			JButton btnNewButton = new JButton("确认增加");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					textField.setEditable(false);
					//通过数据对象保存数据
					StockInfo si = new StockInfo();
					si.setId(textField.getText());
					si.setSpname(textField_1.getText());
					si.setCd(textField_2.getText());
					si.setDw(combobox1.getSelectedItem().toString());
					si.setGg(textField_4.getText());
					si.setBz(combobox2.getSelectedItem().toString());
					si.setMemo(textField_7.getText());
					si.setGysname(textField_6.getText());
					si.setPh(textField_8.getText());
					//判断是否添加成功
					if (UserService.spAdd(si)) {
						JOptionPane.showMessageDialog(Sp_add.this, "新增成功!");
						String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
								"规格", "包装", "备注", "供应商全称", "批号"  };
						//新建数据模型
						TableModel model = new TableModel(tableHeads);
						//设置数据模型
						model.setDataRows(DaoFactory.getSellDao().spSearch());
						//填充数据到商品管理界面的table
						SPGL_VIEW.table.setModel(model);
						//设置商品管理界面的商品总类数
						SPGL_VIEW.textField_1.setText(Integer.toString(SPGL_VIEW.table.getRowCount()));
						//通过工具调用自动调整table宽度大小方法
						Tools.fitTableColumns(SPGL_VIEW.table);
						Sp_add.this.setVisible(false);
						Sp_add.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Sp_add.this, "新增失败!");
					}
				
				}
			});
			btnNewButton.setBounds(209, 215, 93, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton button = new JButton("退出");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			button.setBounds(369, 215, 93, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("商品产地：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 41, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("商品名称：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(244, 10, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("计量单位：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(244, 41, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("包装类型：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(244, 72, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("产品规格：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 72, 70, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("供 应 商：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 140, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("备    注：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 171, 76, 24);
			contentPanel.add(label);
		}
		
		JLabel label = new JLabel("批    号：");
		label.setFont(new Font("楷体", Font.PLAIN, 14));
		label.setBounds(29, 106, 76, 24);
		contentPanel.add(label);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
