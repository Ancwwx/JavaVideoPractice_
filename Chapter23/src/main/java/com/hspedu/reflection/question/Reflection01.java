package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter23/src/main/java/re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String methodName = properties.get("method").toString();
		
		
		Class cls= Class.forName(classfullpath);
		Object o= cls.newInstance();
		System.out.println("o的运行类型= "+o.getClass());
		// 方法
		Method method=cls.getMethod(methodName);
		method.invoke(o);
		
		//对象
		Field nameFilField= cls.getField("age");
		System.out.println(nameFilField.get(o));
		
		//构造器(无参构造器)
		Constructor constructor1= cls.getConstructor();
		System.out.println(constructor1);
		
		
		//有参构造器 传入的是String类的Class对象
		Constructor constructor2= cls.getConstructor(String.class);
		System.out.println(constructor2);
		
	}

}
