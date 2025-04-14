package com.ohgiraffers.section01.method;

public class Application2 {
    /* 메소드 호출 구조 이해하기 2 */
    public static void main(String[] args) {
        System.out.println("파티 시작~ (main() start)");

        Application2 app2 = new Application2();
        app2.methodA();
        app2.methodC();
        app2.methodB();

        System.out.println("파티 끝~ (main() end)");
    }
    public void methodA(){
        System.out.println("동현님을 조심스럽게 초대합니다.");

        System.out.println("동현님이 조심스럽게 돌아갑니다.");
    }
    public void methodB() {
        System.out.println("민지님을 조심스럽게 초대합니다.");

        System.out.println("민지님이 조심스럽게 돌아갑니다.");
    }
    public void methodC() {
        System.out.println("유찬님을 조심스럽게 초대합니다.");

        System.out.println("유찬님이 조심스럽게 돌아갑니다.");
    }
}
