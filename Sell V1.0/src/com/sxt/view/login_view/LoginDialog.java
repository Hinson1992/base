package com.sxt.view.login_view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.sxt.pojo.UserInfo;
import com.sxt.service.UserService;
import com.sxt.view.UserLand;


public class LoginDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;
	private JLabel jLabel = null;
	private JTextField userField = null;
	private JLabel jLabel1 = null;
	private JPasswordField passwordField = null;
	private JButton loginButton = null;
	private JButton exitButton = null;
	private static String userStr;
	public static UserInfo uesrInfo ;
	Image image;
	/*private MainFrame mainFrame;*/
	
	public LoginDialog() {
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
			/*mainFrame = new MainFrame();*/
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化loginPanel登录面板的方法
	 * 
	 * @return com.lzw.login.LoginPanel
	 */
	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));
			jLabel1.setText("密　码：");
			jLabel = new JLabel();
			jLabel.setText("用户名：");
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));
			loginPanel = new LoginPanel();
			loginPanel.setLayout(null);
			loginPanel.setBackground(new Color(0xD8DDC7));
			loginPanel.add(jLabel, null);
			loginPanel.add(getUserField(), null);
			loginPanel.add(jLabel1, null);
			loginPanel.add(getPasswordField(), null);
			loginPanel.add(getLoginButton(), null);
			loginPanel.add(getExitButton(), null);
		}
		return loginPanel;
	}
	
	/**
	 * This method initializes userField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getUserField() {
		if (userField == null) {
			userField = new JTextField();
			userField.setBounds(new Rectangle(142, 39, 127, 22));
		}
		return userField;
	}
	
	/**
	 * This method initializes passwordField
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));
			passwordField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')
						loginButton.doClick();
				}
			});
		}
		return passwordField;
	}
	
	/**
	 * 界面登录方法
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getLoginButton() {
		if (loginButton == null) {
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));
			loginButton.setIcon(new ImageIcon(getClass().getResource(
					"/res/loginButton.jpg")));
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = userField.getText();
					String password = passwordField.getText();
					uesrInfo = new UserInfo();
					uesrInfo.setUsername(username);
					uesrInfo.setPassword(password);
					if(UserService.login(username, password))
					{
						LoginDialog.this.setVisible(false);
						LoginDialog.this.dispose();
						new UserLand();
					}else{
						JOptionPane.showMessageDialog(LoginDialog.this, "账户或密码错误!");
					}
				}
				
				
			});
		}
		return loginButton;
	}
	
	/**
	 * This method initializes exitButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getExitButton() {
		if (exitButton == null) {
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));
			exitButton.setIcon(new ImageIcon(getClass().getResource(
					"/res/exitButton.jpg")));
			exitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
		}
		return exitButton;
	}
	
	/**
	 * 界面初始化方法
	 * 
	 * @return void
	 */
	private void initialize() {
		Dimension size = getToolkit().getScreenSize();
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);
		setSize(300, 198);
		this.setTitle("SXT·进销存管理系统登录");
		try {
			image = ImageIO.read(new File("image\\Login48.png"));
			this.setIconImage(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setContentPane(getLoginPanel());
	}
	
	public String getUserStr() {
		return userStr;
	}
	public static void main(String[] args) {
		new LoginDialog().setVisible(true);
	}
}

