package com.test;

public class Foo implements Runnable {

	@Override
	public void run() {
		Lock();
	}

	public void Lock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		Foo b1 = new Foo();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		Foo b2 = new Foo();
		Thread t3 = new Thread(b2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}