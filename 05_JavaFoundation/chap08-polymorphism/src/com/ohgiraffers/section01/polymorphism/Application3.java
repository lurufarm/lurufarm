package com.ohgiraffers.section01.polymorphism;

public class Application3 {
    public static void main(String[] args) {

        /** 다형성을 적용하여 매개변수에 활용할 수 있다. */
        Animal animal1 = new Cat();
        Animal animal2 = new Tiger();

        Application3 app3 = new Application3();
        app3.feed(animal1);     // 동일한 타입이기 때문에 가능함
        app3.feed(animal2);

        Cat cat1 = new Cat();   // 실제 인스턴스가 Animal의 후손이냐가 중요함
        Tiger tiger1 = new Tiger();

        app3.feed(cat1);
        app3.feed(tiger1);

    }

    /** 다형성을 적용하지 않았다면, 호랑이에게 먹이를 주는 메소드, 고양이에게 먹이를 주는 메소드를 별도로 작성해야 한다.
     * 메소드의 매개변수를 상위 타입으로 선언해 놓으면, 여러 하위 타입의 인스턴스들이 모두 다 그 메소드로 공유해서 사용 가능 */
    public void feed(Animal animal)
    {
        animal.eat();
    }
}
