package com.sxt.view.xsgl_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import oracle.sql.DATE;

import com.sxt.dao.factory.DaoFactory;
import com.sxt.view.table.model.KcpdTableModel;

public class SPXS extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private static Vector<Vector> data = new Vector<Vector>();
	private String[] head = { "商品名称", "产地", "计量单位", "商品规格", "包装类型", "单价",
			"采购数量" };
	private static int count = 101;
	private String xsdh;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private Vector<Vector> msg = new Vector<Vector>();
	private int allNum = 0;// 销售单里商品的总数量
	private int allMoney = 0;// 销售单里总金额

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SPXS dialog = new SPXS();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SPXS() {
		setTitle("商品销售单");
		getContentPane().setFont(new Font("楷体", Font.PLAIN, 16));
		setBounds(100, 100, 809, 483);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 725, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(25, 28, 54, 15);
		contentPanel.add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("销 售 编 号：");
		lblNewLabel_1.setBounds(23, 23, 104, 24);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("结 算 方 式：");
		label.setBounds(23, 68, 104, 24);
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(133, 23, 137, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "刷卡", "现金" }));
		comboBox.setBounds(133, 68, 137, 24);
		getContentPane().add(comboBox);

		JLabel label_1 = new JLabel("客    户：");
		label_1.setBounds(292, 23, 80, 24);
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label_1);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(382, 23, 187, 24);
		getContentPane().add(comboBox_1);

		JLabel label_2 = new JLabel("销售时间：");
		label_2.setBounds(292, 68, 80, 24);
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(382, 68, 187, 24);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);

		JLabel label_3 = new JLabel("联 系 人：");
		label_3.setBounds(587, 23, 80, 24);
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("经 手 人：");
		label_4.setBounds(587, 68, 80, 24);
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label_4);

		textField_2 = new JTextField();
		textField_2.setBounds(674, 25, 109, 24);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(674, 68, 109, 24);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 116, 760, 235);
		getContentPane().add(scrollPane);

		final KcpdTableModel kcpdmd = new KcpdTableModel(head);
		table = new JTable(kcpdmd);
		scrollPane.setViewportView(table);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 361, 137, 24);
		getContentPane().add(textField_4);

		JLabel label_5 = new JLabel("品 种 数 量：");
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		label_5.setBounds(23, 361, 104, 24);
		getContentPane().add(label_5);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(133, 398, 137, 24);
		getContentPane().add(textField_5);

		JLabel label_6 = new JLabel("验 收 结 论：");
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		label_6.setBounds(23, 398, 104, 24);
		getContentPane().add(label_6);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(402, 361, 137, 24);
		getContentPane().add(textField_6);

		JLabel label_7 = new JLabel("货 品 总 数：");
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		label_7.setBounds(292, 361, 104, 24);
		getContentPane().add(label_7);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(402, 398, 137, 24);
		getContentPane().add(textField_7);

		JLabel label_8 = new JLabel("操 作 人 员：");
		label_8.setFont(new Font("楷体", Font.PLAIN, 16));
		label_8.setBounds(292, 398, 104, 24);
		getContentPane().add(label_8);

		JLabel label_9 = new JLabel("总 金 额：");
		label_9.setFont(new Font("楷体", Font.PLAIN, 16));
		label_9.setBounds(567, 361, 80, 24);
		getContentPane().add(label_9);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(654, 361, 109, 24);
		getContentPane().add(textField_8);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				// 客户选择
				long newId = DaoFactory.getSellDao().query(
						"select max(SM_id) from SELL_main");
				newId = newId + 1;
				textField.setText(newId + "");

				msg = DaoFactory.getSellDao().khSearch();
				Vector<String> khName = new Vector<String>();// 存放客户名称
				for (int i = 0; i < msg.size(); i++) {
					khName.add(msg.get(i).get(1).toString());
				}
				DefaultComboBoxModel<String> comboxmodel = new DefaultComboBoxModel<String>(
						khName);
				comboBox_1.setModel(comboxmodel);

				SimpleDateFormat dateformat = new SimpleDateFormat("yyy-MM-dd");
			
				textField.setEditable(false);
				SimpleDateFormat dateformat1 = new SimpleDateFormat(
						"yyyy年MM月dd日");
				textField_1.setText(dateformat1.format(new Date()));
				textField_1.setEditable(false);

			}

		});

		// 添加销售商品
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellAdd spdialog = new SellAdd();
				if (!spdialog.isVisible()) {
					Vector getdata = spdialog.getvector();
					for (int i = 0; i < data.size(); i++) {
						if (data.get(i).contains(getdata.get(0))) {
							data.remove(i);
						}
					}
					data.add(getdata);
					kcpdmd.setdata(data);
					table.setModel(kcpdmd);
					repaint();

					for (int j = 0; j < data.size(); j++) {
						Vector rowdata = data.get(j);
						int rowmoney = Integer.parseInt(rowdata.get(5)
								.toString())
								* Integer.parseInt(rowdata.get(6).toString());
						allMoney += rowmoney;
						allNum += Integer.parseInt(rowdata.get(5).toString());
					}
					int a = data.size();
					textField_4.setText(a + "");
					textField_4.setEditable(false);
					textField_6.setText(allNum + "");
					textField_6.setEditable(false);
					textField_8.setText(allMoney + "");
					textField_8.setEditable(false);
				}
			}
		});

		btnNewButton.setBounds(567, 398, 80, 23);
		getContentPane().add(btnNewButton);
		// 销售按钮
		JButton button = new JButton("销售");
		// 销售事件
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// count++;
				String KH_ID = null;
				for (int i = 0; i < msg.size(); i++) {
					if (comboBox_1.getSelectedItem().equals(msg.get(i).get(1))) {
						KH_ID = msg.get(i).get(0).toString();
					}
				}
				String SM_ID = textField.getText();
				String SM_PZS = data.size() + "";
				String SM_JE = allMoney + "";
				String SM_YSJL = textField_5.getText();
				java.sql.Date SM_DATE = new java.sql.Date(new java.util.Date().getTime());
				String SM_CZY = textField_7.getText();
				String SM_JSR = textField_3.getText();
				String SM_JSFS = comboBox.getSelectedItem().toString();
				Vector vector = new Vector<>();
				vector.add(SM_ID);
				vector.add(KH_ID);
				vector.add(SM_PZS);
				vector.add(SM_JE);
				vector.add(SM_YSJL);
				vector.add(SM_DATE);
				vector.add(SM_CZY);
				vector.add(SM_JSR);
				vector.add(SM_JSFS);

				Boolean bool1 = DaoFactory.getSpDao().addXSD(vector);
				if (bool1) {
					JOptionPane.showMessageDialog(SPXS.this, "成功生成销售单,点击确定退出");
					count++;
				}

				Vector<Vector> kcVector = DaoFactory.getKcDao().goodsInquiry();
				for (int i = 0; i < data.size(); i++) {
					String name = data.get(i).get(0).toString();
					String num = data.get(i).get(6).toString();

					for (int j = 0; j < kcVector.size(); j++) {
						if (kcVector.get(j).contains(name)) {
							int sd = DaoFactory.getSellDao().sdQuery(
									"select max(sd_id) from sell_detail");
							sd += 1;
							String SD_ID = sd + "";
							String KC_ID = kcVector.get(j).get(0).toString();
							String SM_DJ = kcVector.get(j).get(6).toString();
							String SM_ID1 = SM_ID;
							String SM_SL = data.get(i).get(6).toString();
							/*System.out.println(SD_ID+KC_ID+SM_DJ+SM_ID1+SM_SL);*/
							Boolean bool = DaoFactory.getSellDao().addXSXD(
									SD_ID, KC_ID, SM_DJ, SM_ID1, SM_SL);

							int a = Integer.parseInt(kcVector.get(i).get(7)
									.toString());
							int b = Integer.parseInt(num);
							num = (a - b) + "";
						}
					}
					int c = DaoFactory.getKcDao().goodsNumUpdate(num, name);

					if (c > 0) {

					} else {
						JOptionPane.showMessageDialog(SPXS.this, "数据更新出错");
						break;
					}
				}

			}
		});
		button.setBounds(683, 398, 80, 23);
		getContentPane().add(button);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
