package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-9
 * 퀵 정렬
 */
public class QuickSort {
	
	// 배열 요소 a[idx1] 과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// 퀵 정렬
	static void quickSort(int[] a, int left, int right) {
		int pl = left;		// 왼쪽 커서
		int pr = right;		// 오른쪽 커
		int x = a[(pl + pr) / 2]; 	// 피벗
		
		do {
			while (a[pl] < x) pl++;		// 왼쪽부터 차례대로 피벗보다 같거나 큰지 검사
			while (a[pr] > x) pr--;		// 오른쪽부터 차례대로 피벗보다 같거나 작은지 검사
			if (pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while (pl <= pr);
		
		if (left < pr) quickSort(a, left, pr);
		if (pl < right) quickSort(a, pl, right);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("퀵 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] :");
			x[i] = stdIn.nextInt();
		}
		
		quickSort(x, 0, nx - 1);		// 배열 x를 퀵정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
		
	}

}
