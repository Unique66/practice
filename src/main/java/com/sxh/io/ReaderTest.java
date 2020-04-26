package com.sxh.io;/**
 * Created by SXH on 2019/7/8 22:20.
 */

import java.io.*;
import java.util.concurrent.Executors;

/**
 * @author SXH
 * @description
 * @date 2019/7/8 22:20.
 */
public class ReaderTest {
    public static void main(String[] args) {
        File file = new File("F:\\question\\io_practice\\reader.txt");
        try {
            Reader reader = new FileReader(file);
            char[] c0 = new char[1024];
            int i = 0;
            i = reader.read(c0);
            System.out.println(i);

            Writer writer = new FileWriter(file,true);
            String t = "\n \t hello world";
            writer.write(t);
            writer.flush();
            writer.close();

            reader = new FileReader(file);
//            char[] c0 = new char[1024];
//            int i = 0;
            i = reader.read(c0);
            System.out.println(i);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
