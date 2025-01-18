package com.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String[] str) {
		
		// Flattening of List of list
		List<List<Integer>> listOfLists = Arrays.asList(
				  Arrays.asList(1, 2, 3),
				  Arrays.asList(4, 5),
				  Arrays.asList(6, 7, 8)
				);

			Stream<Integer> integerStream = listOfLists.stream() .flatMap(Collection::stream);
			integerStream.forEach(System.out::println);
		
		List<Integer> numList=Arrays.asList(5,10,15,20,25,30);
		
		// Calculate sum of integers
		Integer sum=numList.stream().reduce((a,b)->a+b).get();
		System.out.println("Total sum is = "+sum);
		
		// Calculate average of integers
		Double average=numList.stream().collect(Collectors.averagingDouble(a->a.intValue()));
		Double average1=numList.stream().mapToInt(a->a).average().getAsDouble();
		System.out.println("Average of all is = "+average);
		
		// Calculate square of integers
		Map<Integer, Integer> map=numList.stream().collect(Collectors.toMap(a -> a,a -> a*a));
		System.out.println("square of all is = "+map);
		map.forEach((k,v) -> {
		    System.out.println("The square value of "+k + " is " + v + ".");
		});

		// Odd and Even number filtering from list
		
		List<Integer> oddList=numList.stream().filter(num->num%2!=0).toList();
		List<Integer> evenList=numList.stream().filter(num->num%2==0).toList();
		
		Map<Boolean,List<Integer>> evenOddmap=numList.stream()
				.collect(Collectors.partitioningBy(a->a%2==0));
		oddList.forEach(a->System.out.println(a));
		evenList.forEach(a->System.out.println(a));
		
		// select number which are starting from 2
		List<Integer> numbersStaringWithTwo=numList.stream().map(num->String.valueOf(num))
				.filter(numStr->numStr.startsWith("2")).map(numStr->Integer.parseInt(numStr))
				.collect(Collectors.toList());
		numbersStaringWithTwo.forEach(a->System.out.println("numbersStaringWithTwo = "+a));
		
		// select duplicate number from List
		//Collections.frequency(evenList, numbersStaringWithTwo)
		List<Integer> numberList=Arrays.asList(5,10,15,20,25,30,5);
				Set<Integer> duplicate=numberList.stream()
						.filter(num->Collections.frequency(numberList, num)>1).collect(Collectors.toSet());
				duplicate.forEach(a->System.out.println("duplicate = "+a));	
				
				Set<Integer> dup=new HashSet<Integer>() ;
				List<Integer> list=numberList.stream().filter(e->!dup.add(e))
						.collect(Collectors.toList());
				list.forEach(a->System.out.println("duplicate = "+a));	
		// select max number from List
				System.out.println("Min number="+numList.stream().sorted().findFirst().get());
				System.out.println("Max number="+numList.stream().sorted(Comparator.reverseOrder()).findFirst().get());
		// 3 nd nth large number from List
				System.out.println("3rd largest number="+numList.stream().sorted(Comparator.reverseOrder()).
						limit(3).skip(2).findFirst().get());
						
		
	}
	
}
