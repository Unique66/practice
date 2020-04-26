package com.sxh.juc.cyclicbarrier;/**
 * Created by SXH on 2020/1/2 19:21.
 */

import com.sxh.juc.countdownlatch.CountDownLatchDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author SXH
 * @description 栅栏：阻塞当前线程，等待其他线程
 * @date 2020/1/2 19:21.
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) throws InterruptedException{
		new CyclicBarrierDemo().go();
	}

	private void go() throws InterruptedException{
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		// 一次创建三个线程，并启动
		new Thread(new CyclicBarrierDemo.Task(cyclicBarrier), "Thread1").start();
		Thread.sleep(1000);
		new Thread(new CyclicBarrierDemo.Task(cyclicBarrier), "Thread2").start();
		Thread.sleep(1000);
		new Thread(new CyclicBarrierDemo.Task(cyclicBarrier), "Thread3").start();
	}
	class Task implements Runnable {
		private CyclicBarrier cyclicBarrier;
		public Task (CyclicBarrier cyclicBarrier){
			this.cyclicBarrier = cyclicBarrier;
		}
		@Override
		public void run() {
			System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());
		}
	}
}
