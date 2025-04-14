package com.ohgiraffers.section02.extend;

public class WildCardFarm {
    /** 매개변수로 전달받는 토끼 농장을 구현할 때 사용할 타입 변수에 대해 제한할 수 있다. */

    /** 토끼 농장에 있는 토끼가 어떤 토끼던 상관 없음 */
    public void anyType(RabbitFarm<?> farm)
    {
        farm.getAnimal().cry();
    }
    /** 토끼 농장에 있는 토끼는 Bunny이거나 그 후손 타입의 토끼 */
    public void extendsType(RabbitFarm<? extends Bunny> farm)
    {
        farm.getAnimal().cry();
    }
    /** 토끼농장에 있는 토끼는 Bunny이거나 그 부모 타입의 토끼여야함 */
    public void superType(RabbitFarm<? super Bunny> farm)
    {
        farm.getAnimal().cry();

    }
}
