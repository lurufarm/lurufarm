package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {
    public void testPrimaryTypeParameter(int num)
    {
        System.out.println("매개변수로 전달받은 값: " + num);
        num += 10;
        System.out.println("가공된 값: " + num);
    }

    public void testPrimaryTypeArrayParemeter(int[] iarr)
    {
        System.out.println("매개변수로 전달받은 값: " + Arrays.toString(iarr));
        iarr[0] = 99;
        System.out.println("가공된 iarr: " + Arrays.toString(iarr));
    }

    public void testClassTypeParameter(Rectangle r)
    {
        System.out.println("매개변수로 전달받은 넓이와 둘레");
        r.calcArea();
        r.calcRound();

        r.setHeight(100);
        r.setWidth(100);

        System.out.println("가공 후 넓이와 둘레");
        r.calcArea();
        r.calcRound();
    }

    // 매개변수에 가변인자를 넣으려면 가변인자는 매개변수 맨 뒤에 위치해야 한다.
    public void testVariableLengthArrayParameter(String name, String... hobby)
    {
        System.out.println("이름: " + name);
        System.out.println("취미: " + Arrays.toString(hobby));
        System.out.println("취미의 갯수: " + hobby.length);
    }

    /** 가변인자를 사용한 메소드를 오버로딩하면 모호해지는 문제가 발생할 수 있으므로, 가급적 오버로딩하지 않는다. */

//    public void testVariableLengthArrayParameter(String... hobby) {}

}
