package com.sxt.view.jhgl_view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class JHTH extends JDialog {

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
	private String[] head = { "商品名称", "产地", "计量单位", "商品规格", "包装类型", "单价",
	"退货数量" };
	private KcpdTableModel kcpd=null;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox;
	private Vector<Vector> data=null;
	private Vector<Vector> msg = new Vector<Vector>();
	private Vector<String>  jhdName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JHTH dialog = new JHTH();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JHTH() {
		setTitle("进货退货单");
		getContentPane().setFont(new Font("楷体", Font.PLAIN, 16));
		setBounds(100, 100, 809, 483);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 725, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输出");
		lblNewLabel.setBounds(25, 28, 54, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("退 货 编 号：");
		lblNewLabel_1.setBounds(23, 23, 104, 24);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("结 算 方 式：");
		label.setBounds(23, 68, 104, 24);
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"刷卡", "现金"}));
		comboBox.setBounds(133, 68, 137, 24);
		getContentPane().add(comboBox);
		
		JLabel label_1 = new JLabel("供应商：");
		label_1.setBounds(292, 23, 80, 24);
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		getContentPane().add(label_1);
		
		comboBox_1 = new JComboBox();
		Vector<Vector> khVector=DaoFactory.getSellDao().gysSearch();
		Vector<String> name=new Vector<String>();
		for (int i = 0; i < khVector.size(); i++) {
			String gysName=khVector.get(i).get(1).toString();
			name.add(gysName);
		}
		DefaultComboBoxModel dcbm=new DefaultComboBoxModel<>(name);
		comboBox_1.setBounds(382, 23, 187, 24);
		comboBox_1.setModel(dcbm);
		getContentPane().add(comboBox_1);
		
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(133, 23, 137, 24);
		Vector<Vector> xsdVe=DaoFactory.getSpDao().jhdInquiry();//获得销售单
		jhdName=new Vector<String>();
		for (int i = 0; i < xsdVe.size(); i++) {
			String jhdID=xsdVe.get(i).get(0).toString();
			jhdName.add(jhdID);
		}
		DefaultComboBoxModel decbm=new DefaultComboBoxModel(jhdName);
		comboBox_2.setModel(decbm);
		getContentPane().add(comboBox_2);
		

		
		JLabel label_2 = new JLabel("进退时间：");
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
		
		table = new JTable();
		kcpd=new KcpdTableModel(head);
		table.setModel(kcpd);
		scrollPane.setViewportView(table);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
				SimpleDateFormat dateformat1 = new SimpleDateFormat(
						"yyy年MM月dd日");
				textField_1.setText(dateformat1.format(new Date()));
			     textField_1.setEditable(false);
			}
		});
		
		comboBox_2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					for (int i = 0; i < jhdName.size(); i++) {
						if (e.getItem().toString().equals(jhdName.get(i))) {
							data = DaoFactory.getSellDao().jhxdSearch(
									jhdName.get(i));

							kcpd.setdata(data);
							table.setModel(kcpd);
							repaint();
							Float allMoney = 0f;
							int allNum = 0;
							for (int j = 0; j < data.size(); j++) {
								Vector rowdata = data.get(j);
								Float rowmoney = Integer.parseInt(rowdata.get(5)
										.toString())
										* Float.parseFloat(rowdata.get(6).toString());
								
								allMoney += rowmoney;
								
								allNum += Integer.parseInt(rowdata.get(5)
										.toString());
								
							}
							int a = data.size();
							textField_4.setText(a + "");
							textField_4.setEditable(false);
							textField_6.setText(allNum + "");
							textField_6.setEditable(false);
							textField_8.setText(allMoney + "");
							textField_8.setEditable(false);
							String gys_name=DaoFactory.getSellDao().cxGysName(jhdName.get(i));
							comboBox_1.setSelectedItem(gys_name);
						}
					}
				}
			}
		});
		
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
		//添加销售退货商品
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			                 
			}
		});
		btnNewButton.setBounds(567, 398, 80, 23);
		getContentPane().add(btnNewButton);
		//入库按钮
		JButton button = new JButton("退货");
		//入库事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().isEmpty()&&!textField_2.getText().isEmpty()&&
						!textField_3.getText().isEmpty()&&!textField_4.getText().isEmpty()&&
						!textField_5.getText().isEmpty()&&!textField_6.getText().isEmpty()&&
						!textField_7.getText().isEmpty()&&!textField_8.getText().isEmpty()){
					String RTM_ID =0+"";
					int num=DaoFactory.getSellDao().xtmQuery("select max(rtm_id) from rkth_main");
					if(num==0){
						num=1001;
					}else num+=1;
					RTM_ID=Integer.toString(num);
					String GYS_ID = null;
					msg = DaoFactory.getSellDao().gysSearch();
					for (int i = 0; i < msg.size(); i++) {
						if (comboBox_1.getSelectedItem().equals(msg.get(i).get(1))) {
							GYS_ID = msg.get(i).get(0).toString();
						}
					}
					String RTM_PZS =data.size()+"";
					String RTM_JE = null;
					String RTM_YSJL=textField_5.getText();
					int allMoney=0;
					int allNum=0;
					for (int i = 0; i < data.size(); i++) {
						Vector rowdata = data.get(i);
						Float rowmoney = Integer.parseInt(rowdata.get(5)
								.toString())
								* Float.parseFloat(rowdata.get(6).toString());
						allMoney += rowmoney;
					}
					RTM_JE=allMoney+"";
					java.sql.Date RTM_DATE = new java.sql.Date(new java.util.Date().getTime());
					String RTM_CZY = textField_7.getText();
					String RTM_JSR = textField_3.getText();
					String RTM_JSFS = comboBox.getSelectedItem().toString();
					Vector vector = new Vector<>();
					vector.add(RTM_ID);
					vector.add(GYS_ID);
					vector.add(RTM_PZS);
					vector.add(RTM_JE);
					vector.add(RTM_YSJL);
					vector.add(RTM_DATE);
					vector.add(RTM_CZY);
					vector.add(RTM_JSR);
					vector.add(RTM_JSFS);
					Vector<Vector> kcVector = DaoFactory.getKcDao().goodsInquiry();
					for (int i = 0; i < data.size(); i++) {
						String name = data.get(i).get(0).toString();
						String inputNum = data.get(i).get(6).toString();
						
						for (int j = 0; j < kcVector.size(); j++) {
							if (kcVector.get(j).contains(name)) {
								int a = Integer.parseInt(kcVector.get(i).get(7)
										.toString());
								float b = Float.parseFloat(inputNum);
								int f = (int)b;
								inputNum = (a - f) + "";
							}
						}
					int c = DaoFactory.getKcDao().goodsNumUpdate(inputNum, name);

					
					Boolean bool=DaoFactory.getSpDao().addJHTD(vector);
					Boolean bool1=DaoFactory.getSpDao().deleteJHD(comboBox_2.getSelectedItem().toString());
					Boolean bool2=DaoFactory.getSpDao().deleteJHXD(comboBox_2.getSelectedItem().toString());
					if(bool&&bool1&&bool2&&c>0){
						JOptionPane.showMessageDialog(JHTH.this, "进货退单生成成功");
					   dispose(); 
					}
				}
				
				
			}
		}});
		button.setBounds(683, 398, 80, 23);
		getContentPane().add(button);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
