package com.sxt.view.basicFunction_view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.GysInfo;
import com.sxt.pojo.KhInfo;
import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

public class Kh_update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField bh;
	private JTextField mc;
	private JTextField khdz;
	private JTextField tel;
	private JTextField lxr;
	private JTextField yhzh;
	private JTextField email;
	private JTextField bz;
	private JTextField yb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Kh_update dialog = new Kh_update(KHGL.updateVector);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 创建客户更新的dialog
	 */
	public Kh_update(final Vector updateVector) {
		addWindowListener(new WindowAdapter() {
			//将从客户管理界面获取的vector放到更新界面中
			@Override
			public void windowOpened(WindowEvent e) {
				bh.setText(updateVector.get(0).toString());
				mc.setText(updateVector.get(1).toString());
				khdz.setText(updateVector.get(2).toString());
				tel.setText(updateVector.get(3).toString());	
				lxr.setText(updateVector.get(4).toString());
				yhzh.setText(updateVector.get(5).toString());
				yb.setText(updateVector.get(6).toString());
				email.setText(updateVector.get(7).toString());
				bz.setText(updateVector.get(8).toString());
			}
		});
		setTitle("修改客户");
		setBounds(100, 100, 516, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel(" 客户编号：");
			lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
			lblNewLabel.setBounds(22, 26, 86, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			bh = new JTextField();
			bh.setEditable(false);
			bh.setBounds(106, 28, 140, 21);
			contentPanel.add(bh);
			bh.setColumns(10);
		}
		{
			mc = new JTextField();
			mc.setColumns(10);
			mc.setBounds(354, 28, 136, 21);
			contentPanel.add(mc);
		}
		{
			khdz = new JTextField();
			khdz.setColumns(10);
			khdz.setBounds(106, 123, 384, 21);
			contentPanel.add(khdz);
		}
		{
			tel = new JTextField();
			tel.setColumns(10);
			tel.setBounds(106, 60, 140, 21);
			contentPanel.add(tel);
		}
		{
			lxr = new JTextField();
			lxr.setColumns(10);
			lxr.setBounds(354, 59, 136, 21);
			contentPanel.add(lxr);
		}
		{
			yhzh = new JTextField();
			yhzh.setColumns(10);
			yhzh.setBounds(106, 154, 384, 21);
			contentPanel.add(yhzh);
		}
		{
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(106, 91, 140, 21);
			contentPanel.add(email);
		}
		{
			JButton btnNewButton = new JButton("确认修改");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//将新的数据设置到客户对象当中
					KhInfo khInfo= new KhInfo();
					khInfo.setId(bh.getText());
					khInfo.setName(mc.getText());
					khInfo.setDz(khdz.getText());
					khInfo.setTel(tel.getText());
					khInfo.setLxr(lxr.getText());
					khInfo.setYhzh(yhzh.getText());
					khInfo.setYb(yb.getText());
					khInfo.setEmail(email.getText());
					khInfo.setBz(bz.getText());
					//判断是否更新成功
					if (UserService.khUpdate(khInfo)) {
						JOptionPane.showMessageDialog(Kh_update.this, "修改成功!");
						String[] tableHeads = new String[] { "客户编号", "客户名称", "地址",
								 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注" };
						//获取数据模型
						TableModel model = new TableModel(tableHeads);
						//设置新增过信息后的数据模型
						model.setDataRows(DaoFactory.getSellDao().khSearch());
						//在客户管理界面更新table
						KHGL.table.setModel(model);
						//在客户管理界面更更新客户总数
						KHGL.textField_1.setText(Integer.toString(KHGL.table.getRowCount()));
						//调用自动调整table宽度方法
						Tools.fitTableColumns(KHGL.table);
						Kh_update.this.setVisible(false);
						Kh_update.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Kh_update.this, "修改失败!");
					}
				
				}
			});
			btnNewButton.setBounds(106, 237, 93, 23);
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
			button.setBounds(376, 237, 93, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel(" 客户地址：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(19, 122, 86, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("客户名称：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(266, 26, 88, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("联 系 人：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(268, 57, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("联系电话：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 58, 70, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("银行帐号：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 154, 76, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("电子邮箱：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(29, 91, 76, 24);
			contentPanel.add(label);
		}
		
		JLabel label = new JLabel("备    注：");
		label.setFont(new Font("楷体", Font.PLAIN, 14));
		label.setBounds(29, 185, 76, 24);
		contentPanel.add(label);
		
		bz = new JTextField();
		bz.setColumns(10);
		bz.setBounds(106, 187, 384, 21);
		contentPanel.add(bz);
		
		JLabel label_1 = new JLabel("邮    编：");
		label_1.setFont(new Font("楷体", Font.PLAIN, 14));
		label_1.setBounds(268, 89, 76, 24);
		contentPanel.add(label_1);
		
		yb = new JTextField();
		yb.setColumns(10);
		yb.setBounds(354, 90, 136, 21);
		contentPanel.add(yb);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
