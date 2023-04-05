package com.hspedu.inputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.hspedu.outputstream_.Dog;

public class ObjectInputStream_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String filePath = "../Resource/date.dat";

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
		System.out.println(ois.readChar());
		System.out.println(ois.readDouble());
		System.out.println(ois.readUTF());
		Object dog = ois.readObject();
		System.out.println("运行类型" +dog.getClass());
		System.out.println("dog信息=" + dog);
		
		Dog dog2=(Dog)dog;
		System.out.println(dog2.getName());
		ois.close();

	}

}
