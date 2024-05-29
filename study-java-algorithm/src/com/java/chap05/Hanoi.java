package com.java.chap05;

import java.util.Scanner;

/**
 * 실습 5-6
 * 하노이의 탑
 */
public class Hanoi {
	
	// no 개의 원반을 x번 기둥에서 y번 기둥으로 옮김
	// 기둥 번호를 1, 2, 3으로 나타낸다.
	static void move(int no, int x, int y) {
		if (no > 1) {
			// 바닥 원반을 제외한 나머지 원반을 그룹지어서 (no - 1)
			// x번기둥(시작기둥) 에서 6-x-y번기둥(중간기둥) 으로 옮긴다.
			move(no - 1, x, 6 - x - y);
		}
		System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 3옮김");
		if (no > 1) {
			// 바닥 원반을 제외한 나머지 원반을 그룹지어서 (no - 1)
			// 6-x-y번기둥(중간기둥) 에서 y번기둥(목표기둥) 으로 옮긴다.
			move(no - 1, 6 - x - y, y);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 : ");
		int n = stdIn.nextInt();
		
		move(n, 1, 3);		// 1번 기둥의 n개의 원반을 3번 기둥으로 옮김
	}

}
