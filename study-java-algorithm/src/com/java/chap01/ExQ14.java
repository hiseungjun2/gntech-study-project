package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 14번
 */
public class ExQ14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수 : ");
		int square = scanner.nextInt();
		
		for (int i = 1; i <= square; i++) {
			for (int j = 1; j <= square; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
