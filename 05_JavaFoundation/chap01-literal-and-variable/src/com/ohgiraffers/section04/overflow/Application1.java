package com.ohgiraffers.section04.overflow;

public class Application1 {
    public static void main(String[] args) {
        /**
         * 오버플로우
         * 자료형별 값의 최대 범위를 벗어나는 경우
         * 발생한 carry를 버림처리하고 sign bit를 반전시켜 최소값으로 순환시킴
         */

        byte num1 = 127;
        num1++;

        System.out.println("num1 overflow: " + num1);

        // 언더플로우
        // 오버플로우의 반대 개념.

        byte num2 = -128;
        num2--;
        System.out.println("num2 underflow: " + num2);

        int firstNum = 1000000; // 7천억
        int secondNum = 700000; // 그러나 int에 담을 수 없는 숫자이기때문에 오버플로우가 발생됨. 원하는 값이 안 나옴

        int multi = firstNum * secondNum;
        System.out.println("multi: " + multi);

        long longMulti = firstNum * secondNum; // 이미 오버플로우가 된 값을 long에 담아도 변하지 않는다.
        System.out.println("longMulti: " + longMulti);

        // 강제 형변환 이용
        long result = (long)firstNum * secondNum;
        System.out.println("result: " + result);

    }
}
