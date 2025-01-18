package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class MyFunction implements Function<Integer, Integer> {
	@Override
	public Integer apply(Integer num) {
		return num * num;
	}
}

public class FunctionDemo {

	public static void main(String[] args) {

		List<Integer> myList = Stream.of(10, 20, 40, 30, 50).collect(Collectors.toList());
		// By Function interface
		Function<Integer, Integer> myFunc = num->num*num;
				//new MyFunction();
		myList.stream().map(myFunc).collect(Collectors.toList()).forEach((i) -> System.out.println(i));
		myList.stream().map(myFunc.andThen(num->num-10)).collect(Collectors.toList()).forEach((i) -> System.out.println(i));
		
		//Handling NullPointer
		List<String> myStringList = Stream.of("ABC", "DEF", "GHK", "IJK", "").collect(Collectors.toList());
		
		
		// By Lamda expression
		myList.stream().map((i) -> i * i).collect(Collectors.toList()).forEach((i) -> System.out.println(i));
		
		
		 List<Integer> list
         = Arrays.asList(0, 2, 4, 6, 8, 10);

     // Using peek without any terminal
     // operation does nothing
     list.stream().map(a->a*2).peek(System.out::println);
	
		
	}

}
