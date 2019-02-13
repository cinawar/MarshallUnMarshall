package com.ozgur.JavaSample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String arg[])
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException {

		Object ref = Class.forName("com.ozgur.JavaSample.ReflectionClass").newInstance();

		// functions should be static
		Method method = ref.getClass().getMethod("publicFunction", null);
		method.invoke(null, null);

		Method method2 = ref.getClass().getDeclaredMethod("staticPrivateFunction", null);
		method2.setAccessible(true);
		method2.invoke(null, null);

		method = ref.getClass().getDeclaredMethod("privateFunction", null);
		method.setAccessible(true);
		method.invoke(ref, null);

		method = ref.getClass().getDeclaredMethod("privateMethodwithParams", String.class);
		method.setAccessible(true);
		method.invoke(ref, "someStringParams");

	}
}
