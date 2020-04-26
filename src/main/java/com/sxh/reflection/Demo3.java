package com.sxh.reflection;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by SXH on 2019/3/5.
 * Class 方法
 */
public class Demo3 {
    public static void main(String[] args) {
        String  s = "";
        printClassMessage(s);
    }
    public static void printClassMessage(Object obj) {
        Class c = obj.getClass();//传递的是哪个子类的对象，c就表示该子类的类类型
        System.out.println(c.getName());
        /*
        getMethods()获取所有public函数，包括父类继承过来的
        getDeclaredMethods()获取自己声明的方法
         */
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length ; i++) {
            //获取方法
            Class returnType = ms[i].getReturnType(); //获取返回值类型的类类型
            System.out.print(returnType.getName() + " ");
            //获取方法名
            System.out.print(ms[i].getName()+"(");
            //获取方法参数的类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1:paramTypes) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
            System.out.println("______________________________________");
            /**
             * 成员变量也是对象
             * java.lang.reflect.Field
             * Field类封装了关于成员变量的操作
             * getFields()方法获取所有public的成员变量信息
             */
            Field [] fs = c.getDeclaredFields();
            for (Field f:fs) {
                Class fieldType = f.getType();
                String typeName = fieldType.getName();
                String fieldName = f.getName();
                System.out.println(typeName+"  "+fieldName);
            }
            System.out.println("*********************************************");
        }
    }
}
