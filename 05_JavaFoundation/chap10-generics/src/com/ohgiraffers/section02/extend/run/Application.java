package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {
        /** extends 키워드를 사용하여 특정 타입만 사용하도록 제네릭 범위를 제한할 수 있다. */

        /** Rabbit의 상위 타입이거나 관련 엇는 타입을 통해서는 인스턴스 생성 불가 */
//        RabbitFarm<Animal> farm = new RabbitFarm<>();
//        RabbitFarm><Mammal> farm2 = new RabbitFarm<Mammel>();
//        RabbitFarm><Snake> farm2 = new Rabbitfarm<Snake>();

        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();

//        farm4.setAnimal(new Snake());
        farm4.setAnimal(new Rabbit());
        farm4.getAnimal().cry();

        farm5.setAnimal(new Bunny());
        farm5.getAnimal().cry();

        farm6.setAnimal(new DrunkenBunny());
        farm6.getAnimal().cry();

    }
}
