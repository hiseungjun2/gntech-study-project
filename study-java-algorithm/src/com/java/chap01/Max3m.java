package com.java.chap01;

public class Max3m {

    // a, b, c의 최대값을 구하여 반환한다.
    static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("max3(3, 2, 1) = " + max3(3, 2, 1));     // [A] a > b > c
        System.out.println("max3(3, 2, 2) = " + max3(3, 2, 2));     // [B] a > b = c
        System.out.println("max3(3, 1, 2) = " + max3(3, 1, 2));     // [C] a > c > b
        System.out.println("max3(3, 2, 3) = " + max3(3, 2, 3));     // [D] a > b > c
        System.out.println("max3(2, 1, 3) = " + max3(2, 1, 3));     // [E] a > b > c
        System.out.println("max3(3, 3, 2) = " + max3(3, 3, 2));     // [F] a > b > c
        System.out.println("max3(3, 3, 3) = " + max3(3, 3, 3));     // [G] a > b > c
        System.out.println("max3(2, 2, 3) = " + max3(2, 2, 3));     // [H] a > b > c

    }
}
