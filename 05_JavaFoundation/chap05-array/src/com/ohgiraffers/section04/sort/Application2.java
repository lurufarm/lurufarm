package com.ohgiraffers.section04.sort;
import java.util.Arrays;
public class Application2 {
    public static void main(String[] args) {
        /** 순차 정렬 알고리즘 */

        /** 오름차순 정렬
         *  배열의 첫 인덱스부터 마지막 전 인덱스까지 반복하는 반복문
         *  마지막 인덱스는 자연스럽게 정렬되므로 처리할 필요 없음
         */

        int[] arr = { 2, 5, 4, 6, 1, 3};

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(i + "번 인덱스 정렬 완료: " + Arrays.toString(arr));
        }
        System.out.println("정렬 완료: " + Arrays.toString(arr));

        // 부등호만 반대로 처리하면 내림차순 정렬이 된다.
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] < arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(i + "번 인덱스 정렬 완료: " + Arrays.toString(arr));
        }
        System.out.println("정렬 완료: " + Arrays.toString(arr));

    }
}
