package com.sxt.view.basicFunction_view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import com.sxt.view.table.model.TableModel;

public class Sp_update extends JDialog {

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
			Sp_update dialog = new Sp_update(SPGL_VIEW.updateVector);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 *创建商品更新窗口dialog
	 */
	public Sp_update(final Vector updateVector) {
		addWindowListener(new WindowAdapter() {
			//通过vector获取到上层界面table的数据并填充到当前界面
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(updateVector.get(0).toString());
				textField_1.setText(updateVector.get(1).toString());
				textField_2.setText(updateVector.get(2).toString());
				combobox1.setSelectedItem(updateVector.get(3).toString());
				textField_4.setText(updateVector.get(4).toString());
				combobox2.setSelectedItem(updateVector.get(5).toString());
				textField_7.setText(updateVector.get(6).toString());
				textField_6.setText(updateVector.get(7).toString());
				textField_8.setText(updateVector.get(8).toString());
			}
		});
		setTitle("修改商品");
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
			textField.setEditable(false);
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
			JButton btnNewButton = new JButton("确认修改");
			btnNewButton.addMouseListener(new MouseAdapter() {
				//修改数据到数据库当中
				@Override
				public void mouseClicked(MouseEvent e) {
					//通过数据对象模型来保存数据
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
					//将对象传入方法并判断是否更新成功
					if (UserService.spUpdate(si)) {
						JOptionPane.showMessageDialog(Sp_update.this, "修改成功!");
						String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
								"规格", "包装", "备注", "供应商全称", "批号"  };
						//创建新的数据模型
						TableModel model = new TableModel(tableHeads);
						//设置数据模型
						model.setDataRows(DaoFactory.getSellDao().spSearch());
						//将数据填充到table中
						SPGL_VIEW.table.setModel(model);
						//更新商品总数
						SPGL_VIEW.textField_1.setText(Integer.toString(SPGL_VIEW.table.getRowCount()));
						//调用自动挑中table宽度方法 
						Tools.fitTableColumns(SPGL_VIEW.table);
						Sp_update.this.setVisible(false);
						Sp_update.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Sp_update.this, "修改失败!");
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
