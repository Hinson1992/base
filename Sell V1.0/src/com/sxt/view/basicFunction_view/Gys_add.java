package com.sxt.view.basicFunction_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.GysInfo;
import com.sxt.service.UserService;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gys_add extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField bh;
	private JTextField mc;
	private JTextField gysdz;
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
			Gys_add dialog = new Gys_add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gys_add() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				int newId = DaoFactory.getSellDao().query("select max(tg_id) from tb_gysinfo");
				newId +=1; 
				bh.setText(newId+"");
			}
		});
		setTitle("新增供应商");
		setBounds(100, 100, 516, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("供应商编号：");
			lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
			lblNewLabel.setBounds(19, 26, 86, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			bh = new JTextField();
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
			gysdz = new JTextField();
			gysdz.setColumns(10);
			gysdz.setBounds(106, 123, 384, 21);
			contentPanel.add(gysdz);
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
			JButton btnNewButton = new JButton("确认增加");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					bh.setEditable(false);
					GysInfo gysinfo= new GysInfo();
					gysinfo.setId(bh.getText());
					gysinfo.setName(mc.getText());
					gysinfo.setDz(gysdz.getText());
					gysinfo.setTel(tel.getText());
					gysinfo.setLxr(lxr.getText());
					gysinfo.setYhzh(yhzh.getText());
					gysinfo.setYb(yb.getText());
					gysinfo.setEmail(email.getText());
					gysinfo.setBz(bz.getText());
					
					if (UserService.gysAdd(gysinfo)) {
						JOptionPane.showMessageDialog(Gys_add.this, "新增成功!");
						String[] tableHeads = new String[] {"供应商编号", "供应商名称", "地址",
								 "联系人电话", "联系人", "银行账户", "邮编","电子邮箱", "备注"  };
						TableModel model = new TableModel(tableHeads);
						model.setDataRows(DaoFactory.getSellDao().gysSearch());
						GYSGL.table.setModel(model);
						GYSGL.textField_1.setText(Integer.toString(GYSGL.table.getRowCount()));
						Tools.fitTableColumns(GYSGL.table);
						Gys_add.this.setVisible(false);
						Gys_add.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Gys_add.this, "新增失败!");
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
			JLabel label = new JLabel("供应商地址：");
			label.setFont(new Font("楷体", Font.PLAIN, 14));
			label.setBounds(19, 122, 86, 24);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("供应商名称：");
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
