package com.ptwyj.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		A a = new A();
		a.setName("yijun");
		a.setId(1);

		Class clazz = a.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(AField.class)) {
				AField aField = field.getAnnotation(AField.class);
				String value = aField.value();
				System.out.println(value);

				if (value.equals("NEED")) {
					// 私有变量必须先设置Accessible为true
					field.setAccessible(true);
					String string = (String) field.get(a);
					System.out.println(string);
				}
			}
		}

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method.getName());

			if (method.getName().equals("toString")) {
				System.out.println(method.invoke(a));
			}
		}

		a.toString();
	}

}
