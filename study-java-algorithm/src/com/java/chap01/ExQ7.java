package com.java.chap01;

import java.util.Scanner;

/**
 * 1장 연습문제 7번
 */
public class ExQ7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n 을 입력하세요 : ");
        int n = scanner.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;

            if (i == 7) break;
        }

        System.out.println("sum : " + sum);

    }
}
