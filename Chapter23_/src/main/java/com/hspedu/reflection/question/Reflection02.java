package com.hspedu.reflection.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hspedu.Cat;

public class Reflection02 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		
		m1();
		m2();
		 m3();
		
	}
	public static void  m1() {
		Cat cat=new Cat();
		long start=System.currentTimeMillis();
		for(int i=0;i<90000000;i++) {
			cat.hi();
			
		}
		long end=System.currentTimeMillis();
		System.out.println("传统方法调用hi方法时间= " +(end-start));
	}
	public static void  m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException  {
	    Class cls=Class.forName("com.hspedu.Cat");
	   
	   
	    Object o=cls.newInstance();
	    Method hi= cls.getMethod("hi");
	    long start=System.currentTimeMillis();
		for(int i=0;i<90000000;i++) {
			hi.invoke(o);
			
		}
		long end=System.currentTimeMillis();
		System.out.println("反射方法调用hi方法时间= " +(end-start));
	}
	public static void  m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException  {
	    Class cls=Class.forName("com.hspedu.Cat");
	   
	   
	    Object o=cls.newInstance();
	    Method hi= cls.getMethod("hi");
	    hi.setAccessible(true);//反射调用方法时 取消访问检测 
	    long start=System.currentTimeMillis();
		for(int i=0;i<90000000;i++) {
			hi.invoke(o);
			
		}
		long end=System.currentTimeMillis();
		System.out.println("反射方法(取消访问检测)调用hi方法时间= " +(end-start));
	}
	

}
