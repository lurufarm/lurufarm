package com.ohgiraffers.section04.scanner;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 자료형별 값 입력받기
        // nextLine(): 문자열 입력받기(입력받은 값을 문자열로 반환)
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("입력한 이름은 " + name + " 입니다.");
        sc.nextLine();

        // nextInt(): 정수형 입력받기(입력받은 값을 int형으로 반환)
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("입력한 나이는 " + age + "입니다.");

        // nextLong(): 정수형 입력받기(입력받은 값을 long형으로 반환)
        System.out.print("희망하는 연봉을 입력하세요: ");
        long pay = sc.nextLong();
        System.out.println("입력하신 연봉은 " + pay + "입니다.");

        // nextFloat(): 실수형 입력받기(입력받은 값을 float형으로 반환)
        System.out.print("키를 입력하세요: ");
        float height = sc.nextFloat();
        System.out.println("입력하신 키는 " + height + "입니다.");

        // nextDouble(): 실수형 입력받기(입력받은 값을 double형으로 반환)
        System.out.print("키를 다시 입력하세요: ");
        double height2 = sc.nextDouble();
        System.out.println("다시 입력하신 키는 " + height2 + "입니다.");

        // nextBoolean(): 논리형 입력받기(true/false만 입력받을 수 있음)
        System.out.print("나는 부자다: ");
        boolean isRich = sc.nextBoolean();
        System.out.println("입력하신 논리값은 " + isRich + "입니다.");

        //문자형 값 입력받기
        System.out.print("좋아하는 알파벳을 입력하세요: ");
        char alphabet = sc.nextLine().charAt(0);
        System.out.println("입력한 알파벳은 " + alphabet + "입니다.");
    }
}
