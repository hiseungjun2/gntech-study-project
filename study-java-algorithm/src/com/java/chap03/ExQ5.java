package com.java.chap03;

import java.util.Scanner;

/**
 * 3장 연습문제 5번
 * 이진 검색 알고리즘 프로그램에서 검색한 값과 같은 값을 갖는 요소가 하나 이상 있을 때
 * 그 요소 중에서 맨 앞의 요소를 찾는 binSearchX 메서드를 작성하세요
 */
public class ExQ5 {
	
	static int binSearchX(int[] a, int n, int key) {
		int pl = 0; 		// 맨 왼쪽 인덱스
		int pr = n-1;		// 맨 오른쪽 인덱스
		int pc = (pl + pr) / 2;		// 가운데 인덱스			
		
		do {
			if (a[pc] == key) {		// 1. 가운데 값과 key값이 같을 경우
				do {		// 반복 (pc 가 맨 왼쪽의 pl 과 같을 때 까지
					if (a[pc] == a[pc-1]) {		// 2. pc 위치와 그 앞 요소가 서로 일치할 경우
						pc--;		// pc 1 감소
					} else {	// 다를 경우
						return pc;		// pc 반환
					}
				} while(pc != pl);
			}
		} while (pl < pr);
		
		return -1;			// 실패 반환
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟 수 : ");
		int num = stdIn.nextInt();	
		
		int[] x = new int[num];		// 요솟수가 num인 배열
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : " );
		x[0] = stdIn.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i-1] > x[i]);		// 바로 앞의 요소보다 작으면 다시 입력
		}
		
		System.out.print("검색할 값 : ");		// 키 값 입력
		int key = stdIn.nextInt();
		
		int idx = binSearchX(x, num, key);		// 배열 x에서 키 값이 key인 요소를 검색
		
		if (idx == -1) {	// 실패일 경우
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}

}
