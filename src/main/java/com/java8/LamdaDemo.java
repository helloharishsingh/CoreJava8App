package com.java8;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LamdaDemo {

	public static void main(String[] args) {
		List<String> strList=Stream.of("ABC","EFG","HIJ","KLM","NOP").collect(Collectors.toList());
		List<Number> numList=Stream.of(5,10,15,20,25,30).collect(Collectors.toList());

		// separate odd & even number
		
		numList.stream().collect(Collectors.partitioningBy(n->n.intValue()%2==0))
		.forEach((a,b)->System.out.println(a+"==="+b));
		
		//remove duplicate element from list
		List<String> strDupList=Stream.of("ABC","EFG","HIJ","KLM","ABC").collect(Collectors.toList());
		strDupList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	
		//find duplicate element from list
		HashSet<String> set=new HashSet<String>();
		strDupList.stream().filter(str->!set.add(str)).collect(Collectors.toList()).forEach(System.out::println);
		
		//sum of 1-20 numbers
		int sum=IntStream.range(1, 20).sum();
		sum=numList.stream().collect(Collectors.summingInt(num->num.intValue()));
		double average=numList.stream().collect(Collectors.averagingDouble(num->num.doubleValue()));
		double a=numList.stream().collect(Collectors.averagingDouble(num->num.doubleValue()));
		
	
	}

}
