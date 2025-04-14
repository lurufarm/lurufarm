package com.ohgiraffers.section03.branching;

public class B_continue {

    public void simpleContinueStatement()
    {
        /**
         * [continue]
         * continue는 반복문 내에서 사용한다.
         * 반복문의 해당 회차를 넘기고, 증감식으로 이동하게 한다.
         * 일반적으로 if(조건식) { continue; } 와 같은 방식으로 사용
         * 보통 반복문 내에서 특정 조건에 대한 예외를 처리하고자 할 때 자주 사용한다.
         */

        for(int i = 1; i <= 100; i++)
        {
            if(i % 4 != 0)
                continue;

            System.out.println(i);
        }
    }

    public void testJumpContinue()
    {
        lable1:
        for (int dan = 2; dan < 10; dan++)
        {
            System.out.println("====== " + dan + "단 ======");

            lable2:
            for(int su = 1; su < 10; su++)
            {
                if (su % 2 == 0)
                    continue lable1;
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
        }

        System.out.println("구구단 끝!");
    }

}
