package com.sxt.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Timer;

import com.sxt.tools.ImagePanel;
import com.sxt.tools.Tools;
import com.sxt.view.allQuery_view.GysQuery;
import com.sxt.view.allQuery_view.KhQuery;
import com.sxt.view.allQuery_view.RkQuery;
import com.sxt.view.allQuery_view.SellQuery;
import com.sxt.view.allQuery_view.SellRank;
import com.sxt.view.allQuery_view.StockQuery;
import com.sxt.view.basicFunction_view.GYSGL;
import com.sxt.view.basicFunction_view.KHGL;
import com.sxt.view.basicFunction_view.SPGL_VIEW;
import com.sxt.view.jhgl_view.JHTH;
import com.sxt.view.jhgl_view.SPJH;
import com.sxt.view.kcgl_view.KcAlert;
import com.sxt.view.kcgl_view.KcpdDialog;
import com.sxt.view.kcgl_view.PriceUpdate;
import com.sxt.view.system_view.DataBackUp;
import com.sxt.view.system_view.RevisePwd;
import com.sxt.view.xsgl_view.SPXS;
import com.sxt.view.xsgl_view.XSTH;

/**
 * 项目主窗体类
 * 
 * */
public class UserLand extends JFrame implements ActionListener
{
	//时间状态背景图
	Image timeBg,image;;
	//菜单条
	JMenuBar jmb ;
	JLabel jl1;
	//菜单栏元素
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//菜单栏子菜单
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5,jmm6,jmm7,jmm8,jmm9,jmm10,jmm11,jmm12,jmm13,jmm14,jmm15,
	jmm16,jmmGys,jmmKh,jmmRk,jmmYj;
	//菜单栏元素图标
	ImageIcon jm1_icon1,jm1_icon2,jm2_icon1,jm2_icon2,jm3_icon1,jm3_icon2,jm4_icon1,jm4_icon2,
	jm4_icon3,jm5_icon1,jm5_icon2,jm5_icon3,jm5_icon4,jm6_icon1,jm6_icon2,jm6_icon3,main_icon,
	jm_Gys,jm_Kh,jm_Rk,jm_Yj;
	//工具栏
	JToolBar jtb;
	//工具栏按钮
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//主界面的子JPanel
	JPanel p1,p2,p3,p4,p5;
	//显示当前时间的label
	JLabel timeNow;
	ImagePanel ip1,p1_imaPanel;
	//javax.swing中的Timer类可以定时触发Action事件，我们可以利用它来完成时间走动
	javax.swing.Timer t;

	public static void main(String[] args) 
	{
		new UserLand();
	}
	
	//构造方法
	public UserLand()
	{
		creatUserLand();
	}
	
	/**
	 * 创建主窗体*/
	private void creatUserLand() 
	{
		//菜单Icon图标
		jm1_icon1 = new ImageIcon("image\\huodan32.png");
		jm1_icon2 = new ImageIcon("image\\tuihuo32.png");
		jm2_icon1 = new ImageIcon("image\\sale32.png");
		jm2_icon2 = new ImageIcon("image\\xsth32.png");
		jm3_icon1 = new ImageIcon("image\\kcpd32.png");
		jm3_icon2 = new ImageIcon("image\\jgtz32.png");
		jm4_icon1 = new ImageIcon("image\\xscx32.png");
		jm4_icon2 = new ImageIcon("image\\spcx32.png");
		jm4_icon3 = new ImageIcon("image\\xsph32.png");
		jm5_icon1 = new ImageIcon("image\\spgl32.png");
		jm5_icon2 = new ImageIcon("image\\khgl32.png");
		jm5_icon3 = new ImageIcon("image\\gys32.png");
		jm5_icon4 = new ImageIcon("image\\jsr32.png");
		jm6_icon1 = new ImageIcon("image\\sjbf32.png");
		jm6_icon2 = new ImageIcon("image\\pwdxg32.png");
		jm6_icon3 = new ImageIcon("image\\exit32.png");
		jm_Gys = new ImageIcon("image\\gysQuery.png");
		jm_Kh  = new ImageIcon("image\\KhQuery.png");
		jm_Rk  = new ImageIcon("image\\RkQuery.png");
		jm_Yj  = new ImageIcon("image\\warning32.png");
		
		//菜单栏
		jmb = new JMenuBar();
		
		jm1 = new JMenu("进货管理");
		jm1.setFont(Tools.f1);
		jmm1 = new JMenuItem("进货单",jm1_icon1);
		jmm2 = new JMenuItem("进货退货",jm1_icon2);
		//触发进货单事件
		jmm1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPJH jhd =new SPJH();
			}
		});
		//触发进货退货事件
		jmm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHTH jhth = new JHTH();
			}
		});
		
		jm1.add(jmm1);
		jm1.add(jmm2);
		
		jm2 = new JMenu("销售管理");
		jm2.setFont(Tools.f1);
		jmm3 = new JMenuItem("销售单",jm2_icon1);
		jmm4 = new JMenuItem("销售退货",jm2_icon2);
		//触发销售事件
		jmm3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPXS spxs = new SPXS();
			}
		});
		//触发销售退货事件
		jmm4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XSTH xsth = new XSTH();
			}
		});
		jm2.add(jmm3);
		jm2.add(jmm4);
		
		jm3 = new JMenu("库存管理");
		jm3.setFont(Tools.f1);
		//触发库存盘点事件
		jmm5 = new JMenuItem("库存盘点",jm3_icon1);
		jmm5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KcpdDialog kcpddialog = new KcpdDialog(UserLand.this,true);
			}
		});
		//触发价格调整事件
		jmm6 = new JMenuItem("价格调整",jm3_icon2);
		jmm6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PriceUpdate priceUpdate = new PriceUpdate(UserLand.this,true);
			}
		});
		//触发库存预警事件
		jmmYj = new JMenuItem("库存预警",jm_Yj);
		jmmYj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KcAlert kcAlert= new KcAlert(UserLand.this,true);
			}
		});
		jm3.add(jmm5);
		jm3.add(jmm6);
		jm3.add(jmmYj);
		
		jm4 = new JMenu("信息查询");
		jm4.setFont(Tools.f1);
		//触发销售查询事件
		jmm7 = new JMenuItem("销售查询",jm4_icon1);
		jmm7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellQuery sellQuery = new SellQuery();
			}
		});
		//触发商品查询事件
		jmm8 = new JMenuItem("商品查询",jm4_icon2);
		jmm8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockQuery sellQuery = new StockQuery();
			}
		});
		//触发销售排行事件
		jmm9 = new JMenuItem("销售排行",jm4_icon3);
		jmm9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellRank sellQuery = new SellRank();
			}
		});
		//触发供应查询事件
		jmmGys = new JMenuItem("供应商查询",jm_Gys);
		jmmGys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GysQuery sellQuery = new GysQuery();
			}
		});
		//触发客户查询事件
		jmmKh = new JMenuItem("客户查询",jm_Kh);
		jmmKh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhQuery sellQuery = new KhQuery();
			}
		});
		//触发入库查询事件
		jmmRk = new JMenuItem("入库查询",jm_Rk);
		jmmRk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RkQuery sellQuery = new RkQuery();
			}
		});
		jm4.add(jmmRk);
		jm4.add(jmm7);
		jm4.add(jmm8);
		jm4.add(jmmGys);
		jm4.add(jmmKh);
		jm4.add(jmm9);
		
		jm5 = new JMenu("基本资料");
		jm5.setFont(Tools.f1);
		//触发商品管理事件
		jmm10 = new JMenuItem("商品管理",jm5_icon1);
		jmm10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SPGL_VIEW spgl = new SPGL_VIEW();
			}
		});
		//触发客户管理
		jmm11 = new JMenuItem("客户管理",jm5_icon2);
		jmm11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KHGL khgl = new KHGL();
			}
		});
		//触发供应商管理
		jmm12 = new JMenuItem("供应商管理",jm5_icon3);
		jmm12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GYSGL gysgl = new GYSGL();
			}
		});
	
		jm5.add(jmm10);
		jm5.add(jmm11);
		jm5.add(jmm12);

		//系统维护菜单
		jm6 = new JMenu("系统维护");
		jm6.setFont(Tools.f1);
		//触发数据库备份与恢复事件
		jmm14 = new JMenuItem("数据备份与恢复",jm6_icon1);
		jmm14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBackUp dbu = new DataBackUp();
			}
		});
		//触发密码修改事件
		jmm15 = new JMenuItem("密码修改",jm6_icon2);
		jmm15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RevisePwd revPwd = new RevisePwd();
			}
		});
		//触发退出系统事件
		jmm16 = new JMenuItem("退出系统",jm6_icon3);
		jmm16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jm6.add(jmm14);
		jm6.add(jmm15);
		jm6.add(jmm16);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		this.setJMenuBar(jmb);
		
		//处理工具栏组件
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton("进货单",jm1_icon1);
		jb1.setToolTipText("进货单");
		jb1.setFont(Tools.f2);
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SPJH jhd =new SPJH();
			}
		});
		jb2 = new JButton("销售单",jm2_icon1);
		jb2.setFont(Tools.f2);
		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SPXS spxs = new SPXS();
			}
		});
		jb3 = new JButton("库存盘点",jm3_icon1);
		jb3.setFont(Tools.f2);
		jb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KcpdDialog kcpddialog = new KcpdDialog(UserLand.this,true);
			}
		});
		jb4 = new JButton("价格调整",jm3_icon2);
		jb4.setFont(Tools.f2);
		jb4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PriceUpdate priceUpdate = new PriceUpdate(UserLand.this,true);
			}
		});
		jb5 = new JButton("商品管理",jm5_icon1);
		jb5.setFont(Tools.f2);
		jb5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SPGL_VIEW spgl = new SPGL_VIEW();
			}
		});
		jb6 = new JButton("客户管理",jm5_icon2);
		jb6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KHGL khgl = new KHGL();
			}
		});
		jb6.setFont(Tools.f2);
		jb7 = new JButton("供应商管理",jm5_icon3);
		jb7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GYSGL khgl = new GYSGL();
			}
		});
		jb7.setFont(Tools.f2);
		/*jb8 = new JButton("经手人设置",jm5_icon4);
		jb8.setFont(Tools.f2);*/
		jb9 = new JButton("密码修改",jm6_icon2);
		jb9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RevisePwd revPwd = new RevisePwd();
			}
		});
		jb9.setFont(Tools.f2);
		jb10 = new JButton("退出系统",jm6_icon3);
		jb10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.exit(0);
			}
		});
		jb10.setFont(Tools.f2);
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		/*jtb.add(jb8);*/
		jtb.add(jb9);
		jtb.add(jb10);
		
		//处理P1面板
		p1 = new JPanel(new BorderLayout());
		Image p1_bg=null;
		try {
			p1_bg = ImageIO.read(new File("image\\p1_bg2.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.p1_imaPanel = new ImagePanel(p1_bg);
		this.p1_imaPanel.setLayout(new BorderLayout());
		jl1 = new JLabel(new ImageIcon("image\\05.gif"));
		this.p1_imaPanel.add(jl1,"West");
		p1.add(this.p1_imaPanel);
		
		//处理P5面板	
		p5 = new JPanel(new BorderLayout());
		t = new Timer(1000,this); //每一秒触发一次 
		t.start();//启动该定时器 
		timeNow = new JLabel(Calendar.getInstance().getTime().toLocaleString());
		timeNow.setFont(Tools.f1);
		try {
			timeBg = ImageIO.read(new File("image\\zhuangtai1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip1 = new ImagePanel(timeBg);
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,"East");
		p5.add(ip1);
		//Container容器用于	
		Container ct = this.getContentPane();
		ct.add(jtb,"North");
		ct.add(p5,"South");
		ct.add(p1,"Center");
		int width  = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height-35);
		this.setVisible(true);
		this.setTitle("SXT·企业进销存管理系统");
		
		try {
			image = ImageIO.read(new File("image\\main72.png"));
			this.setIconImage(image);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.timeNow.setText("Welcome to S X T·企 业 进 销 存 管 理 系 统                                                           "
		+"当前时间："+Calendar.getInstance().getTime().toLocaleString()+"  ");
	}
}
