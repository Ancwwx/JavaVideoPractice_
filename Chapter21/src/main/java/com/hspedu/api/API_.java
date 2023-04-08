package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
	public static void main(String[] args) throws UnknownHostException {
		 InetAddress localHost= InetAddress.getLocalHost();
		 System.out.println(localHost);
		 
		 InetAddress host1= InetAddress.getByName("usernoMacBook-Pro.local");
		 System.out.println(host1);
		 
		 InetAddress host2= InetAddress.getByName("www.baidu.com");
		 System.out.println(host2);
		 
		 String hostAddress=  host2.getHostAddress();
		 System.out.println(hostAddress);
		 
		 String hostName= host2.getHostName();
		 System.out.println(hostName);
		 
	}
	

}
