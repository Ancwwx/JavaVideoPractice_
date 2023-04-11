package com.hspedu.qqclient.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

//该类完成用户登录验证和用户注册等功能
public class UserClientService {

	private User u = new User();
	private Socket socket;

	public boolean checkUser(String userId, String pwd) {
		u.setUserId(userId);
		u.setPasswd(pwd);
		boolean b = false;

		try {
			socket = new Socket(InetAddress.getByName("192.168.3.14"), 9999);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(u);
			
	
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
			
			Message ms = (Message) ois.readObject();
			if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
				
				ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
				clientConnectServerThread.start();
				ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
				b = true;
			} else {
                socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
