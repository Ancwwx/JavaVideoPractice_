package com.hspedu.qqserver.service;

import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.utils.Utility;

public class SendNewsToAllService implements Runnable {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void run() {
		// 可以多次推送

		while (true) {
			
			System.out.println("请输入服务器要推送的新闻/消息[输入exit表示退出推送服务]");
			String news = Utility.readString(100);
			
			if("exit".equals(news)) {
				break;
			}
			Message message = new Message();
			message.setSender("服务器");
			message.setContent(news);
			message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
			message.setSendTime(new Date().toString());
			System.out.println("服务器推送消息给所有人 说: " + news);
			HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
			Iterator<String> iterator = hm.keySet().iterator();
			while (iterator.hasNext()) {
				String onLineUserId = iterator.next().toString();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
					oos.writeObject(message);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

}
