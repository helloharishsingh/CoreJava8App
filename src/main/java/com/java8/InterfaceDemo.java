package com.java8;

public class InterfaceDemo {

	public static void main(String[] args) {
	Interface1 test=new Test();
	test.print();
	}
}

class Test implements Interface1,Interface2{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Interface1.super.print();
		Interface2.super.print();
	}
	
	
}

interface Interface1{
	default void print() {
		System.out.println("This is Interface1");
	}
}
interface Interface2{
	
	default void print() {
		System.out.println("This is Interface2");
	}
}
