package com.java.chap02;

/**
 * 실습 2-11
 * 1,000 이하의 소수를 열거(버전3)
 */
public class PrimeNumber3 {

	public static void main(String[] args) {
		int counter = 0;				// 곱셈과 나눗셈의 횟수
		int ptr = 0;					// 찾은 소수의 갯수
		int[] prime = new int[500];		// 찾은 소수를 저장하는 배열
		
		prime[ptr++] = 2;			// prime[0] = 2
		prime[ptr++] = 3;			// prime[1] = 3
		
		for (int n = 5; n <= 1000; n += 2) {		// 대상은 홀수만
			boolean flag = false;
			for (int i = 1; prime[i] * prime[i] <= n; i++) {
				counter += 2;
				if (n % prime[i] == 0) {		// 나누어떨어지면 소수가 아님	
					flag = true;
					break;		// 반복 종료
				}
			}
			if (!flag) {
				prime[ptr++] = n;
				counter ++;
			}
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
	}

}
