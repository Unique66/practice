package com.sxh.jvm.gc;/**
 * Created by SXH on 2019/7/27 23:48.
 */

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author SXH
 * @description
 * @date 2019/7/27 23:48.
 */
public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> ref = null;
        while ((ref = (Reference<NormalObject>) rq.poll()) != null) {
            System.out.println("In queue: " +  ((NormalObjectWeakReference)(ref)).name);
            System.out.println("reference object: " + ref.get());
        }
    }

    public static void main(String[] args) {
        ArrayList<WeakReference<NormalObject>> weakList = new ArrayList<WeakReference<NormalObject>>();
        for (int i = 0; i < 3; i++) {
            weakList.add(new NormalObjectWeakReference(new NormalObject("weak" + i), rq));
            System.out.println("Created weak: " + weakList.get(i));
        }
        System.out.println("first time");
        checkQueue();
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("second time");
        checkQueue();
    }
}
