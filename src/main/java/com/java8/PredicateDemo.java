package com.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyPredicate implements Predicate<Integer> {
	@Override
	public boolean test(Integer number) {
		return number.intValue() % 2 == 0;
	}
}

public class PredicateDemo {
	public static void main(String[] args) {

		List<Integer> myList = Stream.of(5, 10, 15, 20, 25, 30).collect(Collectors.toList());
		// By interface object
		MyPredicate myPredicate = new MyPredicate();
		myList.stream().filter(myPredicate).collect(Collectors.toList()).forEach(num -> System.out.println(num));

		// By Lamda expression
		myList.stream().filter((number) -> number.intValue() % 2 == 0).collect(Collectors.toList())
				.forEach(num -> System.out.println(num));
		System.out.println("Hello".substring(0,4));
		String s1 = "Hey";
		String s2 = s1.substring(0,1);
		String s3 = s2.toLowerCase();
		System.out.println(s3);

	}

}
