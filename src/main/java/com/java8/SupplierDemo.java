package com.java8;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

class MySupplier implements BooleanSupplier {
	public void accept(Integer t) {
		System.out.println(t);
	}

	@Override
	public boolean getAsBoolean() {
		// TODO Auto-generated method stub
		return false;
	}
}
public class SupplierDemo {

	public static void main(String[] args) {
		 Supplier<Double> randomValue = () -> Math.random(); 
		 
		  
	        // Print the random value using get() 
	        System.out.println(randomValue.get()); 

	}

}
