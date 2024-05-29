package com.java.chap06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 실습 6-13
 * Arrays.sort 메서드를 사용하여 정렬한다. (퀵 정렬)
 */
public class ArraysSortTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];			// 배열의 크기는 num
		
		// 배열 입력받기
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		Arrays.sort(x);		// 배열 x 를 정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < num; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}

}
