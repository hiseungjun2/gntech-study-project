package com.java.chap05;

import java.util.Scanner;

import com.java.chap04.IntStack;

/**
 * 실습 5-5
 * 꼬리 재귀 제거 후 스택 사용
 */
public class RecurX2 {
	
	static void recur (int n) {
		// int 형 스택 선언
		IntStack s = new IntStack(n);
		
		while (true) {
			if (n > 0) {
				s.push(n);			// n 의 값을 푸시
				n = n - 1;
				continue;
			}
			
			if (!s.isEmpty()) {		// 스택이 비어있지 않다면
				n = s.pop();		// 저장하고 있던 n을 빼서
				System.out.println(n);		// 출력하고
				n = n - 2;			// - 2 작업
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		
		recur(x);
	}

}
