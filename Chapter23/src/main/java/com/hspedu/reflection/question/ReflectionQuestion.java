package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({ "all" })
public class ReflectionQuestion {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//		Cat cat = new Cat();
//		cat.hi();

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter23/src/main/java/re.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String methodName = properties.get("method").toString();
		System.out.println("classfullpath= " + classfullpath);
		System.out.println("method= " + methodName);
		
		
		//反射机制解决
		Class cls= Class.forName(classfullpath);
		Object o= cls.newInstance();
		System.out.println("o的运行类型= "+o.getClass());
		Method method=cls.getMethod(methodName);
		method.invoke(o);
		

	}

}
