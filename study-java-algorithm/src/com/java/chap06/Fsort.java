package com.java.chap06;

import java.util.Scanner;

/**
 * 실습 6-17
 * 도수 정렬
 */
public class Fsort {
	// 도수 정렬 (0 이상 max 이하의 값을 입력한다)
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];		// 누적 도수
		int[] b = new int[n];			// 작업용 목적 배열
		
		for (int i = 0;		i < n; 		i++) f[a[i]]++;				// 1단계 : 도수분보표 만들기
		for (int i = 1;		i <= max;	i++) f[i] += f[i - 1];		// 2단계 : 누적도수분포표 만들기
		for (int i = n - 1;	i >= 0;		i--) b[--f[a[i]]] = a[i];	// 3단계 : 작업용 목적 배열 만들기
		for (int i = 0;		i < n;		i++) a[i] = b[i];			// 4단계 : 정렬이 완료된 작업옹 배열에서 a 로 옮기기
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("도수 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < 0);
		}
		
		// 배열의 최대값 구하기
		int max = x[0];
		for (int i = 0; i < nx; i++) {
			if (x[i] > max) max = x[i];
		}
		
		fSort(x, nx, max);			// 도수 정렬
		
		System.out.println("오름차순으로 정렬완료");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
		
	}

}
