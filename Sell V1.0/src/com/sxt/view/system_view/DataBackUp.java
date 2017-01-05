package com.sxt.view.system_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.sxt.dao.factory.DaoFactory;

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class DataBackUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DataBackUp dialog = new DataBackUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 *新建一个数据备份与恢复的dialog
	 *
	 */
	public DataBackUp() {
		setTitle("数据库备份与恢复");
		setBounds(100, 100, 450, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("数据库备份");
			label.setFont(new Font("宋体", Font.BOLD, 14));
			label.setBounds(10, 10, 89, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("数据库恢复");
			label.setFont(new Font("宋体", Font.BOLD, 14));
			label.setBounds(10, 103, 89, 15);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(10, 35, 414, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		JButton btnNewButton = new JButton("浏览文件");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new一个文件选择插件
				JFileChooser dirChooser=new JFileChooser(".");
				int option = dirChooser.showSaveDialog(DataBackUp.this);
				if(option==JFileChooser.APPROVE_OPTION){
					File selFile = dirChooser.getSelectedFile();
					//将选择的文件路径显示到文本框中
					textField.setText(selFile.getAbsolutePath());
				}
			}
		});
		btnNewButton.setBounds(223, 66, 93, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("备份");
		//按键触发备份事件
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String path = textField.getText();
				File backupFile=new File(path);
				//导出dmp文件的dos命令
				String sql="exp scott/root@orcl file="+backupFile.getAbsolutePath();
				System.out.println(sql);
				//调用执行dos命令的方法
				if(expBackup(sql))
				{
					JOptionPane.showMessageDialog(DataBackUp.this, "备份成功");
				}
				else
				{
					JOptionPane.showMessageDialog(DataBackUp.this, "备份失败");
				}
			}
			}
		);
		btnNewButton_1.setBounds(331, 66, 93, 23);
		contentPanel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 130, 414, 21);
		contentPanel.add(textField_1);
		
		JButton button = new JButton("浏览文件");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser dirChooser=new JFileChooser(".");
				int option = dirChooser.showSaveDialog(DataBackUp.this);
				if(option==JFileChooser.APPROVE_OPTION){
					File selFile = dirChooser.getSelectedFile();
					textField_1.setText(selFile.getAbsolutePath());
				}
			}
		
		});
		button.setBounds(223, 161, 93, 23);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("恢复");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String path = textField_1.getText();
				File backupFile=new File(path);
				//导入数据dmp文件到数据库中
				String sql="imp scott/root@orcl file="+backupFile.getAbsolutePath();
				System.out.println(sql);
				if(expBackup(sql))
				{
					JOptionPane.showMessageDialog(DataBackUp.this, "恢复成功");
				}
				else
				{
					JOptionPane.showMessageDialog(DataBackUp.this, "恢复失败");
				}
			}
		});
		button_1.setBounds(331, 161, 93, 23);
		contentPanel.add(button_1);
		this.setVisible(true);
		this.setLocationRelativeTo(null);		
	}
	/**
	 * database export and import.
	 * ——数据库导出备份与导入
	 */
		public boolean expBackup(String sql) {
		  Runtime rt = Runtime.getRuntime();
		  Process processexp = null; 
		  try {
			  //执行dos命令
		   processexp = rt.exec(sql);
		   return true;
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  return false;
		 }
	
}
