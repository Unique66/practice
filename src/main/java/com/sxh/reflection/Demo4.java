package com.sxh.reflection;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by SXH on 2019/3/5.
 * 方法的反射：
 * 1.如何获取某个方法
 *   方法的名称和方法参数列表唯一决定某个方法
 * 2.方法反射操作
 *  method.invoke(对象,参数列表)
 */
public class Demo4 {
    public static void main(String[] args) {
        A a = new A();
        Class c = a.getClass();
        try {
            Method m = c.getDeclaredMethod("print", int.class, int.class);
            //方法的反射操作,使用m对象进行调用
            m.invoke(a,new Object[]{3,4});

            Method m1 = c.getDeclaredMethod("print");
            m1.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class A{

    public  void  print(){
        System.out.println("无参数");
    }
    public void  print(int a,int b){
        System.out.println(a+b);
    }
    public void  print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }
}
