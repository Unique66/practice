package com.sxh.reflection;

/**
 * Created by SXH on 2019/3/5.
 * Class类的反射
 * 方法的反射
 * 成员变量的反射
 * 构造函数的反射
 * java类加载机制
 *
 * 注：类也是对象，是java.lang.Class类的实例对象
 */
public class Demo1 {
    public static void main(String[] args) {
        Foo foo1 = new Foo();
         //Foo这个类也是一个实例对象，是Class的对象
        //任何类都是Class的实例对象，有三种表示方式
        //1. 任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;
        //2.已知该类的一个对象，通过对象getClass()获取
        Class c2 = foo1.getClass();

        /*
        官网c1.c2表示了Foo类的类类型（class Type）
        万事万物皆对象，类也是对象，是Class类的实例对象
        这个对象我们称为该类的类类型
         */

        //c1 or c2都代表了Foo类的类类型，但一个类只可能是Class类的一个实例对象，所以相等
        System.out.println(c1 == c2);

        //3.
        Class c3 = null;
        try {
            c3 = Class.forName("com.sxh.reflection.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);

        try {
            Foo foo = (Foo)c1.newInstance();
            foo.say();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo{
    public void say(){
        System.out.println("hello world!");
    }
}
