package com.ohgiraffers.section03.dto;

public class Application {
    /** 캡슐화의 원칙에서 일부 어긋나기는 하지만 다른 목적을 가진 클래스와 객체를 추상화하는 기법이 있다.
     * 행위 위주가 아닌, 데이터를 하나로 뭉치기 위한 객체(Data Transfer Object)의 경우이다.
     * 이러한 객체를 설계할 때는 행위가 아닌 데이터를 위주로 하며,
     * 캡슐화의 원칙을 준수하여 모든 필드를 private로 설정해 직접 접근을 막고,
     * 각 필드값을 변경하거나 반환하는 메소드를 세트로 미리 작성한다.
     * private 필드와 필드값을 수정하는 설정자(setter), 필드에 접근하는 접근자(getter)들로 구성된다.
     * 주로 계층간 데이터를 주고 받을 목적으로 사용한다.
     */
    public static void main(String[] args) {
        MemberDTO memberDTO = new MemberDTO();

        // 설정자를 이용하여 필드에 값 대입
        memberDTO.setNumber(1);
        memberDTO.setName("ㅇㅅㅇ");
        memberDTO.setGender('f');
        memberDTO.setAge(20);
        memberDTO.setHeight(198);
        memberDTO.setWeight(5.0);
        memberDTO.setActivated(true);

        // 접근자를 이용하여 필드에 값에 접근해 출력
        int myNumber = memberDTO.getNumber();
        System.out.println("회원번호: " + myNumber);
        System.out.println("회원이름: " + memberDTO.getName());
        System.out.println("회원나이: " + memberDTO.getAge());
        System.out.println("회원성별: " + memberDTO.getGender());
        System.out.println("회원키: " + memberDTO.getHeight());
        System.out.println("회원무게: " + memberDTO.getWeight());
        System.out.println("활성화여부: " + memberDTO.isActivated());
    }
}
