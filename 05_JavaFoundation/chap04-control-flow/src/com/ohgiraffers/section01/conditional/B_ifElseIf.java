package com.ohgiraffers.section01.conditional;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class B_ifElseIf {

    /**
     * [if-elseIf 표현식]
     * if(조건식1)
     * {
     *     조건식1이 true일 때 실행할 명령문;
     * }
     * else if(조건식2)
     * {
     *     조건식 1이 false이고 조건식 2가 true일 때 실행할 명령문;
     * }
     * else
     * {
     *     조건식 1, 2 모두 false일 경우 실행할 명령문;
     * }
     */

    public void simpleIfElseStatement()
    {
        System.out.println("펑~ 산신령이 나타났다!");
        System.out.print("어느 도끼가 네 도끼니? (1. 금도끼 / 2. 은도끼 / 3. 쇠도끼)");

        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        if(answer == 1)
            System.out.println("거짓말치지 말거라! 욕심이 과하구나!!");
        else if(answer == 2)
            System.out.println("욕심을 크게 부리지는 않았으나 거짓말을 하는구나, 네 이놈!!");
        else
            System.out.println("너는 정말 정직한 나무꾼이로구나, 옛다 다 가지렴~");

        System.out.println("산신령은 연못으로 다시 사라진다.. 펑~");
    }

    public void nestedIfElseIfStatement()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생의 이름: ");
        String name = sc.nextLine();
        System.out.print("학생의 점수: ");
        int score = sc.nextInt();

        String grade = "";

        if(score >= 90)
        {
            grade = "A";

            if(score >= 95)
                grade += "+";
        }
        else if (score >= 80)
        {
            grade = "B";

            if(score >= 85)
                grade += "+";
        }
        else if (score >= 70)
        {
            grade = "C";

            if(score >= 75)
                grade += "+";
        }
        else if (score >= 60)
        {
            grade = "D";

            if(score >= 65)
                grade += "+";
        }
        else
            grade = "F";

        System.out.println(name + "학생의 점수는 " + score + "점 이고, 등급은 " + grade + "입니다.");
    }

}
