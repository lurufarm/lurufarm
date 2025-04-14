package com.ohgiraffers.section01.literal;

public class Application3 {
    public static void main(String[] args) {

        System.out.println("두 개의 문자열 합치기");
        System.out.println(9 + 9);
        System.out.println("9" + 9);
        System.out.println("9" + "9");

        System.out.println("세 개의 문자열 합치기");
        System.out.println(9 + 9 + "9"); // 18 + "9" -> 189
        System.out.println("9" + 9 + "9"); // 999
        System.out.println("9" + "9" + 9); // 999
        System.out.println("9" + (9 + 9)); // 소괄호 이용하여 연산 우선순위 설정. 918

        System.out.println(10 + 20);
        System.out.println(10 - 20);
        System.out.println(10 * 20);
        System.out.println(10 / 20);
        System.out.println(10 % 20);

        // 문자열 합치기를 응용하여 출력 결과를 보기 좋게 변경
        System.out.println("10과 20의 합:" + (10 + 20));
    }
}
