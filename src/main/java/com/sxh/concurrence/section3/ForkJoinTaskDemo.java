package com.sxh.concurrence.section3;/**
 * Created by SXH on 2019/4/5 18:12.
 */

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author SXH
 * @description ForkJoinPoolDemo   page 118
 * @date 2019/4/5 18:12.
 */
public class ForkJoinTaskDemo extends RecursiveTask<Long>{
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinTaskDemo (long start, long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute){
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //分治 100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinTaskDemo> subTasks = new ArrayList<ForkJoinTaskDemo>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinTaskDemo forkJoinTaskDemo = new ForkJoinTaskDemo(pos, lastOne);
                pos += step + 1;
                subTasks.add(forkJoinTaskDemo);
                forkJoinTaskDemo.fork();
            }
            for (ForkJoinTaskDemo s : subTasks) {
                sum += s.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskDemo task = new ForkJoinTaskDemo(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum=" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
