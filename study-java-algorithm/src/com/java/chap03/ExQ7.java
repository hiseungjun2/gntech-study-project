package com.java.chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 3장 연습문제 7번
 * 시력에 대한 내림차순 정렬의 신체검사 데이터에서 특정 시력을 가진 사람을 검색하는 프로그램을 작성하세요.
 */
public class ExQ7 {

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
		public static final Comparator<PhyscData> VISION_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData o1, PhyscData o2) {
				return (o1.vision < o2.vision) ? 1 :
						(o1.vision > o2.vision) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {
				new PhyscData("김채원", 175, 2.0),
				new PhyscData("최예나", 171, 1.5),
				new PhyscData("권은비", 174, 1.2),
				new PhyscData("김민주", 169, 0.8),
				new PhyscData("장원영", 173, 0.7),
				new PhyscData("안유진", 168, 0.4),
				new PhyscData("조유리", 162, 0.3),
		};
		
		System.out.print("시력이 몇인 사람을 찾고 있나요? : ");
		double vision = stdIn.nextDouble();		// 키값
		// 배열 x 에서
		// 키가 height인 요소를
		// HEIGHT_ORDER 에 의해 검색
		int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);
		
		if (idx < 0) {
			System.out.println("요소가 없습니다.");
		} else {
			System.out.println("x[" + idx + "] 에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}

}
