package com.java.chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 실습 3-8
 * 신체검사 데이터 배열에서 이진 검색하기
 */
public class PhysExamSearch {
	
	// 신체검사 데이터를 정의합니다.
	static class PhyscData {
		private String name;		// 이름
		private int	height;			// 키
		private double vision;		// 시력
		
		// 생성자
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		// 문자열을 반환하는 메서드 (정보확인용)
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		// 오름차순으로 정렬하기 위한 comparator
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData o1, PhyscData o2) {
				return (o1.height > o2.height) ? 1 :
						(o1.height < o2.height) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {
				new PhyscData("조유리", 162, 0.3),
				new PhyscData("안유진", 168, 0.4),
				new PhyscData("김민주", 169, 0.8),
				new PhyscData("최예나", 171, 1.5),
				new PhyscData("장원영", 173, 0.7),
				new PhyscData("권은비", 174, 1.2),
				new PhyscData("김채원", 175, 2.0),
		};
		
		System.out.print("몇 cm 인 사람을 찾고 있나요? : ");
		int height = stdIn.nextInt();		// 키값
		// 배열 x 에서
		// 키가 height인 요소를
		// HEIGHT_ORDER 에 의해 검색
		int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
		
		if (idx < 0) {
			System.out.println("요소가 없습니다.");
		} else {
			System.out.println("x[" + idx + "] 에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}

}
