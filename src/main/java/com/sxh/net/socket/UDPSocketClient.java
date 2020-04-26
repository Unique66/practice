package com.sxh.net.socket;/**
 * Created by SXH on 2020/1/5 16:41.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author SXH
 * @description
 * @date 2020/1/5 16:41.
 */
public class UDPSocketClient {
	public static void main(String[] args) {
		try {
			//
			DatagramSocket datagramSocket = new DatagramSocket();
			byte[] bytes = "send UDP Client Content".getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 1001);
			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
