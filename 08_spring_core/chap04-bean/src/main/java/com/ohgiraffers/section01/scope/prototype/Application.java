package com.ohgiraffers.section01.scope.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();

        for (String beanName : beanNames)
            System.out.println("beanName: " + beanName);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /** 첫 번째 손님이 쇼핑 카트를 꺼내서 붕어빵과 우유를 담는다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1: " + cart1.getItems());

        /** 두 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2: " + cart2.getItems());

        System.out.println("cart1의 hashCode: " + cart1.hashCode());
        System.out.println("cart2의 hashCode: " + cart2.hashCode());

        /** singleton 스코프에서 prototype 스코프로 변경하면 매번 다른 객체의 cart를 반환하므로
         * 손님 두 명이 각각 쇼핑 카트를 이용해 상품을 담을 수 있다. */

    }
}
