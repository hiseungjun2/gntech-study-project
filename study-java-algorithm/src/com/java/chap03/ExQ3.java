package com.java.chap03;

import java.util.Scanner;

/**
 * 3장 연습문제 3번
 * 요솟수가 n인 배열a 에서 key 와 일치하는 모든 요소의 인덱스를 
 * 배열 idx의 맨 앞부터 순서대로 저장하고, 일치한 요솟수를 반환하는 메서드를 작성하세요.
 * ex) 요솟수가 8인 배열 a의 요소가 {1, 9, 2, 9, 4, 6, 7, 9} 이고 key가 9인 배열 idx에
 * {1, 3, 7} 을 저장하고 3을 반환합니다.
 */
public class ExQ3 {
	
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int returnIdxNum = 0;		// 반환할 인덱스 수
		
		for (int i = 0; i < n; i++) {		// 선형 검색
			if (a[i] == key) {			// key 값과 같을 경우
				idx[returnIdxNum++] = i;		// 인덱스 1 증가 및 배열에 저장
			}
		}
		
		return returnIdxNum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 n 을 입력하세요 : ");
		int n = scanner.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			a[i] = scanner.nextInt();
		}
		
		System.out.print("key 값을 입력하세요 : ");
		int key = scanner.nextInt();
		
		int[] idx = new int[n];			// 요솟수 만큼 배열 생성
		
		System.out.println(searchIdx(a, n, key, idx));
		
	}

}
