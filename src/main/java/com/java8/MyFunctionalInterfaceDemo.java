package com.java8;

public class MyFunctionalInterfaceDemo {
 
	public static void main(String[] args) {
		 MyFunctionalInterface myFunction1 = () -> System.out.println("Performing action by Lambda");
	        myFunction1.performAction(); // Output: Performing custom action
	        
	        MyFunctionalInterface myFunction2 = MehtodReference::performAction;
	        		myFunction2.performAction();
	}
}

@FunctionalInterface
interface MyFunctionalInterface {
    void performAction();
}

class MehtodReference {
   public static void performAction() { 
    	System.out.println("Performing action by MehtodReference");
    }
}
