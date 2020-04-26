package com.sxh.classLoader;/**
 * Created by SXH on 2019/7/27 13:27.
 */

/**
 * @author SXH
 * @description
 * @date 2019/7/27 13:27.
 */
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("F:\\question\\classLoaderTest\\", "myClassLoader");
        Class c = m.findClass("Test");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();//
    }
}
