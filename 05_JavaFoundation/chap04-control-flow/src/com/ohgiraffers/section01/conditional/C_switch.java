package com.ohgiraffers.section01.conditional;

import java.sql.SQLOutput;
import java.util.Scanner;

public class C_switch {

    /**
     * [switch문 표현식]
     * switch(비교할 변수)
     * {
     *     case 비교값 1: 비교할 변수의 값 == 비교값 1인 경우 실행할 구문;
     *     break;
     *     case 비교값 2: 비교할 변수의 값 == 비교값 2인 경우 실행할 구문;
     *     break;
     *     default: 위 case에 모두 해당되지 않는 경우 실행할 구문;
     *     break;
     * }
     */

    public void simpleSwitchStatement()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 입력: ");
        int firstNum = sc.nextInt();
        System.out.print("두 번째 정수 입력: ");
        int secondNum = sc.nextInt();
        System.out.println("연산 기호 입력 ( + - * / % ): ");
        char operator = sc.next().charAt(0);

        int result = 0;

        switch(operator)
        {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                result = firstNum / secondNum;
                break;
            case '%':
                result = firstNum % secondNum;
                break;
            default:
                System.out.println("잘못된 연산자를 입력하였습니다.");
                break;
        }

        System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
    }

    public void switchVendingMachine()
    {
        /**
         * <switch-case문 이용 실습>
         * 1. Scanner를 이용해 음료 이름(String)과 갯수(int)를 입력받는다.
         * 2. switch-case문을 사용해 전체 가격을 구한다.
         * 3. ['음료이름'을 '개수'개 선택하셨습니다.' '가격'을 투입해주세요.]
         *    위와 같이 출력되도록 한다.
         */

        Scanner sc = new Scanner(System.in);

        System.out.println(" ===== Pandas Vending Machine ===== ");
        System.out.println(" 코카콜라   칠성사이다   피크닉   핫식스");
        /* 코카콜라 1,700원 / 칠성사이다 1,500원 / 피크닉 1,000원 / 핫식스 2,100원 */
        System.out.println(" ================================== ");

        System.out.print("음료의 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("음료의 개수를 입력하세요: ");
        int num = sc.nextInt();
        int price = 0;
        switch(name)
        {
            case "코카콜라":
                price = num * 1700;
                break;
            case "칠성사이다":
                price = num * 1500;
                break;
            case "피크닉":
                price = num * 1000;
                break;
            case "핫식스":
                price = num * 2100;
                break;
            default:
                System.out.println("음료 입력이 잘못되었습니다!");
                return;
        }

        System.out.println("[" + name + "을(를) " + num + "개 선택하셨습니다. " + price + "원을 투입해주세요.]" );

    }
}
