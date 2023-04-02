package com.hspedu.method;

public class ThreadMethodExercise {
	public static void main(String[] args) throws InterruptedException {
		T3 t3 = new T3();
		Thread thread = new Thread(t3);
		for (int i = 1; i <= 10; i++) {
			System.out.println("hi " + i);
			Thread.sleep(1000);
			if (i == 5) {

				thread.start();
				thread.join();
			}
		}
		System.out.println("主线程结束..");

	}

}

class T3 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("hello " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("子线程结束..");
	}

}