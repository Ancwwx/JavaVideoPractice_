package com.hspedu.tankgame05;

import javax.swing.JFrame;

public class HspTankGame05 extends JFrame {

	MyPanel mp = null;

	public static void main(String[] args) {
		HspTankGame05 hspTankGame01 = new HspTankGame05();

	}

	public HspTankGame05() {
		mp = new MyPanel();
		Thread thread = new Thread(mp);
		thread.start();
		this.add(mp);
		this.setSize(1000, 750);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
