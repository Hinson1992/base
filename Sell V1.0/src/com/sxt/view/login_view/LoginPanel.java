package com.sxt.view.login_view;


import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class LoginPanel extends JPanel {
	public int width, height;
	private Image img;
	public LoginPanel() {
		super();
		URL url = getClass().getResource("/res/login1.png");
		img = new ImageIcon(url).getImage();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 10, 35, this);
	}
}
