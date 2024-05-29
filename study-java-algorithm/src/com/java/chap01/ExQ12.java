package com.java.chap01;

/**
 * 1장 연습문제 12번
 */
public class ExQ12 {
	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <=9; j++) {
				if (i == 0 && j == 0) {		// 첫 행
					System.out.printf("%3s", "");
					System.out.printf("%3s", "|");
				} else if (i == 0 && j != 0) {	// 첫 행 다음의 구분선
					System.out.printf("%3d", j);
				} else if (i != 0 && j == 0) {	// 첫 열
					System.out.printf("%3d", i);
					System.out.printf("%3s", "|");
				} else {	// 곱셈 
					System.out.printf("%3d", i * j);
				}
			}
			
			System.out.println();
			
			if (i == 0) {
				System.out.println("  ---+---------------------------");
			}
		}
	}

}
