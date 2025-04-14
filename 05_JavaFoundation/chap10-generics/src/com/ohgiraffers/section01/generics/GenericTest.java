package com.ohgiraffers.section01.generics;
/** 제네릭 선언은 클래스 선언부 마지막에 다이아몬드 연산자를 이용하여 작성한다.
 * 다이아몬드 연산자 내부에 작성하는 영문자는 관례상 대문자로 작성한다.
 * T는 타입 변수라고 부른다. 타입 변수를 자료형 대신 사용한다.
 * 가상으로 존재하는 타입으로 T가 아닌 다른 영문자를 사용해도 무방하다.
 * 여러 개의 타입 변수를 작성할 때는 ','를 이용하여 기술할 수 있다. */
public class GenericTest<T> {
    private T value;

    public void setValue(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

}
