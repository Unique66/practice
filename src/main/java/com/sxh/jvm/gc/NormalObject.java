package com.sxh.jvm.gc;/**
 * Created by SXH on 2019/7/27 23:42.
 */

/**
 * @author SXH
 * @description
 * @date 2019/7/27 23:42.
 */
public class NormalObject {
    public String name;
    public NormalObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing obj" + name);
    }
}
