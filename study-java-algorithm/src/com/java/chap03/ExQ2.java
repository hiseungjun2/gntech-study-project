package com.java.chap03;

import java.util.Scanner;

/**
 * 3장 연습문제 2번
 * 선형 검색의 스캐닝 과정을 상세하게 출력하는 프로그램을 작성하세요.
 * 이때, 각 행의 맨 왼쪽에 현재 검색하는 요소의 인덱스를 출력하고,
 * 현재 검색하고 있는 요소위에 * 기호를 출력하세요.
 */
public class ExQ2 {
	
	static void printSeqSearch(int[] a, int n, int key) {
		// 1. 첫 행 만들기
		System.out.printf("%3s|", "");
		for (int i = 0; i < n; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println("---+----------------------------------");
		
		int idx = -1;		// key 가 존재하는 인덱스 (기본 -1)
		
		// 2. 검색 시작
		for (int i = 0; i < n; i++) {
			System.out.printf("%3s|", "");		//    | 
			int starSpot = i + 1;		// * 가 위치하는 곳
			
			System.out.printf("%" + (3*starSpot) + "s", "*");	//    |   * ...
			
			System.out.println();
			System.out.printf("%3d|", i);		 
			for (int j = 0; j < n; j++) {		
				System.out.printf("%3d", a[j]);		// 0 | a[0] a[1] a[2] a[3]...
			}
			System.out.println();
			
			if (a[i] == key) {		// key 값을 찾았을 경우
				idx = i;		// 인덱스 저장
				break;			// 반복 종료
			}
		}
		
		if (idx == -1) {
			System.out.println(key + "가 존재하지 않습니다.");
		} else {
			System.out.println(key + "는 x[" + idx + "]에 있습니다.");
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟 수 : ");
		int num = stdIn.nextInt();	
		
		int[] x = new int[num];		// 요솟수가 num인 배열
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");		// 키 값 입력
		int key = stdIn.nextInt();
		
		printSeqSearch(x, num, key);		// 배열 x에서 키 값이 key인 요소를 검색
		
	}

}
