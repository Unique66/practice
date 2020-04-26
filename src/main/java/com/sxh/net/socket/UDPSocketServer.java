package com.sxh.net.socket;/**
 * Created by SXH on 2020/1/5 16:40.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author SXH
 * @description
 * @date 2020/1/5 16:40.
 */
public class UDPSocketServer {

	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(1001);

			while (true) {
				// 定义一个数据包存储接收到的字节数据
				byte [] buf = new byte[1024];
				DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
				// 通过socket服务的receive方法将收到的数据存到定义好的数据包中
				datagramSocket.receive(datagramPacket);
				String ip = datagramPacket.getAddress().getHostAddress();
				String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				int port = datagramPacket.getPort();
				System.out.println(ip + data + port);
			}
//			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
