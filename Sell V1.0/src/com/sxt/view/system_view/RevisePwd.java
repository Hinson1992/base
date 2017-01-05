package com.sxt.view.system_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.pojo.UserInfo;
import com.sxt.view.login_view.LoginDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class RevisePwd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField oldPwd;
	private JPasswordField newPwd1;
	private JPasswordField newPwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RevisePwd dialog = new RevisePwd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RevisePwd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//从登录界面登陆时获取到登录信息
				String userName = LoginDialog.uesrInfo.getUsername();
				userName ="'"+userName+"'";
				//将登录信息显示在界面
				Vector<String> uservector = DaoFactory.getSellDao().selectUser(userName);
				textField.setText(uservector.get(0).toString());
				textField_1.setText(uservector.get(1).toString());
			}
		});
		setTitle("密码修改");
		setBounds(100, 100, 299, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登 录 名：");
		lblNewLabel.setBounds(23, 23, 66, 15);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(93, 20, 150, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(93, 48, 150, 21);
		contentPanel.add(textField_1);
		
		JLabel label = new JLabel("用户姓名：");
		label.setBounds(23, 51, 66, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("旧 密 码：");
		label_1.setBounds(23, 76, 66, 15);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("新 密 码：");
		label_2.setBounds(23, 101, 66, 15);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("确认新密码：");
		label_3.setBounds(10, 126, 79, 15);
		contentPanel.add(label_3);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName= textField_1.getText();
				String oldpwd=new String(oldPwd.getPassword());
				String newpwd1=new String(newPwd1.getPassword());
				String newpwd2=new String(newPwd2.getPassword());
				//判断新的密码两次是否相同
				if (newpwd1.equals(newpwd2)) {
					//执行更新密码sql语句
					DaoFactory.getSellDao().updatePwd(userName,newpwd1);
					JOptionPane.showMessageDialog(getContentPane(),
							"密码修改成功,请重新登录");
					RevisePwd.this.dispose();
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(getContentPane(),
							"两次输入的密码不一致，请重新输入。");
				}
			}
		});
		btnNewButton.setBounds(103, 154, 93, 23);
		contentPanel.add(btnNewButton);
		
		oldPwd = new JPasswordField();
		oldPwd.setBounds(93, 73, 150, 21);
		contentPanel.add(oldPwd);
		
		newPwd1 = new JPasswordField();
		newPwd1.setBounds(93, 98, 150, 21);
		contentPanel.add(newPwd1);
		
		newPwd2 = new JPasswordField();
		newPwd2.setBounds(93, 123, 150, 21);
		contentPanel.add(newPwd2);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
