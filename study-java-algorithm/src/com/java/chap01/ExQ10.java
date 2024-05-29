package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 10번
 */
public class ExQ10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		
		System.out.print("a의 값 : ");
		a = scanner.nextInt();
		
		do {
			System.out.print("b의 값 : ");
			b = scanner.nextInt();
			
			if (a >= b) System.out.println("a보다 큰 값을 입력하세요!");
		} while (a >= b);
		
		System.out.println("b - a 는 " + (b-a) + "입니다.");
		
		
	}
}
 