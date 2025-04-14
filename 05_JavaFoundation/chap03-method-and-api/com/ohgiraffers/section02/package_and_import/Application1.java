package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {

        com.ohgiraffers.section01.method.Calculator calc =
                new com.ohgiraffers.section01.method.Calculator();
        int min = calc.minNumberOf(300, 100);

        System.out.println("더 작은 값: " + min);

        // static 메서드
        int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(300, 100);

        System.out.println("더 큰 값: " + max);
    }
}
