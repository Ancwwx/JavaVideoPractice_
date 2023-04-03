package com.hspedu.tankgame04;

import javax.swing.JFrame;

public class HspTankGame04 extends JFrame {

	MyPanel mp = null;

	public static void main(String[] args) {
		HspTankGame04 hspTankGame01 = new HspTankGame04();

	}

	public HspTankGame04() {
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
