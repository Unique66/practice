package com.sxh.concurrence.section4;/**
 * Created by SXH on 2019/4/7 18:31.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SXH
 * @description 4.3.1ThreadLocal的简单实用   page148
 * @date 2019/4/7 18:31.
 */
public class ThreadLocalDemo {
//    private  static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    public static class ParseDate implements Runnable {
        int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
//                Date t = sdf.parse("2015-03-29 19:29:" + i%60);
//                System.out.println(i + ":" + t);
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = tl.get().parse("2015-03-29 19:29:" + i%60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
