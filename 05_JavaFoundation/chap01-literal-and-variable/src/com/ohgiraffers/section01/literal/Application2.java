package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args) {


        /* 값을 직접 연산하여 출력할 수 있다.
         * 이 때 값의 형태에 따라 사용할 수 있는 연산자의 종류와 연산의 결과가 달라진다. */

        System.out.println("정수와 정수의 연산");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(120 % 10);

        System.out.println("실수와 실수의 연산");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 % 1.0);

        System.out.println("정수와 실수의 연산");
        System.out.println(123 + 0.5);
        System.out.println(123 % 0.5);

        // 문자의 연산
        System.out.println("문자와 문자의 연산");
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        // 문자와 정수의 연산
        // 컴퓨터는 문자를 인식하지 못하고 숫자로만 인식할 수 있기 때문에
        // 모든 문자에 대응되는 숫자들이 매칭되어있다. (아스키코드와 유니코드)
        System.out.println("문자와 정수의 연산");
        System.out.println('a' + 1);
        System.out.println('a' - 1);

        // 문자와 실수의 연산
        System.out.println("문자와 실수의 연산");
        System.out.println('a' + 1.0);
        System.out.println('a' % 2.0);

        // 문자열의 연산
        // + 연산결과는 문자열 합치기(이어 붙이기)가 된다.
        // + 연산 외에 다른 연산을 사용하지 못한다.
        System.out.println("문자열과 문자열의 연산");
        System.out.println("hello" + "world"); // 문자열 이어붙이기
//        System.out.println("hello" - "world"); // 에러 발생
//        System.out.println("hello" * "world"); // 에러 발생

        // 문자열과 다른 형태의 값 연산
        // 문자열과의 연산은 + 연산만 가능
        // 다른 형태의 값들도 문자열로 취급하여 문자열 이어붙이기 결과가 나온다.
        System.out.println("문자열과 다른 형태의 값의 연산");
        System.out.println("helloworld" + 123);
        System.out.println("helloworld" + 'a');
        System.out.println("helloworld" + true);
        
        // 논리값의 연산
        // 논리값은 문자열 합치기 말고는 안됨
//        System.out.println(true + false);
//        System.out.println(true - 1);
//        System.out.println(false * 0.1);
        System.out.println(true + "as");
    }
}
