package com.ohgiraffers.section01.method;

public class Calculator {

    public int minNumberOf(int num1, int num2) {
        return (num1 > num2)? num2 : num1;
    }

    public static int maxNumberOf(int num1, int num2) {
        return (num1 > num2)? num1 : num2;
    }
}
