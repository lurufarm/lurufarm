package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        /**
         * [깊은 복사(deep copy)]
         * 깊은 복사는 heap에 생성된 배열이 가진 값을 또 다른 배열에 복사하는 것.
         * 서로 같은 값을 가지고 있지만, heap 영역에 각각 다르게 생성된 배열이므로
         * 하나의 배열 값을 변경하더라도 다른 배열에 영향을 주지 않는다.
         *
         * [깊은 복사를 하는 방법 4가지]
         * 1. for문을 이용하여 동일한 인덱스의 값 복사
         * 2. Object의 clone()을 이용한 복사
         * 3. System의 arraycopy()를 이용한 복사
         * 4. Arrays의 copyOf()를 이용한 복사
         */

        int[] originArr = new int[] {2, 3, 5, 4};
        print("originArr", originArr);

        /** 1. for문을 이용하여 인덱스 값 복사 */
        int[] copyFor = new int[originArr.length];
        for (int i = 0; i < originArr.length; i++)
        {
            copyFor[i] = originArr[i];
        }
        print("copyFor", copyFor);

        /** 2. Object의 clone()을 이용한 복사 */
        int[] copyClone = originArr.clone();
        print("copyClone", copyClone);


        /** 3. System의 arraycopy()를 이용한 복사 */
        int[] copyArraycopy = new int[10];
        // System.arraycopy(원본배열, 복사를 시작할 인덱스, 복사본배열, 복사를 시작할 인덱스, 복사할 길이)
        System.arraycopy(originArr, 0, copyArraycopy, 3, originArr.length);
        print("copyArraycopy", copyArraycopy);

        /** 4. Arrays의 copyOf()를 이용한 복사 */
        // 원본배열의 시작 인덱스부터 원하는 길이만큼만 복사해서 사용 가능
        int[] copyCopyOf = Arrays.copyOf(originArr, 10);
        print("copyCopyOf", copyCopyOf);

        /** 깊은 복사한 배열을 바꿔본다. */
        int[] tempArr = { 0, 1, 2, 3 };
        for (int value : tempArr)
        {
            copyClone[value] = 5;
        }
        print("수정된 copyClone", copyClone);
        print("copyClone 수정 후 originArr", originArr);

        /**
         * [향상된 for문]
         * for(자료형 변수명B : 반복가능한 객체A)
         * {
         *      반복할 구문(반복가능한 객체 A의 길이만큼 반복한다.)
         * }
         * A에 들어있는 값을 변수명B로 순서대로 받아온다.
         */
        for(int value : tempArr)
        {
            copyClone[value] = 5;
        }
        /**
         * 위 향상된 for문을 통해 실행한 코드는 다음과 같다.
         * copyClone[0] = 5;
         * copyClone[1] = 5;
         * copyClone[2] = 5;
         * copyClone[3] = 5;
         */
    }

    public static void print(String name, int[] iarr)
    {
        /** 전달 받은 배열의 hashCode 출력 */
        System.out.println(name + "의 hashCode: " + iarr.hashCode());

        /** 전달 받은 배열의 값 출력 */
        for (int i = 0; i < iarr.length; i++)
        {
            System.out.print(iarr[i] + " ");
        }
        System.out.println();
    }
}
