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
import javax.swing.table.DefaultTableModel;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.tools.Tools;
import com.sxt.view.table.model.TableModel;

public class SPGL_VIEW extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static JTable table;
	static JTextField textField_1;
	private DefaultTableModel dftm;
	private JScrollPane scrollPane;
	static Vector updateVector;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SPGL_VIEW dialog = new SPGL_VIEW();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 *新建一个窗口管理界面
	 */
	public SPGL_VIEW() {
		setTitle("商品管理");
		setBounds(100, 100, 939, 534);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("增加商品");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Sp_add();
				}
			});
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
			btnNewButton.setBounds(66, 25, 93, 24);
			contentPanel.add(btnNewButton);
		}
		{
			JButton button = new JButton("修改商品");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table.setRowSelectionAllowed(true);
					//通过选中的table行获取到数据
					Vector updateVector = new Vector();
					//将数据存入到vector当中
					for(int i = 0;i<table.getColumnCount();i++)
					{
						updateVector.add(table.getValueAt(table.getSelectedRow(),i));
					}
					new Sp_update(updateVector);
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 13));
			button.setBounds(209, 25, 93, 24);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("删除商品");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//获取当前选中行的行数
					int rowNum = table.getSelectedRow();
					//获取到选中行的id
					String spSelected_id = table.getValueAt(rowNum,0).toString();
					//获取到id对应的库存表中的数量
					int num = DaoFactory.getSellDao().getNum(spSelected_id);
					//判断是否大于0
					if(num==0){
						//如果==0则表示库存无此商品，可以执行删除操作
						if(DaoFactory.getSellDao().deleteSP(spSelected_id))
						{
							JOptionPane.showMessageDialog(SPGL_VIEW.this, "删除成功!");
							String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
									"规格", "包装", "备注", "供应商名称", "批号" };
							//新建一个数据模型
							TableModel model = new TableModel(tableHeads);
							//设置数据模型
							model.setDataRows(DaoFactory.getSellDao().spSearch());
							//将数据填充到table中
							table.setModel(model);
							//自动调整table的数据宽度
							Tools.fitTableColumns(table);
							//获取商品的总数量
							textField_1.setText(Integer.toString(table.getRowCount()));
						}
						else
							//如果>0则表示库存当中商品数量>0，可以不执行删除操作
						{
							JOptionPane.showMessageDialog(SPGL_VIEW.this, "删除失败!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(SPGL_VIEW.this, "当前商品库存数大于0，删除失败!");
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
			JLabel label = new JLabel("商品总数：");
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
		/*table.setEnabled(false);*/
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	/*	dftm = (DefaultTableModel) table.getModel();*/
		String[] tableHeads = new String[] { "商品编号", "商品名称",  "产地", "单位",
				"规格", "包装", "备注", "供应商名称", "批号"  };
		TableModel model = new TableModel(tableHeads);
		model.setDataRows(DaoFactory.getSellDao().spSearch());
		table.setModel(model);
		Tools.fitTableColumns(table); //调用自动填充table方法
		scrollPane.setViewportView(table);
		textField_1.setText(Integer.toString(table.getRowCount()));
		
		JLabel label = new JLabel("Tips:请单击选中信息行进行修改、删除操作");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(609, 25, 304, 27);
		contentPanel.add(label);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
