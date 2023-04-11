package com.hspedu.qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
	
	//多个线程放入到HashMap集合，key:ID， value:线程
	 private static HashMap<String , ClientConnectServerThread> hm=new HashMap<>();
	 
	 //某个线程加入集合中
	 public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread) {
		 hm.put(userId, clientConnectServerThread);
	 }
	 public static ClientConnectServerThread getClientConnectServerThread(String userId) {
		 return hm.get(userId);
	 }

}
