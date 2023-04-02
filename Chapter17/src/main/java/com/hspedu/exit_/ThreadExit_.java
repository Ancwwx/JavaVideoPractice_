package com.hspedu.exit_;

public class ThreadExit_ {
	public static void main(String[] args) throws InterruptedException {
		T t1= new T();
		t1.start();
		
		System.out.println("主线程休眠十秒...");
		Thread.sleep(10*1000);
		t1.setLoop(false);

	}

}

class T extends Thread {
 private int count=0;
 private boolean loop=true;
	@Override
	public void run() {
		while (loop) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("T 运行中 "+(++count));
		}
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	

}