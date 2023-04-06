package com.hspedu.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class Homework03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath = "/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter19/src/main/java/Dod.properties";
		Properties properties = new Properties();
		properties.setProperty("name", "旺财");
		properties.setProperty("age", "10");
		properties.setProperty("color", "black");

		properties.store(new FileOutputStream(filePath), null);
		properties.list(System.out);
		String name = properties.getProperty("name") + "";
		int age = Integer.parseInt(properties.get("age") + "");
		String color = properties.getProperty("color") + "";
		Dog dog = new Dog(name, age, color);
		System.out.println(dog);

		String serfilePath = "../Resource/dog.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serfilePath));
		oos.writeObject(dog);
		System.out.println("dog对象序列化完成...");

	}

	@Test
	public void m1() throws FileNotFoundException, IOException, ClassNotFoundException {
		String serFilePath = "../Resource/dog.txt";
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
		Dog dog = (Dog) objectInputStream.readObject();

		System.out.println("反序列化后dog信息");
		System.out.println(dog);
		objectInputStream.close();
	}

}

class Dog implements Serializable {
	private String name;
	private int age;
	private String color;

	public Dog(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

}
