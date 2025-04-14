package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /*
        * [변수의 종류]
        * 1. 지역변수
        * 2. 매개변수
        * 3. 전역변수 (필드)
        * 4. 클래스(static) 변수
        *
        * 지역변수는 선언한 메소드 블럭 내부에서만 사용이 가능하다. 이것을 지역변수의 스코프라고 한다.
        * 서로 다른 메소드 간 공유해야 하는 값이 존재하는 경우, 메소드 호출 시 사용하는 괄호를 이용해 값을 전달할 수 있다.
        * 이때 전달하는 값을 전달인자(argument)라고 부르고,
        * 메소드 선언부 괄호 안에 전달인자를 받기 위해 선언하는 변수를 매개변수(parameter)라고 부른다.
        * */

        /* 전달인자로 값 전달하기 */
        Application3 app3 = new Application3();
        /* 호출하려는 메소드의 매개변수 선언부에 미리 선언해둔 자료형, 갯수, 순서가 일치하도록 값을 넣어서 호출 */
        app3.testMethod(100);
//        app3.testMethod("200");
//        app3.testMethod(100, 200, 300);
//        app3.testMethod();

        int bamboo = 100;
        app3.testMethod(bamboo);

        /* 자동형변환을 이용하여 값 전달 */
        byte byteBamboo = 15;
        app3.testMethod(byteBamboo);

        /* 강제형변환을 이용하여 값 전달 */
        long longBamboo = 1000;
        app3.testMethod((int)longBamboo);

        /* 연산 결과를 이용해서 값 전달 */
        app3.testMethod(bamboo * 3);

        /* 여러 개의 매개변수를 가진 메소드 호출(순서에 주의) */
        app3.testMethod2("권은지", 200, 'O');
//        app3.testMethod2(200, 'O', "권은지");

        /* 변수에 저장된 값을 전달하며 호출할 수 있다.*/
        String myName = "권은지";
        int myHeight = 200;
        char myBloodType = 'O';
        app3.testMethod2(myName, myHeight, myBloodType);
    }

    public void testMethod(int bamboo) {
        System.out.println("내가 가진 대나무는 " + bamboo + "개야~! 와~!!");
    }

    public void testMethod2(String name, int height, final char blood) {
        /*
        * 매개변수도 일종의 지역변수로 분류된다.
        * 따라서 매개변수 역시 final 키워드를 사용할 수 있다.
        * 지역변수에 final 키워드를 붙여 상수를 만드는 것과 동일하다.
        * final 매개변수는 상수 네이밍 규칙을 선택적으로 따르는 경향이 있다.
        * */
        name = "박현욱";
        height = 189;
//        blood = 'A';

        System.out.println("나는 판다 " + name + "이다! 나는 키가 " + height + "cm야! 그리고 나는 " + blood + "형이란다!");
    }
}
