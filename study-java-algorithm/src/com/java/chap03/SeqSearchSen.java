package com.java.chap03;

import java.util.Scanner;

/**
 * 실습 3-3
 * 선형 검색(보초법)
 */
public class SeqSearchSen {
	
	// 요솟수가 n인 배열 a 에서 key와 같은 요소를 보초법으로 선형 검색합니다.
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;		// 인덱스
		
		a[n] = key;		// 보초 추가
		
		while (true) {
			if (a[i] == key) {	
				break;
			}
			i++;
		}
		
		return i == n ? -1 : i;		// 인덱스가 요솟수와 같다면 실패(-1) 반환, 다르다면 인덱스 반환
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
		
		int idx = seqSearchSen(x, num, key);		// 배열 x에서 키 값이 key인 요소를 검색
		
		if (idx == -1) {	// 실패일 경우
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}

}
