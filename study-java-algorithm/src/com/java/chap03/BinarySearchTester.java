package com.java.chap03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 실습 3-5
 * Arrays.binarySearch 로 이진 검색
 */
public class BinarySearchTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];			// 요솟수가 num 인 배열
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : " );
		x[0] = stdIn.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		
		if (idx < 0) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "] 에 있습니다.");
		}
		
	}

}
