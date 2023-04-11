package com.hspedu.qqclient.service;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.hspedu.qqcommon.Message;

public class ClientConnectServerThread extends Thread {
	private Socket socket;

	public ClientConnectServerThread(Socket socket) {
		this.socket = socket;

	}

	public Socket getSocket() {
		return socket;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("客户端线程，等待读取从服务器端发送的消息");

			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
