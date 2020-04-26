package com.sxh.reflection;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * Created by SXH on 2019/3/5.
 * 泛型的本质
 */
public class Demo5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String> ();
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);//true
    }
}
