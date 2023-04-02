package com.hspedu.threaduse;

public class Thread01 {
	public static void main(String[] args) throws InterruptedException {
		Cat cat = new Cat();
		cat.start();

		System.out.println("主线程继续执行" + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程 i=" + i);
			Thread.sleep(1000);
		}

	}

}

class Cat extends Thread {
	int times = 0;

	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true) {
			System.out.println("喵喵～" + (++times));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (times == 8) {
				break;
			}
		}
	}

}