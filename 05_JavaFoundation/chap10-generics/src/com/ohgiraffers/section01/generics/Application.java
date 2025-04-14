package com.ohgiraffers.section01.generics;

public class Application {
    public static void main(String[] args) {
        /** 제네릭의 사전적인 의미는 일반적인 이라는 뜻이다.
         * 자바에서 제네릭은 데이터 타입을 일반화한다는 의미를 가진다. */

        /** 제네릭 클래스로 인스턴스를 생성 시, 타입변수 자리에 사용하려는 타입을 명시한다.
         * 타입을 Integer로 인스턴스를 생성 */
        GenericTest<Integer> gt = new GenericTest<>();

        gt.setValue(10);
        System.out.println(gt.getValue());
        System.out.println(gt.getValue() instanceof Integer);

        /** 타입을 String으로 인스턴스 생성 */
        GenericTest<String> gt2 = new GenericTest<>();

        gt2.setValue("고양이");
        System.out.println(gt2.getValue());
        System.out.println(gt2.getValue() instanceof String);
    }
}
