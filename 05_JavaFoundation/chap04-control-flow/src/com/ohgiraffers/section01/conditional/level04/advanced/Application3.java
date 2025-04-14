package com.ohgiraffers.section01.conditional.level04.advanced;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Application3 {

    /* 정수를 입력받아 1부터 입력받은 정수까지
     * 홀수이면 "수", 짝수이면 "박"이 정수만큼 누적되어 출력되게 작성하시오.
     *
     * -- 입력 예시 --
     * 정수를 입력하세요 : 5
     *
     * -- 출력 예시 --
     * 수박수박수
     * */

    public void problem1()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++)
        {
            if (i % 2 == 1)
                System.out.print("수");
            else
                System.out.print("박");
        }
    }

    /* 1부터 100 사이의 난수를 발생시키고
     * 정수를 입력 받아서 입력받은 정수가 발생한 난수보다 큰 경우 "입력하신 정수보다 큽니다." 출력,
     * 입력받은 정수보다 난수가 작은 경우 "입력하신 정수보다 작습니다." 를 출력하며
     * 입력한 정수와 난수와 같은 경우까지 난수 맞추기를 반복하는 프로그램을 만드세요.
     *
     * 단, 입력한 정수와 난수가 같은 경우   "정답입니다. 4회 만에 정답을 맞추셨습니다." 하고
     * 정답을 입력한 횟수도 함께 출력되도록 해야 합니다.
     * 처음부터 바로 난수를 맞추는 경우는 1회만에 정답을 맞춘 것입니다.
     *
     * 정답을 맞추는 경우 위 내용을 출력하고 프로그램이 종료되도록 작성하면 됩니다.
     *
     * -- 프로그램 예시 --
     * 정수를 입력하세요 : 5
     * 입력하신 정수보다 작습니다.
     * 정수를 입력하세요 : 3
     * 입력하신 정수보다 큽니다.
     * 정수를 입력하세요 : 4
     * 정답입니다. 3회만에 정답을 맞추셨습니다.
     * */

    public void problem2()
    {
        int random = (int)(Math.random() * 100) + 1;
//        System.out.println(random);
        System.out.print("정수를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        int myNum = sc.nextInt();
        int count = 1;

        if (myNum == random)
        {
            System.out.println("정답입니다. 바로 맞추셨습니다.");
            return;
        }

        while(myNum != random)
        {
            count++;
            if(myNum > random)
                System.out.println("입력하신 정수보다 랜덤이 작습니다.");
            else if (myNum < random)
                System.out.println("입력하신 정수보다 랜덤이 큽니다.");
            else break;

            System.out.print("정수를 입력하세요: ");
            myNum = sc.nextInt();
        }
        System.out.println("정답입니다. " + count + "회 만에 정답을 맞추셨습니다.");
    }

    public static void main(String[] args) {
//        Application3 a = new Application3();
//        a.problem1();
//        a.problem2();
    }
}
