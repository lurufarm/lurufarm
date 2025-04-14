package com.ohgiraffers.section01.method;

public class Application7 {
    public static void main(String[] args) {

        int first = 100;
        int second = 77;

        /* non-static method */
        Calculator calc = new Calculator();
        int minNum = calc.minNumberOf(first, second);

        System.out.println("최소값 : " + minNum);

        /* static method */
        int maxNum = Calculator.maxNumberOf(first, second);
//        int maxNum2 = maxNumberOf(first, second);

        System.out.println("최대값 : " + maxNum);

        /* static 메서드도 non-static 메서드처럼 객체를 통한 호출은 가능하지만, 권장하지 않는다. */
        int maxNum2 = calc.maxNumberOf(first, second);

    }
}
