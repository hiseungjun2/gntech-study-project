package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-5
 * 단순 삽입 정렬
 */
public class InsertionSort {
	
	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;	
			int tmp = a[i];
			// 정렬된 열의 왼쪽 끝에 도달하거나
			// tmp 보다 작거나 같은 key를 갖는 항목 a[j]를 발견할 경우 대입
			// 이 조건을 드모르간의 법칙을 적용하면 아래와 같은 두 조건이 모두 성립할 때 까지 반복한다고 볼 수 있음
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		// 배열 입력받기
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		// 단순 삽입 정렬
		insertionSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}

}
