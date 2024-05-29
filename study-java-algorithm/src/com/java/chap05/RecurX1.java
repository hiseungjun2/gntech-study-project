package com.java.chap05;

import java.util.Scanner;

/**
 * 실습 5-4
 * 꼬리 재귀 제거
 */
public class RecurX1 {

	// n의 값을 n - 2 로 업데이트하고 메서드의 시작지점으로 돌아간다.
	static void recur(int n) {
		while (n > 0) {
			recur(n - 1);
			System.out.println(n);
			n = n - 2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		
		recur(x);
	}

}
