package com.java8;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(String[] args) {
		// Simple predicate for checking equality
		BiPredicate<Integer, String> biPredicate1 = (n, s) -> {
			if (n == Integer.parseInt(s))
				return true;
			return false;
		};

		System.out.println(biPredicate1.test(2, "2"));

		// Predicate for checking greater than
		BiPredicate<Integer, String> biPredicate2 = (n, s) -> {
			if (n > Integer.parseInt(s))
				return true;
			return false;
		};

		// ANDing the two predicates
		BiPredicate<Integer, String> biPredicate3 = biPredicate1.and(biPredicate2);
		System.out.println(biPredicate3.test(2, "3"));

		// ORing the two predicates
		biPredicate3 = biPredicate1.or(biPredicate2);
		System.out.println(biPredicate2.test(3, "2"));

		// Negating the predicate
		biPredicate3 = biPredicate1.negate();
		System.out.println(biPredicate2.test(3, "2"));
	}
}