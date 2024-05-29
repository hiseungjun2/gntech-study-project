package com.java.chap01;

/**
 * 1장 연습문제 1번
 */
public class ExQ1 {
    public static int max4(int a, int b, int c, int d) {
        int max = a;

        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        return max;
    }

    public static void main (String[] args) {
        System.out.println(max4(1, 5, 10, 2));
    }
}
