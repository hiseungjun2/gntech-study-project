package com.java.chap04;

import java.util.Scanner;

/**
 * 4장 연습문제 1번
 * 클래스 IntStack의 모든 메서드를 사용하는 프로그램을 작성하세요.
 */
public class ExQ1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);			// 최대 64개를 푸시할 수 있는 스택
		
		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)요소찾기 (6)클리어 (7)비어있는가? (8)가득찼는가? (0)종료 : ");
			int menu = stdIn.nextInt();
			
			// 0을 입력했을 때 종료
			if (menu == 0) {
				break;
			}
			
			int x;
			switch(menu) {
				case 1 :		// 푸시 
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(x);
					} catch (IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;
				case 2 :		// 팝
					try {
						x = s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
				case 3 :		// 피크
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
				case 4 :		// 덤프
					s.dump();
					break;
				case 5 :		// 요소 찾기
					try {
						System.out.print("찾을 데이터 : ");
						x = stdIn.nextInt();
						int idx = s.indexOf(x);
						
						if (idx < 0) {
							System.out.println("찾을 데이터가 없습니다.");
						} else {
							System.out.println("위치는 " + idx + " 입니다.");
						}
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
				
				case 6 :		// 클리어
					s.clear();
					System.out.println("스택을 비웠습니다.");
					break;
				case 7 :		// 비어있는가
					if (s.isEmpty()) {
						System.out.println("스택이 비어 있습니다.");
					} else {
						System.out.println("스택이 비어있지 않습니다.");
					}
					break;
				case 8 :		// 가득찼는가
					if (s.isFull()) {
						System.out.println("스택이 가득 찼습니다.");
					} else {
						System.out.println("스택이 가득차지 않습니다.");
					}
					break;
			}
		}

	}

}
