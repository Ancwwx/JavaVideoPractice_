package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//发送端B
public class UDPSenderB {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket= new DatagramSocket(9998);
		byte[] data="hello 明天吃火锅".getBytes();
		DatagramPacket packet= new DatagramPacket(data, data.length,InetAddress.getByName("192.168.3.14"),9999);
		socket.send(packet);
		
		byte[] data2= new byte[1024];
		DatagramPacket datagramPacket= new DatagramPacket(data2,data.length );
		socket.receive(datagramPacket);
		int length=datagramPacket.getLength();
		byte[] byte2=datagramPacket.getData();
		String string=new String(byte2,0,length);
		System.out.println(string);
		
		
		socket.close();
		System.out.println("B端退出");
		
	}

}
