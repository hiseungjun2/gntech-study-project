package com.java.chap10;

import java.util.Comparator;
import java.util.Scanner;

/**
 * 실습 10-2
 * 이진검색트리 클래스 BinTree<K, V>의 이용 예
 */
public class BinTreeTester {
	static Scanner stdIn = new Scanner(System.in);
	
	// 데이터 (회원번호 + 이름)
	static class Data {
		static final int NO = 1;			// 번호를 입력 받습니까?
		static final int NAME = 2;			// 이름을 입력 받습니까?
		
		private Integer no;					// 회원번호
		private String name;				// 이름
		
		Integer keyCode() {
			return no;
		}
		
		// 문자열을 반환합니다.
		public String toString() {
			return name;
		}
		
		// 데이터를 입력합니다.
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");
			
			if ((sw & NO) == NO) {
				System.out.print("번호 : ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름 : ");
				name = stdIn.next();
			}
		}
	}
	
	// 메뉴 열거형
	enum Menu {
		ADD(			"삽입"),
		REMOVE(			"삭제"),
		SEARCH(			"검색"),
		PRINT(			"표시"),
		TERMINATE(		"종료");
		
		private final String message;		// 출력할 문자열
		
		static Menu MenuAt(int idx) {		// 서수가 idx 인 열거를 반환
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) {
					return m;
				}
			}
			return null;
		}
		
		Menu(String string) {			// 생성자
			message = string;
		}
		
		String getMessage() {		// 출력할 문자열을 반환
			return message;
		}
	}
	
	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s   ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal()) {
					System.out.println();
				}
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;						// 메뉴
		Data data;						// 추가용 데이터 참조
		Data ptr;						// 검색용 데이터 참조
		Data temp = new Data();			// 입력용 데이터
		
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
		
		do {
			switch (menu = SelectMenu()) {
				case ADD :				// 노드를 삽입
					data = new Data();
					data.scanData("삽입", Data.NO | Data.NAME);
					tree.add(data.keyCode(), data);
					break;
				
				case REMOVE :			// 노드를 삭제
					data = new Data();
					data.scanData("삭제", Data.NO);
					tree.remove(temp.keyCode());
					break;
				
				case SEARCH :			// 노드를 검색
					temp.scanData("검색", Data.NO);
					ptr = tree.search(temp.keyCode());
					if (ptr != null) {
						System.out.println("그 번호의 이름은 " + ptr + "입니다.");
					}
					else {
						System.out.println("해당 데이터가 없습니다.");
					}
					break;
					
				case PRINT : 			// 모든 노드를 키 값의 오름차순으로 출력
					tree.print();
					break;
					
				default : 
			}
		} while (menu != Menu.TERMINATE);
	}

}
