package com.ohgiraffers.section06.staticKeyword;

public class StaticMethodTest {
    private int count;

    public void nonStaticMethod()
    {
        this.count++;
        System.out.println("nonStaticMethod 호출됨");
    }

    public static void staticMethod()
    {
        /** Static 메서드는 인스턴스를 생성하지 않고 사용하는 메서드이기 때문에 this에 주소가 담길 수 없다. */
//        this.count++;
        System.out.println("StaticMethod 호출됨");
    }
}
