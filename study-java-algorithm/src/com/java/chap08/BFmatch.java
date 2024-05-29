package com.java.chap08;

import java.util.Scanner;

/**
 * 실습 8-1
 * 브루트-포스법으로 문자열 검색하는 프로그램
 */
public class BFmatch {
	
	// 브루트-포스법으로 문자열을 검색하는 메서드
	static int bfMatch(String txt, String pat) {
		int pt = 0;			// txt 커서
		int pp = 0;			// pat 커서
		
		while (pt != txt.length() && pp != pat.length()) {		// txt 커서와 pat 커서가 각각 문자열의 길이가 될때까지 반복
			// txt 의 커서에 위치하는 글자와
			// pat 의 커서에 위치하는 글자가 같을 경우
			if (txt.charAt(pt) == pat.charAt(pp)) {
				// 커서 증가
				pt++;
				pp++;
			} else {
				// 커서 초기화
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		
		if (pp == pat.length()) {		// 검색 성공
			return pt - pp;
		}
		
		return -1;		// 검색 실패
	}
	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = stdIn.next();	// 텍스트용 문자열
		
		System.out.print("패턴 : ");
		String s2 = stdIn.next();	// 패턴용 문자열
		
		int idx = bfMatch(s1, s2);		// 문자열 s1 에서 문자열 s2 를 검색
		
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {
			// 일치하는 문자 바로 앞까지의 길이를 구함
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
		
	}

}
