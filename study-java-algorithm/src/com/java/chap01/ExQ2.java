package com.java.chap01;

/**
 * 1장 연습문제 2번
 */
public class ExQ2 {
    public static int min3(int a, int b, int c) {
        int min = a;

        if (min > b) min = b;
        if (min > c) min = c;

        return min;
    };

    public static void main (String[] args) {
        System.out.println(min3(5, 2, 1));
    }
}
