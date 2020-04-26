package com.sxh.net.socket;/**
 * Created by SXH on 2020/1/5 16:40.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author SXH
 * @description TCP方式的socketclient
 * @date 2020/1/5 16:40.
 */
public class TCPSocketClient {
	/*
	  客户端：
	  	1.建立socket服务，指定连接的主机和端口。
	  	2.获取socket的输出流，将请求数据写入其中。通过网络发给服务端
	  	3.获取socket的输入流，将服务端反馈的数据拿到并打印。
	  	4.关闭客户端资源
	 **/
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.109", 1000);
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("tcpClient".getBytes());
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int read = inputStream.read(bytes);
			System.out.println("server return clientContent length:" + new String(bytes,0,read));
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
