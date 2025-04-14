package com.ohgiraffers.section01.method;

public class Application1 {
        /* 메소드 호출 구조 이해하기 1 */
    public static void main(String[] args) {

        System.out.println("파티 시작~ (main() start)");
        /*
        * [메소드 호출 방법]
        * 클래스명 사용할이름 = new 클래스명();      // 객체 생성
        * 사용할이름.메소드명();                    // 메소드 호출
        * */
        Application1 app1 = new Application1();
        app1.methodA();

        System.out.println("파티 끝~! (main() end)");

    }
    public void methodA() {
        System.out.println("원숭이를 불렀어요~! (methodA() start)");

        methodB();

        System.out.println("원숭이가 집으로 돌아갔어요~! (methodA() end)");

    }

    public void methodB() {
        System.out.println("판다를 불렀어요~ (methodB() start)");

        methodC();

        System.out.println("판다가 집에 돌아갔어요~ (methodB() end)");
    }
    public void methodC() {
        System.out.println("다람쥐가 독산에서 왔어요~ (methodC() start)");

        System.out.println("다람쥐가 독산으로 터덜터덜 돌아갔어요~ (methodC() end)");
    }
}
