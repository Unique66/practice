package com.sxh.concurrence.section1;

/**
 * Created by SXH on 2019/3/9.
 * Atomicity原子性
 * 在32位系统中，long（8字节64位）型的数据的读写不是原子性的，多线程之间会互相干扰
 */
public class Test1 {
    public static long t = 0;
    public static class ChangeT implements Runnable{
        private long to;
        public ChangeT(long to){
            this.to = to;
        }
        @Override
        public void run() {
            while (true) {
                Test1.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable{
        @Override
        public void run() {
            while (true) {
                long tmp = Test1.t;
                if (tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L)
                    System.out.println(tmp);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
    }
}
