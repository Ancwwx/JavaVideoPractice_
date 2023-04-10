package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//发送端B
public class Homework02SenderB {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket= new DatagramSocket(9998);
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你的问题: ");
		String question=scanner.next();
		byte[] data=question.getBytes();
		DatagramPacket packet= new DatagramPacket(data, data.length,InetAddress.getByName("192.168.3.14"),8888);
		socket.send(packet);
		
	    data= new byte[1024];
		packet= new DatagramPacket(data,data.length );
		socket.receive(packet);
		int length=packet.getLength();
		data=packet.getData();
		String string=new String(data,0,length);
		System.out.println(string);
		
		
		socket.close();
		System.out.println("B端退出");
		
	}

}
