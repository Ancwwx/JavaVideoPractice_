package com.hspedu.reflection.class_;

import com.hspedu.Car;

public class GetClass_ {
	public static void main(String[] args) throws ClassNotFoundException {
		String classAllPath = "com.hspedu.Car";
		Class<?> cls1 = Class.forName(classAllPath);
		System.out.println(cls1);

		Class cls2 = Car.class;
		System.out.println(cls2);

		Car car = new Car();
		Class cls3 = car.getClass();
		System.out.println(cls3);

		// 类加载器获取类的Class对象
		// 先得到类的加载器
		ClassLoader classLoader = car.getClass().getClassLoader();
		// 通过类加载器得到class对象
		Class cls4 = classLoader.loadClass(classAllPath);
		System.out.println(cls4);
		
		
		System.out.println(cls1.hashCode());
		System.out.println(cls2.hashCode());
		System.out.println(cls3.hashCode());
		System.out.println(cls4.hashCode());
		
		Class<Integer> integerClass= int.class;
		System.out.println(integerClass);
		Class<Character> charClass= char.class;
		Class<Boolean> booleanClass= boolean.class;
		
		Class<Integer> type1= Integer.TYPE;
		System.out.println(type1);
		Class<Character> type2=Character.TYPE; //BOOLEAN, DOUBLE,LONG,BYTE等
		System.out.println(type2);
		
	
		
	}

}
