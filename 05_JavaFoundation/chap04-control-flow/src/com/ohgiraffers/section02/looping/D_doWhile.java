package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class D_doWhile {

    public void simpleDoWhileStatement()
    {
        /**
         * [do-while문 표현식]
         * 초기식;
         * do
         * {
         *      1회차는 무조건 실행하고 이후에는 조건식을 확인하여 수행할 구문(= 반복할 구문);
         *      증감식;
         * } while(조건식);
         */

        do
        {
            System.out.println("동작");
        } while(false);

        System.out.println("끝");
    }

    public void testDoWhileSample()
    {
        /**
         * [입력받은 문자열 출력하기]
         * 1. Scanner를 이용하여 문자열을 입력받는다.
         * 2. 입력받은 문자열을 출력해준다.
         * 3. 만약 "exit"가 입력되면 프로그램을 종료한다.
         * (참고) 문자열은 == 비교가 불가능하므로 equals()를 사용한다.
         */

        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;

        do {
            System.out.print("문자열을 입력하세요: ");
            String str = sc.nextLine();
            System.out.println(str);
            if(str.equals("exit"))
                isContinue = false;
        } while(isContinue);

    }

}
