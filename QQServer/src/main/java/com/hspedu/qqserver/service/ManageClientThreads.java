package com.hspedu.qqserver.service;

import java.util.HashMap;

//该类用于管理和客户通信的线程
public class ManageClientThreads {
	private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

	public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
		hm.put(userId, serverConnectClientThread);
	}

	public static ServerConnectClientThread getServerConnectClientThread(String userId) {
		return hm.get(userId);
	}

}
