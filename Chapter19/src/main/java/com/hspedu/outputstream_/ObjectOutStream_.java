package com.hspedu.outputstream_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutStream_ {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath="../Resource/date.dat";
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filePath));
		
		oos.writeInt(100);
		oos.writeBoolean(true);
		oos.writeChar('a');
		oos.writeDouble(9.5);
		oos.writeUTF("北京欢迎您");
		oos.writeObject(new Dog("旺财", 10));
		
		oos.close();
		System.out.println("保存成功");
		
	}

}
