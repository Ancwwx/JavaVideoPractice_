package com.hspedu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class <PrivateTest> privateTest= PrivateTest.class;
		
		Object o= privateTest.newInstance();
		
		Field name= privateTest.getDeclaredField("name");
		name.setAccessible(true);
		name.set(o, "TLBB");
		Method getName= privateTest.getMethod("getName");
		 Object invoke =getName.invoke(o);
		System.out.println("name属性值= "+ invoke);
		
		
	}

}
class PrivateTest{
	private String name="hellokitty";
	public String getName() {
		return name;
	}
}