package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-11
 * 정렬을 마친 배열의 병합
 */
public class MergeArray {
	
	// 정렬을 마친 배열 a, b를 병합하여 배열 c에 저장한다.
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;		// 배열 a의 커서
		int pb = 0;		// 배열 b의 커서
		int pc = 0;		// 배열 c의 커서
		
		// 1. 배열 a의 커서가 배열 a의 요소 na 보다 작고
		//	  배열 b의 커서가 배열 b의 요소 nb 보다 작을 때 까지 반복하고
		//    작은 값을 배열 c에 저장한다.
		while (pa < na && pb < nb) {
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		}
		
		// 2. 배열 b의 모든 요소를 복사한 후
		//	  배열 a에 아직 복사하지 못한 요소가 남아있을 경우
		//	  배열 c에 남은 요소를 저장한다.
		while (pa < na) {
			c[pc++] = a[pa++];
		}
		
		// 3. 배열 a의 모든 요소를 복사한 후
		//	  배열 b에 아직 복사하지 못한 요소가 남아있을 경우
		//	  배열 c에 남은 요소를 저장한다.
		while (pb < nb) {
			c[pc++] = b[pb++];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int[] c = new int[13];
		
		System.out.println("두 배열의 병합");
		
		merge(a, a.length, b, b.length, c);
		
		System.out.println("배열 a와 b를 병합하여 배열 c에 저장");
		System.out.println("배열 a: ");
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
		System.out.println("배열 b: ");
		for (int i = 0; i < b.length; i++) {
			System.out.println("b[" + i + "] = " + b[i]);
		}
		
		System.out.println("배열 c: ");
		for (int i = 0; i < c.length; i++) {
			System.out.println("c[" + i + "] = " + c[i]);
		}
	}

}
