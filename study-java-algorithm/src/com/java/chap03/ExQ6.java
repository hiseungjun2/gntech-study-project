package com.java.chap03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3장 연습문제 6번
 * 실습 3-5 를 수정하여 검색에 실패하면 삽입 포인트의 값을 출력하는 프로그램을 작성하세요
 */
public class ExQ6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = scanner.nextInt();
		int[] x = new int[num];			// 요솟수가 num 인 배열
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : " );
		x[0] = scanner.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = scanner.nextInt();
			} while (x[i] < x[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = scanner.nextInt();
		
		int idx = Arrays.binarySearch(x, key);
		
		if (idx < 0) {
			System.out.println("그 값의 요소가 없습니다.");
			
			// 검색 실패 시 메서드는 key값 보다 큰 요소의 첫번째 인덱스 x의 -x-1을 반환
			// 따라서 -(-x-1+1)을 한 인덱스를 가져온다.
			System.out.println(idx);
			System.out.println("삽입 포인트의 값은 " + (-(idx+1)) + " 입니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "] 에 있습니다.");
		}
	}

}
