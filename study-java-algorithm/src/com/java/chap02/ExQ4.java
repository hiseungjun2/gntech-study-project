package com.java.chap02;

import java.util.Scanner;

/**
 * 2장 연습문제 4번
 * 배열 b의 모든 요소를 배열 a에 복사하는 메서드 copy를 작성하세요.
 */
public class ExQ4 {
	
	static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("배열 a의 요솟수 : ");
		int na = stdIn.nextInt();		// 배열 a의 요솟수
		
		int[] a = new int[na];		// 요솟수가 na인 배열
		
		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("배열 b의 요솟수 : ");
		int nb = stdIn.nextInt();		// 배열 b의 요솟수
		
		int[] b = new int[nb];		// 요솟수가 nb인 배열
		
		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}
		
		copy(a, b);
		
		System.out.print("a[] : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\nb[] : ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
 
	}

}
