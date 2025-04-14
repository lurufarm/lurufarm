package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class A_if {

    public void simpleIfStatement()
    {
        /**
         * if(조건식)
         * {
         *      조건식이 true일 때 실행 할 명령문;
         * }
          */

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 하나 입력: ");
        int num = sc.nextInt();

        if(num % 2 == 0)
        {
            System.out.println("짝수로구나~!");
        }
        System.out.println("끝~!");
    }

    public void nestedIfStatement()
    {
        // if문 안에서 또 다른 조건을 사용하여 if문을 사용할 수 있다

        int num = 1;
        if(num > 0)
        {
            if(num % 2 == 0)
                System.out.println("양수이면서 짝수로구나");
            if(num % 2 != 0)
                System.out.println("양수이면서 홀수로구나");
        }
        System.out.println("끝");
    }
}
