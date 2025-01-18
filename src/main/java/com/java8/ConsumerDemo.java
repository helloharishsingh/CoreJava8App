package com.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyConsumer implements Consumer<Integer> {
	public void accept(Integer t) {
		System.out.println(t);
	}
}

public class ConsumerDemo {
	public static void main(String[] args) {
		List<Integer> myList = Stream.of(10, 20, 40, 30, 50).collect(Collectors.toList());
		// By Consumer interface
		Consumer<Integer> action = new MyConsumer();
		myList.forEach(action);
		// By Lamda expression
		myList.forEach((i) -> System.out.print(i));

	}
}
