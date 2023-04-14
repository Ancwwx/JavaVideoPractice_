
package com.hspedu.reflection.class_;



import java.lang.reflect.Field;

import com.hspedu.Car;

public class Class01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException {
		String classAllPath="com.hspedu.Car";
		//获取car类对应的Class对象
		Class cls=Class.forName(classAllPath);
		//cls对象是哪一个类的对象
		System.out.println(cls);
		//cls的运行类型
		System.out.println(cls.getClass());
		//cls对应的类的包名
		System.out.println(cls.getPackage().getName());
		//cls对应的类的全类名
		System.out.println(cls.getName());
		//生成对象实例
		Car car=(Car) cls.newInstance();
		System.out.println(car);
		//通过反射获得属性(非私有属性）
		Field brand= cls.getField("brand");
		System.out.println(brand.get(car));
		//通过反射给属性赋值
		brand.set(car, "奔驰");
		System.out.println(brand.get(car));
		
		//得到所有的属性或字段
		Field[] fields= cls.getFields();
		for(Field f:fields) {
			System.out.println(f.getName());
			
		}
	}
}
		
		
		
		
		
		
	
	
