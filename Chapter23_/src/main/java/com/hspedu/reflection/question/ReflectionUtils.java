package com.hspedu.reflection.question;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionUtils {
	public static void main(String[] args) {

	}

	@Test
	public void api_02() throws ClassNotFoundException {
//		getModifiers: 以int形式返回修饰符
//		[说明：默认修饰符 是0, public 是1,private 是2, protected是4, static是 8 
//		 final 是16 , public(1) + static (8) = 9
		Class<?> personCls = Class.forName("com.hspedu.reflection.question.Person");
		Field[] declaredFields = personCls.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			System.out.println("本类所有的属性=" + declaredField.getName() + " 该属性的修饰符值=" + declaredField.getModifiers()
					+ " 该属性的类型=" + declaredField.getType());
		}
		Method[] declaredMethods = personCls.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println("本类中所有方法=" + declaredMethod.getName() + "　该方法的访问修饰符值=" + declaredMethod.getModifiers()
					+ " 该方法返回类型=" + declaredMethod.getReturnType());
			Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("该方法的形参类型=" + parameterType);
			}
		}
		Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			System.out.println("本类所有的构造器= " + declaredConstructor.getName());
			Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("该构造器的形参类型=" + parameterType);
			}
			System.out.println("=================");
		}

	}

	// @Test
	public void api_01() throws ClassNotFoundException {
		Class<?> personCls = Class.forName("com.hspedu.reflection.question.Person");

//		1. getName:荻取全类名
		System.out.println(personCls.getName());
//		2. getSimpleName:获取简单类名
		System.out.println(personCls.getSimpleName());
//		3. getFields:获取所有public修飾的属性，包含本类以及父类的
		Field[] fields = personCls.getFields();
		for (Field field : fields) {
			System.out.println("本类及父类的属性= " + field.getName());
		}

//		4. getDeclaredFields:获取本类中所有属性
		Field[] declaredFields = personCls.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			System.out.println("本类所有的属性= " + declaredField.getName());
		}
//		5. GeeMethods 获取所有public修饰的方法 包含本类以及父类的
		Method[] methods = personCls.getMethods();
		for (Method method : methods) {
			System.out.println("本类及父类的方法= " + method.getName());
		}
//		6. getDeclaredMethods:获取本类中所有方法
		Method[] declaredMethods = personCls.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println("本类中所有方法= " + declaredMethod.getName());
		}
//		7. getConstructors：获取所有本类public修饰的构造器
		Constructor<?>[] constructors = personCls.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("本类所有public的构造器= " + constructor.getName());
		}
//		8. getDeclaredConstructors:获取本类中所有构造器
		Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			System.out.println("本类所有的构造器= " + declaredConstructor.getName());
		}

//		9. getPackage:Package形式返回包信息
		System.out.println(personCls.getPackage());
//		10.getSuperClass:以Class形式返回父类信息
		Class<?> superclass = personCls.getSuperclass();
		System.out.println("父类的class对象= " + superclass);
//		11.getInterfaces:以Class形式返回接口信息
		Class<?>[] interfaces = personCls.getInterfaces();
		for (Class<?> anInterface : interfaces) {
			System.out.println("接口信息= " + anInterface);
		}
//		12.getAnnotations:Annotation[] 形式返回注解信息
		Annotation[] annotations = personCls.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("注解信息= " + annotation);
		}
	}

}

class A {
	public String hobby;

	public A() {

	}

	public void hi() {

	}
}

interface IA {

}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
	public String name;
	protected int age;
	private double sal;
	String job;

	public Person() {

	}

	public Person(String name) {

	}

	private Person(String name, int age) {

	}

	public void m1(String name, int age, double sal) {

	}

	protected String m2() {
		return null;
	}

	void m3() {

	}

	private void m4() {

	}
}
