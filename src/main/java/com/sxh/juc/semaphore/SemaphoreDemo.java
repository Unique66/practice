package com.sxh.juc.semaphore;/**
 * Created by SXH on 2020/1/2 19:28.
 */

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author SXH
 * @description 信号量，控制某个资源可被同事访问的线程个数
 * @date 2020/1/2 19:28.
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 只能5个线程同时访问
		final Semaphore semaphore = new Semaphore(5);
		// 模拟20个客户访问
		for (int index = 0;index < 20; index++) {
			final  int NO = index;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("Accessing:" + NO);
						Thread.sleep((long) (Math.random() * 10000));
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(run);
		}
		// 退出线程池
		executorService.shutdown();
	}
}
