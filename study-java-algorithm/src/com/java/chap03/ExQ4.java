package com.java.chap03;

import java.util.Scanner;

/**
 * 3장 연습문제 4번
 * 오른쪽처럼 이진 검색의 과정을 자세히 출력하는 프로그램을 작성하세요.
 * 각 행의 맨 왼쪽에 현재 검색하고 있는 요소의 인덱스를 출력하고,
 * 검색 범위의 맨 앞 요소 위에 <-, 맨 끝 요소 위에 ->, 현재 검색하고 있는 중앙 요소 위에 + 을 출력하세요
 */
public class ExQ4 {
	
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;			// 배열의 맨 왼쪽
		int pr = n-1;		// 배열의 맨 오른쪽
		
		int pc = (pl + pr) / 2; 		// 가운데 인덱스
		
		// 1. 헤더 그리기
		System.out.printf("%4s", "|");
		for (int i = 0; i < n; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println("---+----------------------------");
		
		// 2. 기호 및 배열요소 그리기
		do {
			System.out.printf("%4s", "|");
			System.out.printf("%" + (3*(pl+1)) + "s", "<-");
			System.out.printf("%" + (3*(pc-(pl))) + "s", "*");
			System.out.printf("%"+ (3*(pr-(pc))) + "s", "->");
			System.out.println();
			
			
			System.out.printf("%2d |", pc);		// 맨 왼쪽에 현재 검색하고 있는 요소의 인덱스
			for (int i = 0; i < n; i++) {
				System.out.printf("%3d", a[i]);
			}
			System.out.println();
			
			if (a[pc] == key) {
				return pc;
			} else if (a[pc] > key) {
				pr = pc - 1;
			} else if (a[pc] < key) {
				pl = pc + 1;
			}
			
			pc = (pl + pr) / 2;		// 가운데 인덱스
			
		} while (pl < pr);
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수를 입력하세요 : ");
		int n = scanner.nextInt();
		
		int[] a = new int[n];		// 배열 생성
		
		System.out.print("a[0] : " );
		a[0] = scanner.nextInt();
		
		for (int i = 1; i < n; i++) {
			do {
				System.out.print("a[" + i + "] : ");
				a[i] = scanner.nextInt();
			} while (a[i-1] > a[i]);		// 바로 앞의 요소보다 작으면 다시 입력
		}
		
		System.out.print("key 값을 입력하세요 : ");
		int key = scanner.nextInt();
		
		int idx = binSearch(a, n, key);
		
		if (idx == -1) {
			System.out.println(key + "는 배열 a 에 존재하지 않습니다.");
		} else {
			System.out.println(key + "는 a[" + idx + "] 에 있습니다.");
		}
		
	}

}
