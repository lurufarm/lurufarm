package com.ohgiraffers.section01.polymorphism;

public class Application {
    public static void main(String[] args) {

        /** Cat과 Tiger는 Animal 클래스를 상속받았다.
         * 따라서 Cat은 Cat 타입이기도 하면서 Animal 타입이기도 하며
         * Tiger는 Tiger 타입이기도 하면서 Animal 타입이기도 하다.
         */

        /** 부모 타입으로 자식 인스턴스 주소 값 참조가 가능하다. */
        Animal a1 = new Cat();
        Animal a2 = new Tiger();

        /** 하지만 반대로 Animal은 Tiger나 Cat이 아니다. */
//        Cat c = new Animal();
//        Tiger t = new Animal();

        /** 동적 바인딩: 컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가(정적 바인딩)
         * 런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩이 바뀌어 동작(동적 바인딩) */

        a1.cry();
        a2.cry();

        /** 현재 레퍼런스 변수 타입은 Animal이기 때문에 Cat과 Tiger가 가진 고유한 기능을 호출하지 못한다. */
//        a1.jump();
//        a2.bite();

        /** 타입 형변환
         * 객체별로 고유한 기능을 동작시키기 위해 레퍼런스 변수를 Cat과 Tiger로 형변환해야 한다. */
        System.out.println("클래스 형변환 확인");
        ((Cat)a1).jump();
        ((Tiger)a2).bite();

        /** 타입 형변환을 잘못 한 경우
         * 컴파일 에러는 발생하지 않지만 런타임 에러가 발생한다. java.lang.ClassCastException */
//        ((Tiger)a1).bite();

        /** 레퍼런스 변수가 참조하는 실제 인스턴스가 원하는 타입과 맞는지 비교하는 instanceof 연산자 */
        System.out.println("instanceof 연산자 확인");
        System.out.println("a1이 Cat타입인지 확인: " + (a1 instanceof Cat));
        System.out.println("a1이 Tiger타입인지 확인: " + (a1 instanceof Tiger));

        /** 상속받은 타입도 함께 가지고 있다. */
        System.out.println("a1이 Animal 타입인지 확인: " + (a1 instanceof Animal));
        System.out.println("a2이 Animal 타입인지 확인: " + (a2 instanceof Animal));

        /** 모든 클래스는 Object의 후손이다. */
        System.out.println("a1이 Object 타입인지 확인: " + (a1 instanceof Object));
        System.out.println("a2이 Object 타입인지 확인: " + (a2 instanceof Object));

        /** instanceof 연산자를 이용해서 해당 타입이 맞는 경우에만 클래스 형변환을 적용한다. */
        if(a1 instanceof Cat)
        {
            ((Cat)a1).jump();
        }
        if(a1 instanceof Tiger)
        {
            ((Tiger)a1).bite();
        }

        /** 클래스의 업캐스팅과 다운캐스팅
         * up-casting: 상위 타입으로 형변환(묵시적 형변환)
         * down-casting: 하위 타입으로 형변환(명시적 형변환)
         * */

        Animal animal1 = (Animal) new Cat();    // up-casting
        Animal animal2 = new Cat();             // up-casting 묵시적 형변환 가능

        Cat cat1 = (Cat)animal1;                // down-casting을 할 때에는 명시적 형변환만 가능
//        Cat cat2 = animal2;                     // down-casting 묵시적 형변환 불가


    }
}
