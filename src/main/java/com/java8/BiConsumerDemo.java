package com.java8;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

	public static void main(String[] args) {
		
		BiConsumer<Integer, Integer> biconsumer=(a,b)->{System.out.println(a+b);};
		biconsumer.accept(10,5);
		
	}
}
