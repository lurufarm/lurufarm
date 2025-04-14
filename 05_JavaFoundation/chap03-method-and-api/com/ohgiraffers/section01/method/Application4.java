package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {
        /*
        * [return]
        * 모든 메소드 내부에는 return;이 존재한다.
        * void 메소드는 return;을 명시적으로 작성하지 않아도 마지막줄에 컴파일러가 자동으로 추가해준다.
        * return은 현재 메소드를 강제 종료하고 호출한 구문으로 다시 돌아가라는 명령어이다.
        *
        * 복귀를 할 때 그냥 복귀할 수도 있지만, 값을 가지고 복귀할 수도 있다.
        * 이때 가지고 가는 값을 리턴값이라고 한다.
        * return 값을 반환받기 위해서는 메소드 선언부에 반환타입을 명시해 주어야 한다.
        * 또한 메소드 선언부에 선언한 리턴타입과 반환값의 자료형은 반드시 일치해야 한다.
        * */
        System.out.println("판다가 책을 읽기 시작합니다.");

        Application4 app4 = new Application4();
//        app4.testMethod();

        app4.testMethod2();

        String returnText = app4.testMethod2();
        System.out.println(returnText);

        System.out.println(app4.testMethod2());

        System.out.println("판다가 책을 덮고 잠에 듭니다...Zzz");
    }

    public void testMethod() {
        /*
        * return;은 컴파일러에 의해 자동으로 추가되는 구문이다.
        * 가장 마지막에 작성해야 하고, 마지막에 작성되지 않으면 에러를 발생시킨다.
        * */
        System.out.println("책을 열심히 읽는... 것처럼 보이는데..");
//        return;
//        System.out.println("책을 정말 열심히 읽고 있군요!");
    }
    public String testMethod2(){
        return "독후감 +1 (wow!)";
    }
}
