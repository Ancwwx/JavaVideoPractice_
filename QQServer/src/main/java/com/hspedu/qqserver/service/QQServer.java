package com.hspedu.qqserver.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

//服务器，监听9999，等待客户端连接，并保持通讯
public class QQServer {
	
	
	private ServerSocket ss=null;
	public QQServer() {
		
		
		try {
			System.out.println("服务端在9999端口监听...");
			ss = new ServerSocket(9999);
			
			while(true) {
				Socket socket= ss.accept();
				
				ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
				
		     	User user=(User) ois.readObject();
		     	
		      Message message=	new Message();
		      ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
		     	if(user.getUserId().equals("100")&& user.getPasswd().equals("123456")) {
		     		message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
		     		oos.writeObject(message);
		     		ServerConnectClientThread serverConnectClientThread=  new ServerConnectClientThread(socket, user.getUserId());
		     		serverConnectClientThread.start();
		     		ManageClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);
		     	}else {
		     		System.out.println("用户 ID= "+user.getUserId()+"password= "+user.getPasswd()+"登陆失败");
		     		message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
		     		oos.writeObject(message);
		     		socket.close();
		     	}
		     	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ss.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
		}
	}


			
			
