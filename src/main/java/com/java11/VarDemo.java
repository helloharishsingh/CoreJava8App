package com.java11;

import java.util.function.BiFunction;

public class VarDemo {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> addFunc=(var a, var b)->a+b;
		System.out.println(addFunc.apply(10, 20));

	}

}
