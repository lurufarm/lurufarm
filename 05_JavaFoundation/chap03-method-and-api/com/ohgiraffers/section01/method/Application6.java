package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {
        /*
        * [static 메소드 호출 방법]
        * 클래스명.메소드명();
        * */
        System.out.println(Application6.sumTwoNumbers(10, 20));
//        System.out.println(Application6.mulTwoNumbers(10, 20));

        /* 동일한 클래스 내에 작성된 static 메서드는 클래스명 생략이 가능하다. */
        System.out.println(sumTwoNumbers(10, 20));

    }
    public static int sumTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public int mulTwoNumbers(int num1, int num2) {
        return num1 * num2;
    }
}
