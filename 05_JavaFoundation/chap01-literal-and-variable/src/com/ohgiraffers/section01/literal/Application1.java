package com.ohgiraffers.section01.literal;

import java.sql.SQLOutput;

public class Application1 {
    public static void main(String[] args)
    {
        // 정수 형태의 값 출력
        System.out.println(123);

        // 실수 형태의 값 출력
        System.out.println(1.23);

        // 문자 형태의 값 출력, 홑따옴표로 감싸주어야 한다.
        System.out.println('a');
//        System.out.println('ab'); // 두 개 이상은 문자로 취급하지 않음. 문자열로 취급
//        System.out.println(''); // 아무 문자도 없는 경우도 에러 발생
        System.out.println('1'); // 숫자가 아니라 문자로 판단됨

        // 문자열 형태의 값 출력
        System.out.println("어쩍우"); // 문자열은 문자 여러개가 나열된 형태로, 쌍따옴표를 사용하여야 함
        System.out.println("1234");
        System.out.println(""); // 빈 문자열을 넣어도 에러가 나지 않음
        System.out.println("a");
    }
}
