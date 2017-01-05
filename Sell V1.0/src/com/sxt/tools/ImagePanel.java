package com.sxt.tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

//可以动态加载一个图片做背景的JPanel
public class ImagePanel extends JPanel
{
	Image im;
	public ImagePanel(Image im)
	{
		this.im=im;
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w, h);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
