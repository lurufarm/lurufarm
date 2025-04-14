package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {

    /**
     * [for문 표현식]
     * for (초기식; 조건식; 증감식)
     * {
     *     조건을 만족하는 경우 수행할 구문(= 반복할 구문);
     * }
     */

    public void simpleForStatement()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
        System.out.println("끝");
    }

    public void testForExample1()
    {
        Scanner sc = new Scanner(System.in);

//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu1 = sc.nextLine();
//        System.out.println(menu1 + "을 1순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu2 = sc.nextLine();
//        System.out.println(menu2 + "을 2순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu3 = sc.nextLine();
//        System.out.println(menu3 + "을 3순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu4 = sc.nextLine();
//        System.out.println(menu4 + "을 4순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu5 = sc.nextLine();
//        System.out.println(menu5 + "을 5순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu6 = sc.nextLine();
//        System.out.println(menu6 + "을 6순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu7 = sc.nextLine();
//        System.out.println(menu7 + "을 7순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu8 = sc.nextLine();
//        System.out.println(menu8 + "을 8순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu9 = sc.nextLine();
//        System.out.println(menu9 + "을 9순위로 먹고싶습니다.");
//
//        System.out.println("먹고싶은 메뉴를 입력하세요: ");
//        String menu10 = sc.nextLine();
//        System.out.println(menu10 + "을 10순위로 먹고싶습니다.");

        /**
         * <반복문으로 개선>
         * 1. 안내 문구 출력
         * 2. 메뉴 이름을 받아 변수에 저장
         * 3. 저장한 메뉴 이름을 출력
         */

        for(int i = 1; i <= 10; i++)
        {
            System.out.print("먹고 싶은 메뉴를 입력하세요: ");
            String menu = sc.nextLine();
            System.out.println(menu + "을(를) " + i + "순위로 먹고싶습니다.");
        }
        System.out.println("먹고싶은 메뉴가 너무 많아!! 뭐 먹지??");
    }

    public void testForExample2()
    {
        /**
         * [1부터 10까지 더해서 출력하기]
         * 1. 1부터 10까지의 정수를 변수에 저장한다.
         * 2. sum이라는 이름을 가진 int형 변수에 위에서 만든 변수의 값을 누산한다.
         * 3. 1부터 10까지 더한 결과를 출력한다.
         */

//        int num1 = 1;
//        int num2 = 2;
//        int num3 = 3;
//        int num4 = 4;
//        int num5 = 5;
//        int num6 = 6;
//        int num7 = 7;
//        int num8 = 8;
//        int num9 = 9;
//        int num10 = 10;
//
//        int sum = 0;
//        sum += num1;
//        sum += num2;
//        sum += num3;
//        sum += num4;
//        sum += num5;
//        sum += num6;
//        sum += num7;
//        sum += num8;
//        sum += num9;
//        sum += num10;
//
//        System.out.println(sum);

        /**
         * <반복할 내용>
         * 1. 변수에 1씩 증가하는 값 담기 (1~10)
         * 2. 저장된 값을 sum에 누산하기 => 반복횟수 10번
         *
         * <반복하지 않을 내용>
         * 1. sum 선언 및 초기화
         * 2. 출력하기
         */

        int sum = 0;
        for(int i = 1; i <= 10; i++)
        {
            int num = i;
            sum += num;
        }
        System.out.println(sum);
    }

    public void testForExample3()
    {
        /**
         * [1부터 난수까지 더해서 출력하기]
         * 1. 5~10사이의 난수를 발생시킨다.
         * 2. 1부터 위에서 발생시킨 난수까지의 합계를 구한다.
         * 3. 2에서 구한 합계를 출력한다.
         */

        int random = (int)(Math.random() * 6) + 5;
        int sum = 0;
//        if(random == 5)

//            System.out.println("5가 나옴");
//        else if (random == 6)
//            System.out.println("6이 나옴");
//        else if (random == 7)
//            System.out.println("7이 나옴");
//        else if (random == 8)
//            System.out.println("8이 나옴");
//        else if (random == 9)
//            System.out.println("9가 나옴");
//        else if (random == 10)
//            System.out.println("10이 나옴");

        for(int i = 1; i <= random; i++)
        {
            sum += i;
        }
        System.out.println("random값은 " + random + "이고, 1부터 random까지 더한 값은 " + sum + "입니다.");
    }

    public void testForExample4()
    {
        /**
         * [두 수의 합]
         * 1. Scanner를 이용하여 두 개의 정수를 입력받는다.
         *    (단, 두 숫자는 같은 숫자를 입력하지 않는다는 가정으로 진행한다.)
         * 2. 입력된 두 수 중, 작은 수부터 큰 수까지의 합계를 구한다.
         * 3. 2에서 구한 값을 출력한다.
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        if(num1 > num2)
        {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int sum = 0;

        for (int i = num1; i <= num2; i++)
        {
            sum += i;
        }
        System.out.println(num1 + "부터 " + num2 + "까지의 수의 합계는 " + sum + "입니다.");
    }
}
