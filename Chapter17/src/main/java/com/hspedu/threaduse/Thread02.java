package com.hspedu.threaduse;

public class Thread02 {
	public static void main(String[] args) {
		Dog dog = new Dog();

		Thread thread = new Thread(dog);
		thread.start();
		
		
//		Tiger tiger = new Tiger();
//		ThreadProxy threadProxy = new ThreadProxy(tiger);
//		threadProxy.start();

	}

}

class Animal {
}

class Tiger extends Animal implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Tiger eat~");
		
		
	}

}

class ThreadProxy implements Runnable {
	private Runnable target = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (target != null) {
			target.run();
		}

	}

	public ThreadProxy(Runnable target) {
		super();
		this.target = target;
	}

	public void start() {
		start0();
	}

	public void start0() {
		run();
	}

}

class Dog implements Runnable {
	int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("wo~" + (++count) + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (count == 10) {
				break;
			}

		}

	}

}