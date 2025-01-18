package com.java8;

import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<String>  priQueue=new PriorityQueue<String>();
		
		priQueue.add("D");
		priQueue.add("C");
		priQueue.add("B");
		priQueue.add("A");
		
		priQueue.forEach(a->System.out.println(a));
		
HashMap<Employee, Employee> empMap=new HashMap<Employee, Employee>();

	Employee emp1=new Employee(1, "AAA", 10000.0);
	Employee emp2=new Employee(1, "AAA", 10000.0);
	empMap.put(emp1, emp1);
	//emp.setId(2);
	empMap.put(emp2, emp1);
	empMap.forEach((key,value)->System.out.println("Key="+key+" Value="+value));

	}

}

