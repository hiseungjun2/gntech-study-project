package com.java.chap03;

/**
 * 실습 3C-2
 * 자연스러운 정렬을 하려면 다음과 같은 방법으로 클래스를 정의합니다.
 */
public class A implements Comparable<A>{

	// 필드, 메서드 등
	
	public int compareTo(A c) {
		// this가 c보다 크면 양의 값 반환
		// this가 c보다 작으면 음의 값 반환
		// this가 c와 같으면 0 반환
		return 1;
	}
	
	public boolean equals(Object c) {
		// this가 c 와 같으면 true 반환
		// this가 c 와 다르면 false 반환
		return true;
	}
}
