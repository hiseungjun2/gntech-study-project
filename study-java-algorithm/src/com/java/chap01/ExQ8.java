package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 8번
 */
public class ExQ8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int n = scanner.nextInt();
		
		// 가우스의 덧셈을 이용하기 위해 변수 선언
		// n * (n + 1) / 2
		
		int sum = n * (n + 1) / 2;
		
		System.out.println("sum : " + sum);
	}

}
