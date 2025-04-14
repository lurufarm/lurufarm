package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        /** 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */

        /** 1. 기본 생성자 호출 */
        User user = new User();
        System.out.println(user.getInformation());

        /** 2. 매개변수 생성자 호출 */
        User user1 = new User("user01", "pass01", "panda");
        System.out.println(user1.getInformation());

        /** 3. 모든 필드를 초기화하는 매개변수 생성자 호출 */
        /** java.util.Date 클래스의 기본 생성자를 통해 객체를 생성하면
         * 현재 프로그램이 동작하는 운영체제 상의 날짜/시간 정보를 이용해 인스턴스가 생성된다. */
        User user2 = new User("user02", "pass02", "판다", new Date());
        System.out.println(user2.getInformation());


    }
}
