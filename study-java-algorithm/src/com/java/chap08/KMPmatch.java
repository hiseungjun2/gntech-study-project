package com.java.chap08;

/**
 * 실습 8-3
 * KMP 법에 의한 문자열 검색
 */
public class KMPmatch {
	static int kmpMatch(String txt, String pat) {
		int pt = 1;					// txt 커서
		int pp = 0;					// pat 커서
		int[] skip = new int[pat.length() + 1];		// 건너뛰기표
		
		// 건너뛰기 표를 만든다
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			} else if (pp == 0) {
				skip[++pt] = pp;
			} else {
				pp = skip[pp];
			}
		}
		
		// 검색
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0) {
				pt++;
			} else {
				pp = skip[pp];
			}
		}
		
		if (pp == pat.length()) {		// 검색 성공
			return pt - pp;
		}
		
		return -1;		// 검색 실패
	}
}
