package com.java11;

import java.util.Scanner;

public class StringDemo {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  
		
	    System.out.println("Enter first number:");
	    double num1 = Double.parseDouble(myObj.nextLine());   
	    System.out.println("Enter second number:");
	    double num2 = Double.parseDouble(myObj.nextLine());  
	    System.out.println("Enter operation:");
	    double result=0;
	    String operationName = myObj.nextLine();  
	    if(operationName.equals("Add"))
	    	result=num1+num2;
	    if(operationName.equals("Substract"))
	    	result=num1-num2;
	    if(operationName.equals("Multiply"))
	    	result=num1*num2;
	    if(operationName.equals("Divide"))
	    	result=num1/num2;
	    
	    
	    	 System.out.println(operationName +" is="+result);

	}
}
