package com.sxh.net.socket;/**
 * Created by SXH on 2020/1/5 16:39.
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author SXH
 * @description Tcp方式的socketserver
 * @date 2020/1/5 16:39.
 */
public class TCPSocketServer {

	public static void main(String[] args) {
		try {
			// 建立服务端的socket服务，并监听一个端口
			ServerSocket socket = new ServerSocket(1000);
			// 使用accept方法获取连接过来的客户端对象
			Socket accept = socket.accept();
			String ip = accept.getInetAddress().getHostAddress();
			System.out.println(ip + ">>>connected");
			// 获取客户端发送过来的数据，读取
			InputStream inputStream = accept.getInputStream();
			byte [] buf = new byte[1024];
			int len = inputStream.read(buf);
			String clientContent = new String(buf, 0, len);
			System.out.println(clientContent);
			System.out.println(clientContent.length());
			// 获取客户端的输出流，将响应反馈给客户端
			OutputStream outputStream = accept.getOutputStream();
			outputStream.write(Integer.toString(clientContent.length()).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
