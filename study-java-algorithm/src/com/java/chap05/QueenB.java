package com.java.chap05;

/**
 * 실습 5-7
 * 각 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열합니다.
 */
public class QueenB {
	
	static int[] pos = new int[8];		// 각 열의 퀸의 위치
	
	// 각 열의 퀸의 위치를 출력합니다.
	static void print() {
		for (int i = 0; i < 8; i++) {
			System.out.printf("%2d", pos[i]);
		}
		System.out.println();
	}
	
	// i 열에 퀸을 놓습니다.
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			pos[i] = j;		// 퀸을 j행에 배치한다.
			if (i == 7) {	// 모든 열에 배치되었을 경우
				print();	// 출력
			} else {
				set(i + 1);	// 다음열에 퀸을 배치
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
