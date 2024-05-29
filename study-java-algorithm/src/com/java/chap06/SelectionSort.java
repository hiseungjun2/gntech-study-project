package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-4
 * 단순 선택 정렬
 */
public class SelectionSort {
	
	// a[idx1] 와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 단순 선택 정렬 (교환이 수행되지 않으면 정렬 종료)
	static void selectionSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;			// 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록한다.
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, i, min);		// 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환한다.
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("단순 선택 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		// 배열 입력받기
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		// 단순 선택 정렬
		selectionSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}

}
