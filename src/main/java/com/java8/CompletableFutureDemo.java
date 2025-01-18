package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

	public static void main(String[] args) {
		//CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
		cf.join();
		try {
			List<Integer> list = Arrays.asList(5, 9, 14);
			list.stream().map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)))
					.map(CompletableFuture -> CompletableFuture.thenApply(n -> n * n)).map(t -> t.join())
					.forEach(s -> System.out.println(s));
		
		
		
			CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> "Hello");
			CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(() -> "World");

			CompletableFuture<String> combinedFuture = helloFuture.thenCombine(greetingFuture,
					(m1, m2) -> m1 + " " + m2);

			System.out.println(combinedFuture.get());
			
			
			
			CompletableFuture<Integer> resultFuture
			// java.lang.ArithmeticException: / by zero
					= CompletableFuture.supplyAsync(() -> 10 / 0).exceptionally(ex -> 0);

			// 0 - returned by exceptionally block
			System.out.println(resultFuture.get());
	
	} catch (Exception e) {
		e.printStackTrace();
	}}
	private static int getNumber(int a) {
		return a * a;
	}
}
