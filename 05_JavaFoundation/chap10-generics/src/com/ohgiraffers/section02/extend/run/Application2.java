package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    public static void main(String[] args) {
        /** 와일드카드
         * 제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입 변수를 제한할 수 있다.
         * <?>: 제한 없음
         * <? extends Type>: 와일드카드의 상한 제한(Type과 Type의 후손을 이용해 생성한 인스턴스만 인자로 사용 가능)
         * <? super Type>: 와일드카드의 하한 제한(Type과 Type의 부모를 이용해 생성한 인스턴스만 인자로 사용 가능)
         */

        WildCardFarm wildCardFarm = new WildCardFarm();


        /** 1. 매개변수의 타입제한이 없는 경우 => 어떤 토끼를 가진 토끼 농장이던 인자로 전달 가능 */
        wildCardFarm.anyType(new RabbitFarm<>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<>(new DrunkenBunny()));

        /** 2. 매개변수의 타입이 버니이거나 버니 후손 토끼를 가진 토끼 농장만 인자로 전달 가능 */
        wildCardFarm.extendsType(new RabbitFarm<>(new Bunny()));
        wildCardFarm.extendsType(new RabbitFarm<>(new DrunkenBunny()));
//        wildCardFarm.extendsType(new RabbitFarm<>(new Rabbit()));

        /** 3. 매개변수 타입이 버니이거나 버니 상위 타입의 토끼를 가진 토끼 농장만 인자로 전달 가능 */
        wildCardFarm.superType(new RabbitFarm<>(new Rabbit()));
        wildCardFarm.superType(new RabbitFarm<>(new Bunny()));
        wildCardFarm.superType(new RabbitFarm<>(new DrunkenBunny()));

    }
}
