package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-3
 * 버블 정렬(버전 3)
 */
public class BubbleSort3 {
	// a[idx1] 와 a[idx2]의 값을 바꾼다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// 버블 정렬 (교환이 수행되지 않으면 정렬 종료)
	static void bubbleSort(int[] a, int n) {
		int k = 0;		// a[k] 보다 앞쪽은 정렬을 마친 상태
		while (k < n - 1) {
			int last = n - 1;		// 마지막으로 요소를 교환한 위치
			for (int j = n - 1; j > k; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			k = last;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("버블 정렬(버전 3)");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		// 배열 입력받기
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		// 버블 정렬
		bubbleSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}

}
