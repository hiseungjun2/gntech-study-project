package com.java.chap02;

import java.util.Scanner;

/**
 * 2장 연습문제 3번
 * 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성하세요.
 */
public class ExQ3 {
	
	static int sumOf(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = scanner.nextInt();
		
		int[] a = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = scanner.nextInt();
		}
		
		System.out.println("배열의 모든 요소 합계 : " + sumOf(a));
		
	}

}
