package com.sxh.io;/**
 * Created by SXH on 2019/7/14 21:54.
 */

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author SXH
 * @description
 * @date 2019/7/14 21:54.
 */
public class NonBlockingSocketServer {
    public static void main(String[] args) throws Exception{
        int port = 1234;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(port));
        System.out.println("开始等待客户端的数据！时间为：" + System.currentTimeMillis());
        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                // 如果没有请求，则等待一秒后轮询
                Thread.sleep(1000);
            } else {
                System.out.println("客户端已有数据到来，客户端IP为：" + sc.socket().getRemoteSocketAddress() + "，时间为：" + System.currentTimeMillis());
                ByteBuffer bb = ByteBuffer.allocate(100);
                sc.read(bb);
                bb.flip();
                while (bb.hasRemaining()) {
                    System.out.println((char)bb.get());
                }
                sc.close();
                System.exit(0);
            }
        }
    }
}
