package com.sxh.io;/**
 * Created by SXH on 2019/7/14 22:04.
 */


import javax.sound.midi.Soundbank;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author SXH
 * @description
 * @date 2019/7/14 22:04.
 */
public class NonBlockingSocketClient {
    private static final java.lang.String STR = "Hello World!";
    private static final java.lang.String REMOTE_IP = "127.0.0.1";
    public static void main(String[] args) throws Exception{
        int port = 1234;
        if (args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(REMOTE_IP, port));
        while (!sc.finishConnect()) {
            System.out.println("同" + REMOTE_IP + "is connnecting，wait please！");
            Thread.sleep(10);
        }
        System.out.println("builded connect，will write content to ip+port！Time：" + System.currentTimeMillis());
        ByteBuffer bb = ByteBuffer.allocate(STR.length());
        bb.flip();// 写缓冲区的数据之前一定要先翻转flip
        sc.write(bb);
        bb.clear();
        sc.close();
    }
}
