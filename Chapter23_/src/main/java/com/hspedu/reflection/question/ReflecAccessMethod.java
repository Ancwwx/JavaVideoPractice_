package com.hspedu.reflection.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflecAccessMethod {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> bossCls = Class.forName("com.hspedu.reflection.question.Boss");
		Object o = bossCls.newInstance();
		Method hi = bossCls.getMethod("hi",String.class);
		hi.invoke(o, "hsp");
		Method say = bossCls.getDeclaredMethod("say",int.class,String.class,char.class);
	    say.setAccessible(true);
		
		System.out.println(say.invoke(o, 100,"hsp",'W'));
		
		System.out.println(say.invoke(null, 200,"ls",'M'));
		
		Object reVal= say.invoke(null, 300,"ww",'M');
		System.out.println(reVal);
		System.out.println(reVal.getClass());
		
	}

}

class Boss {
	public int age;
	private String name;

	public Boss() {

	}

	private static String say(int n, String s, char c) {
		return n + " " + s + " " + c;
	}

	public void hi(String s) {
		System.out.println("hi " + s);
	}
}