package com.ohgiraffers.section01.polymorphism;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        /** 다형성을 적용하여 객체 배열을 만들어 인스턴스를 연속 처리할 수 있다. */
        Animal[] animals = new Animal[5];
        animals[0] = new Cat();
        animals[1] = new Tiger();
        animals[2] = new Cat();
        animals[3] = new Tiger();
        animals[4] = new Cat();

        /** Animal 클래스가 가지는 메소드를 오버라이딩한 메소드가 호출된다 - 동적 바인딩 */
        for (int i = 0; i < animals.length; i++)
        {
            animals[i].cry();
        }

        /** 각 타입별 고유한 메소드를 동작시키기 위해서는 다운 캐스팅이 명시적으로 필요하다.
         * CalssCastException을 방지하기 위해 instanceof 연산자를 활용한다. */
        for (int i = 0; i < animals.length; i++)
        {
            if(animals[i] instanceof Cat)
            {
                ((Cat) animals[i]).jump();
            }
            else if (animals[i] instanceof Tiger)
            {
                ((Tiger)animals[i]).bite();
            }
            else
                System.out.println("고양이나 호랑이가 아닙니다.");
        }
    }
}
