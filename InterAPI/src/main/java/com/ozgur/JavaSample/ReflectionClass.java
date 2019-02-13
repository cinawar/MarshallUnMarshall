package com.ozgur.JavaSample;

public class ReflectionClass {

	private String name;
	
	public ReflectionClass()
	{}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private static void staticPrivateFunction()
	{
		System.out.println("I am a static private");
	}
	
	private  void privateFunction()
	{
		System.out.println("I am private");
	}
	
	public static void publicFunction()
	{
		System.out.println("I am a static public");
	}
	
	private  void privateMethodwithParams(String arg)
	{
		System.out.println("I am private with parameters :"+arg);
	}
}
