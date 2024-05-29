package com.java.chap03;

import java.util.Scanner;

/**
 * 실습 3-1
 * 선형 검색
 */
public class SeqSearch {
	
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색 합니다.
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;		// 인덱스
		
		while (true) {		// 무한 반복
			if (i == n) {		// 인덱스 번호가 요솟수와 같으면
				return -1;		// 실패
			}
			if (a[i] == key) {		// 배열요소가 키값과 같다면
				return i;		// 성공 및 해당 인덱스 반환
			}
			i++;	// 인덱스 증가
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
		
		int idx = seqSearch(x, num, key);		// 배열 x에서 키 값이 key인 요소를 검색
		
		if (idx == -1) {	// 실패일 경우
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}

}
