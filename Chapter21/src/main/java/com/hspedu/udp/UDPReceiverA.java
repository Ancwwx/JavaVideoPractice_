package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接收端A
public class UDPReceiverA {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket= new DatagramSocket(9999);
		byte[] buf=new byte[1024];
	    DatagramPacket packet=	new DatagramPacket(buf, buf.length);
	    System.out.println("接收端A 等待接收数据...");
	    //接收
	    socket.receive(packet);
	    //拆包
	    int length=packet.getLength();
	    byte[] data= packet.getData();
	    String s =new String(data,0,length);
	    System.out.println(s);
	    
	    byte[] data2="好的，明天见".getBytes();
	    DatagramPacket datagramPacket=new DatagramPacket(data2, data2.length,InetAddress.getByName("192.168.3.14"),9998);
	    socket.send(datagramPacket);
	    
	    
	    
	    socket.close();
	    System.out.println("A端退出");
	    
	    
		
	}

}
