package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 17번
 * 아래를 향한 n단의 숫자 피라미드를 출력하는 메서드를 작성하세요
 */
public class ExQ17 {
	
	static void npria(int n) {
		for (int i = 1; i <= n; i++) {
			for (int k = i; k <= n; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (i-1)*2+1; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		npria(n);
	}

}
