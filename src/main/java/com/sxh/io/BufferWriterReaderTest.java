package com.sxh.io;/**
 * Created by SXH on 2019/7/8 22:35.
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author SXH
 * @description
 * @date 2019/7/8 22:35.
 */
public class BufferWriterReaderTest {
    public static void main(String[] args) throws IOException{
        File file = new File("F:\\question\\io_practice\\reader.txt");
        Writer writer = new FileWriter(file);
        String t = "hello world";
        writer.write(t);
//        writer.flush();
        writer.close();
        Reader reader = new FileReader(file);
        char[] c0 = new char[1024];
        int i = 0;
        i = reader.read(c0);
        System.out.println(i);
        reader.close();

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fc = raf.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(20);
        String str = "sfewer32wfwer4";
        bb.put(str.getBytes());
        bb.flip();
        fc.write(bb);
        bb.clear();
        fc.close();


    }
}
