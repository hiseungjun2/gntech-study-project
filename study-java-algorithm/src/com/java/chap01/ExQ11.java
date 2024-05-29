package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 11번
 */
public class ExQ11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수를 입력하세요. ");
		int num = scanner.nextInt();
		
		int divNum = 1;		// 나눌 수
		int lengthNum = 1;	// 자리 수
		int modNum = 0;
		
		do {
			modNum = num / divNum;
			
			if (modNum >= 10) {
				lengthNum++;
				divNum = divNum * 10;
			}
			
		} while (modNum >= 10);
		
		System.out.println("그 수는 " + lengthNum + "자리 입니다.");
	}
}
 