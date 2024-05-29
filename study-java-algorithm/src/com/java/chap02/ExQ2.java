package com.java.chap02;

import java.util.Scanner;

/**
 * 2장 연습문제 2번
 * 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성하세요.
 */
public class ExQ2 {

	static void swap(int[] a, int idx1, int idx2) {
		System.out.println("a[" + idx1 + "]과(와) a[" + idx2 + "]를 교환합니다.");
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	static void reverse(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = scanner.nextInt();
		
		int[] a = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = scanner.nextInt();
		}
		
		reverse(a);
		
	
	}

}
