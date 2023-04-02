package com.hspedu.method;

public class ThreadMethod03 {
	public static void main(String[] args) throws InterruptedException {
		MyDaemonThread myDaemonThread = new MyDaemonThread();
		myDaemonThread.setDaemon(true);
		myDaemonThread.start();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("BQ在辛苦的工作...");
			Thread.sleep(1000);
		}
	}

}

class MyDaemonThread extends Thread {
	public void run() {
		for (;;) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("MR和SZ快乐聊天,hahaha");
		}
	}
}