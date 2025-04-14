package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {
        /* 변수 선언 방법
         * 자료형 변수명;
         *
         * 자료형이란?
         * 다양한 값의 형태별로 어느 정도의 크기를 하나의 값으로 취급할 것인지 미리 compiler와 약속한 키워드이다.
         * 이러한 자료형은 기본 자료형(Primary type)과 참조 자료형(Reference type)으로 나누어진다.
         */

        // 정수를 취급하는 자료형
        byte bnum;           // 1byte
        short snum;          // 2byte
        int inum;            // 4byte
        long lnum;           // 8byte

        // 실수를 취급하는 자료형
        float fnum;          // 4byte
        double dnum;         // 8byte

        // 문자를 취급하는 자료형
        char ch;
        char ch2;

        // 논리값을 취급하는 자료형
        boolean isTrue;     // 1byte

        /* 이상 8가지가 기본 자료형이다. */
        
        // 문자형을 취급하는 자료형
        String str;

        // 변수에 값 대입(값 대입 및 초기화)
        bnum = 1;
        snum = 2;
        inum = 4;
        lnum = 8L;      // long 자료형에 값을 초기화시킬 때는 대문자 L을 붙여야한다.

        fnum = 4.0f;    // 실수 뒤에 f를 붙여야함
        dnum = 8.0;

        ch = 'a';
        ch2 = 97;       // 'a' == 97

        isTrue = true;

        str = "안녕하세요";

        /*
         * 숫자로 된 형태의 값을 그대로 사용하는 자료형은 byte, short, int, double이다.
         * 일반적으로 사용하는 값을 독특한 형태가 아닌 일반적인 형태로 사용할 수 있는 자료형을 '대표 자료형'이라고 한다.
         * 정수형은 int, 실수형은 double이 대표 자료형이다.
         */

        // 선언과 동시에 초기화
        int point = 1000;
        int bonus = 100;

        System.out.println("bnum의 값: " + bnum);
        System.out.println("isTrue의 값: " + isTrue);
        System.out.println("str의 값: " + str);

        System.out.println("포인트와 보너스의 합은?: " + (point + bonus));

        point = point + 100;

        System.out.println("point + 100 = " + point);

    }
}
