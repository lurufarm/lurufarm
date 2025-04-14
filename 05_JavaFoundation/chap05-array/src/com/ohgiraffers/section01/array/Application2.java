package com.ohgiraffers.section01.array;

public class Application2 {
    public static void main(String[] args) {
        /**
         * [배열의 사용 방법]
         * 1. 배열의 선언
         * 2. 배열의 할당
         * 3. 배열의 인덱스 공간에 값 대입
         *
         * [배열의 선언]
         * 자료형[] 배열명;
         * 자료형 배열명[];
         */

        // 선언은 stack 영역에 배열의 주소를 보관할 수 있는 공간을 만드는 것이다.


        int[] iarr;
        char carr[];

        /**
         * 선언한 레페런스 변수에 배열을 할당하여 대입할 수 있다.
         * new 연산자는 heap영역에 공간을 할당하고 발생한 주소값을 반환하는 연산자이다.
         * 발생한 주소를 레퍼런스 변수(참조형 변수)에 저장하고 이것을 참조하여 사용하기 때문에, '참조 자료형'이라고 한다.
         */

//        iarr = new int[]; // 현재 크기를 지정해주지 않아서 에러 발생
        iarr = new int[5];
        carr = new char[10];

        /** 배열 선언과 동시에 할당. */
        int[] iarr2 = new int[5];
        char carr2[] = new char[10];

        /** 배열 선언 + 동시 할당 + 동시 초기화 */
        int[] iarr3 = new int[] { 11, 22, 33, 44, 55 };
        for (int i = 0; i < iarr3.length; i++)
        {
            System.out.println(iarr3[i]);
        }

        int[] iarr4 = { 111, 222, 333, 444, 555 };
        for (int i = 0; i < iarr4.length; i++)
        {
            System.out.println(iarr4[i]);
        }

        /** String(참조자료형)도 배열로 만들 수 있다. */
        String[] sarr = { "red", "orange", "yellow", "green" };

        for (int i = 0; i < sarr.length; i++)
        {
            System.out.println(sarr[i]);
        }

        /** 배열의 주소값 */
        System.out.println(iarr); // 16진수의 배열 주소값

        /** hashCode : 일반적으로 객체의 주소값을 10진수로 변환하여 생성한 객체의 고유한 정수값을 반환 */
        System.out.println("iarr의 hashCode(): " + iarr.hashCode());

        /** 배열의 길이 */
        System.out.println("iarr의 길이: " + iarr.length);

        /** 배열의 한계점 : 길이 변경이 불가능 */
        double[] darr = new double[10];
        System.out.println("darr의 길이: " + darr.length);
        System.out.println("darr의 hashCode: " + darr.hashCode());

        darr = new double[100];
        System.out.println("darr의 길이: " + darr.length);
        System.out.println("darr의 hashCode: " + darr.hashCode());

        darr = null;
        /** 아무것도 참조하지 않고 null이라는 특수한 값을 참조하고 있는 경우, 참조 연산자를 사용하게 될 때 발생하는 에러 */
//        System.out.println("삭제 후 darr의 길이: " + darr.length); // NullPointerException 발생

        /** 초기값 확인
         * < 값의 형태별 기본값>
         *  정수: 0
         *  실수: 0.0
         *  논리: false
         *  문자형: \u0000
         *  참조: null
         */

        System.out.println(iarr[0]);
        System.out.println(iarr[1]);
        System.out.println(iarr[2]);
        System.out.println(iarr[3]);
        System.out.println(iarr[4]);

        for (int i = 0; i < iarr.length; i++)
        {
            System.out.println(iarr[i]);
        }

        iarr[0] = 1;
        iarr[1] = 2;
        iarr[2] = 3;
        iarr[3] = 4;
        iarr[4] = 5;

        for (int i = 0; i < iarr.length; i++)
        {
            iarr[i] = i + 1;
            System.out.println(iarr[i]);
        }
    }
}
