package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 9번
 */
public class ExQ9 {
	
	static int sumof (int a, int b) {
		int sum = 0 ;
		
		int start = 0;
		int end = 0;
		
		if (a <= b) {
			start = a;
			end = b;
		} else {
			start = b;
			end = a;
		}
		
		for (int i = start; i <= end; i++) {
			sum = sum + i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("a : ");
		int a = scanner.nextInt();
		System.out.print("b : ");
		int b = scanner.nextInt();
		
		System.out.println("sumof(" + a + ", " + b + ") : " + sumof(a, b));
	}
}
  