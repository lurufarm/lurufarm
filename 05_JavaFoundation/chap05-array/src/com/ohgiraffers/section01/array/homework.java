package com.ohgiraffers.section01.array;

import java.util.Arrays;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {

        problem1();
        problem2();
    }

    public static void problem1()
    {
        /* 홀수인 양의 정수를 입력 받아 입력 받은 크기 만큼의 정수형 배열을 할당하고
         * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
         * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력하세요
         *
         * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "양수 혹은 홀수만 입력해야 합니다."를 출력하세요
         *
         * -- 입력 예시 --
         * 홀수인 양의 정수를 입력하세요 : 7
         *
         * -- 출력 예시 --
         * 1 2 3 4 3 2 1
         *
         * -- 입력 예시 --
         * 홀수인 양의 정수를 입력하세요 : 8
         *
         * -- 출력 예시 --
         * 양수 혹은 홀수만 입력해야 합니다.
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하세요: ");
        int arrSize = sc.nextInt();

        if(arrSize / 2 == 1)
        {
            System.out.println("양수 혹은 홀수만 입력해야 합니다.");
            return;
        }


        int arr[] = new int[arrSize];
        int num = 1;
        for (int i = 0; i < arr.length; i++)
        {
            if (i < arr.length / 2)
                arr[i] = num++;
            else
                arr[i] = num--;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void problem2()
    {
        /* 숫자 야구게임 만들기
         * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
         * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
         * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
         * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
         *
         * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
         * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
         *
         * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
         * 횟수는 차감하지 않는다.
         *
         * -- 프로그램 예시 (난수 7416 의 경우) --
         *
         * 10회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 1234
         * 아쉽네요 0S 2B 입니다.
         * 9회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 5678
         * 아쉽네요 0S 2B 입니다.
         * 8회 남으셨습니다.
         * 4자리 숫자를 입력하세요 : 7416
         * 정답입니다.
         * */

        Scanner sc = new Scanner(System.in);
        String input;
        int arr[] = new int[4];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++)
            {
                if(arr[i] == arr[j])
                {
                    i--;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        int chance = 10;
        int s = 0;
        int b = 0;

        boolean isSame = false;

        while(chance > 0)
        {
            System.out.println(chance-- + "회 남으셨습니다.");
            System.out.print("4자리 숫자를 입력하세요: ");
            input = sc.nextLine();
            s = 0;
            b = 0;

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (i != j)
                    {
                        if (arr[i] == (input.charAt(j) - 48))
                            b++;
                    }
                    else
                    {
                        if (arr[i] == (input.charAt(j) - 48))
                        {
                            s++;
                            if (s == 4)
                            {
                                isSame = true;
                                System.out.println("정답입니다.");
                                return;
                            }
                        }
                    }
                }
            }
            System.out.println("아쉽네요. " + s + "S " + b + "B 입니다.");
        }
    }
}
