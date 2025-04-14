package com.ohgiraffers.section02.dimensional;

public class Application1 {
    public static void main(String[] args) {

        /**
         * [다차원 배열]
         * 다차원 배열은 2차원 이상의 배열을 의미하며, 배열의 인덱스마다 또 다른 배열의 주소를 보관하는 배열이다.
         * 즉, 2차원 배열은 1차원 배열 여러개를 하나로 묶어서 관리하는 배열이다.
         * 일반적으로 2차원 배열 이상의 배열은 사용 빈도가 현저히 적다.
         *
         * [2차원 배열을 사용하는 방법]
         * 1. 배열의 주소를 보관할 레퍼런스 변수 선언 (stack)
         * 2. 여러 개의 1차원 배열의 주소를 관리할 배열 생성 (heap)
         * 3. 2에서 생성한 배열의 각 인덱스에서 관리하는 배열을 할당(heap)하여 주소를 보관하는 배열
         *    (= 2에서 생성한 배열)에 저장
         * 4. 생성한 여러 개의 1차원 배열에 접근하여 사용
         */

        /** 배열의 주소를 보관할 레퍼런스 변수 선언 (stack) */

        int[][] iarr1;
        int iarr2[][];
        int[] iarr3[];

        /** 여러 개의 1차원 배열의 주소를 관리하는 배열 생성 (heap) */

//        iarr1 = new int[][]; // 크기를 지정하지 않으면 에러 발생
//        iarr1 = new int [][4]; // 주소를 묶어서 관리 할 배열의 크기를 지정하지 않으면 에러 발생
        iarr1 = new int[3][];

        /** 주소를 관리하는 배열의 인덱스마다 배열을 할당한다. (heap) */
        iarr1[0] = new int[3];
        iarr1[1] = new int[5];
        iarr1[2] = new int[7];

        /** 관리하는 여러 개의 배열의 길이가 동일한 경우는 아래와 같이 한 번에 할당할 수 있다.
         * 하지만 여러 개의 배열의 길이가 각각 다른 경우 위처럼 인덱스별로 배열을 따로 할당해주어야 한다.
         * 정변 배열: 서로 같은 길이의 여러 개 배열을 하나로 묶어 관리하는 2차원 배열
         * 가변 배열: 서로 길이가 같지 않은 여러 개의 배열을 하나로 묶어 관리하는 2차원 배열 */
        iarr2 = new int[3][5];

        /** 0번 인덱스 배열 값 출력 */
        for (int i = 0; i < iarr1[0].length; i++)
        {
            System.out.println(iarr1[0][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < iarr1[1].length; i++)
        {
            System.out.println(iarr1[1][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < iarr1[2].length; i++)
        {
            System.out.println(iarr1[2][i] + " ");
        }

        /** 중첩 for문을 이용해서 배열의 값 출력 */
        for (int i = 0; i < iarr1.length; i++)
        {
            /** 각 인덱스의 배열 값을 차례로 출력하는 반복문 */
            for (int j = 0; j < iarr1[i].length; j++)
            {
                System.out.print(iarr1[i][j] + " ");
            }
            System.out.println();
        }


    }
}
