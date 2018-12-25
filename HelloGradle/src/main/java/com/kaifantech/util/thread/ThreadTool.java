package com.kaifantech.util.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTool {

	private static ExecutorService threadPool = Executors.newFixedThreadPool(128);// Executors.newCachedThreadPool();

	public static void sleep(int mt) {
		try {
			Thread.sleep(mt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepOneSecond() {
		sleep(1000);
	}

	public static ExecutorService getThreadPool() {
		return threadPool;
	}

	public static void run(Runnable runnable) {
		Thread thread = new Thread(runnable);
		threadPool.execute(thread);
		thread.interrupt();
	}

	public static void setName(String name) {
		Thread.currentThread().setName(name);
	}
}
