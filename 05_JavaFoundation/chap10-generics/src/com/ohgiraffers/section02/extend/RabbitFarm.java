package com.ohgiraffers.section02.extend;
/** Rabbit을 상속받는 타입만 가등하도록 제한을 줌 */

public class RabbitFarm<T extends Rabbit> {
    public T animal;
    public RabbitFarm() {}
    public RabbitFarm(T animal)
    {
        this.animal = animal;
    }

    public void setAnimal(T animal)
    {
        this.animal = animal;
    }
    public T getAnimal()
    {
        return this.animal;
    }
}
