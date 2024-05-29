package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-7
 * 셀 정렬(버전 2, h 의 값은 ..., 40, 13, 4, 1)
 */
public class ShellSort2 {
	
	static void shellSort(int[] a, int n) {
		int h;
		// 1. h 의 초기값을 구함
		// 1부터 시작하여 값을 3배하고, 1을 더하면서 n / 9 를 넘지 않는 가장 큰 값을 h 에 대입
		for (h = 1; h < n / 9; h = h * 3 + 1) {
			;
		}
		
		for (; h > 0; h /= 3) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("셀 정렬(버전 2)");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		shellSort(x, nx);		// 배열 x 셀 정렬 
		
		System.out.println("오름차순으로 정렬했습니다.");
		
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}

}
