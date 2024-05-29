package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 15번
 * 직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.
 */
public class ExQ15 {
	
	static void triangleLB(int n) {		// 왼쪽 아래가 직각인 이등변 삼각형을 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleLU(int n) {		// 왼쪽 위가 직각인 이등변 삼각형을 출력
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRU(int n) {		// 오른쪽 위가 직각인 이등변 삼각형을 출력
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRB(int n) {		// 오른쪽 아래가 직각인 이등변 삼각형을 출력
		// 41, 32, 23, 14, 05
		for (int i = n; i >= 1; i--) {
			for (int k = i-1; k >= 1; k--) {
				System.out.print(" ");
			}
			for (int j = n; j > i-1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		triangleLB(n);
		System.out.println("====================");
		triangleLU(n);
		System.out.println("====================");
		triangleRU(n);
		System.out.println("====================");
		triangleRB(n);
	}

}
