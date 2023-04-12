package com.hspedu.qqserver.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

//服务器，监听9999，等待客户端连接，并保持通讯
public class QQServer {
	
	
	private ServerSocket ss=null;
	
	//创建一个集合，存放多个用户，如果这些用户登陆，就认为是合法的
	private static ConcurrentHashMap<String, User> validUsers=new ConcurrentHashMap<>();
	static {
		validUsers.put("100",new User("100", "123456"));
		validUsers.put("200",new User("200", "123456"));
		validUsers.put("300",new User("300", "123456"));
		validUsers.put("至尊宝",new User("至尊宝", "123456"));
		validUsers.put("紫霞仙子",new User("紫霞仙子", "123456"));
		validUsers.put("菩提老祖",new User("菩提老祖", "123456"));
		
		
		
	}
	//验证用户是否有效
	private boolean checkkUser(String userId,String passwd) {
		User user=validUsers.get(userId);
		if(user == null) {
			return false;
		}
		if(!user.getPasswd().equals(passwd)) {
			return false;
		}
		return true;
	}
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
		     	if(checkkUser(user.getUserId(),user.getPasswd())) {
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


			
			
