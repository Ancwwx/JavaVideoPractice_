package com.hspedu.tankgame06;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class HspTankGame06 extends JFrame {

	MyPanel mp = null;
   static  Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		
		
		HspTankGame06 hspTankGame01 = new HspTankGame06();

	}

	public HspTankGame06() {
		System.out.println("请输入选择 1: 新游戏 2: 继续上局");
		String key=scanner.next();
		mp = new MyPanel(key);
		Thread thread = new Thread(mp);
		thread.start();
		this.add(mp);// 游戏的绘图区域
		this.setSize(1300, 950);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// 在JFrame 中增加相应关闭窗口的处理
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Recorder.keepRecord();
				System.exit(0);

			}

		});

	}

}
