package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {
        /**
         * [선택 정렬]
         * 배열을 전부 탐색하여 최소값을 고르고 왼쪽부터 채워나가는 방식의 정렬
         * 데이터의 양이 적을 때 좋은 성능을 나타낸다(교환 횟수가 적음)
         * 배열을 전부 탐색하여 최소값을 찾아야 하기 때문에, 100개 이상의 자료에서는 급격하게 속도가 저하됨
         */

        int[] iarr = {2, 5, 4, 6, 1, 3};
        Arrays.sort(iarr);
        System.out.println("sort 메서드 사용: " + Arrays.toString(iarr));


        int min;    // 최소값을 가진 데이터의 인덱스 저장 변수
        int temp;   //

        for (int i = 0; i < iarr.length - 1; i++)
        {
            min = i;
            for (int j = i + 1; j < iarr.length; j++)
            {
                // i의 인덱스보다 작은 값이 있는 인덱스의 경우, min을 변경한다.
                if(iarr[min] > iarr[j])
                    min = j;
            }
            // 작은 값을 시작 인덱스와 교환한다.
            temp = iarr[min];
            iarr[min] = iarr[i];
            iarr[i] = temp;

            System.out.println(Arrays.toString(iarr));
        }
        System.out.println(Arrays.toString(iarr));
    }
}
