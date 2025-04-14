package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {

    public void printGugudan()
    {
        for (int dan = 2; dan < 10; dan++)
        {
            System.out.println("====== " + dan + "단 ======");
            for(int su = 1; su < 10; su++)
            {
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
        }
    }

    public void printStarInputRow()
    {
        /**
         * [별 5개씩 찍기]
         * 1. Scanner를 이용하여 row수(int)를 입력받는다.
         * 2. 한 줄에 *이 5개인 row를 입력받은 만큼 출력한다.
         * 단, 중첩 for문을 사용한다.
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("줄 수를 입력하세요: ");
        int row = sc.nextInt();

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printStarTraining()
    {
        /**
         * [갯수만큼 * 찍기]
         * 1. Scanner를 이용하여 row수(int)를 입력받는다.
         * 2. 줄마다 row수만큼 *을 출력한다.
         *    예시) 정수를 입력하세요 : 5
         *    *
         *    **
         *    ***
         *    ****
         *    *****
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요: ");
        int row = sc.nextInt();

        for(int i = 1; i <= row; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
