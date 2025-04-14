package com.ohgiraffers.section01.array;

public class Application {
    public static void main(String[] args) {

        /**
         * 배열이란?
         * 동일한 자료형의 묶음(연속된 메모리 공간에 값을 저장하고 사용하기 위한 용도)
         * 배열은 heap 영역에 new 연산자를 이용하여 할당한다.
         */

        /** 하나의 이름으로 관리되는 연속된 메모리 공간이고, 공간마다 찾아갈 수 있는 번호(인덱스)를 이용해 접근한다. */

        /* 배열의 선언 및 할당 */
        int[] arr = new int[5];

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        for (int i = 0, value = 0; i < arr.length; i++) {
            arr[i] = value += 10;
        }
        int sum2 = 0;

        sum2 += arr[0];
        sum2 += arr[1];
        sum2 += arr[2];
        sum2 += arr[3];
        sum2 += arr[4];

        System.out.println("sum2: " + sum2);

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }

        System.out.println("sum: " + sum);

//        int[][][] array = new int[3][4][5];
//
//        for (int i = 0; i < array.length; i++) {
//
//            System.out.println("★ 첫 번째 i: " + (i + 1));
//
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.println("두 번째 j: " + (j + 1));
//                for (int k = 0; k < array[i][j].length; k++) {
//                    System.out.print("세 번째 k: " + (k + 1) + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
    }
}
