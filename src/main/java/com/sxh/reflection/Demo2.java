package com.sxh.reflection;

/**
 * Created by SXH on 2019/3/5.
 * 编译时刻加载类是静态加载类，运行时刻加载类是动态加载类
 */
public class Demo2 {
    public static void main(String[] args) {
        //基本数据类型的类类型
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        System.out.println(c5.getName());
    }
}
