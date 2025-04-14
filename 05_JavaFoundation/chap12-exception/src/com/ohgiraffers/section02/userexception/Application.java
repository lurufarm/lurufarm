package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application {
    public static void main(String[] args) {
        /** 사용자 정의의 예외 클래스 정의 후 발생한 사용자 정의의 예외를 처리할 수 있다. */

        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(50000, 30000);
        } catch (PriceNegativeException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());

        } catch (MoneyNegativeException e) {
            e.printStackTrace();

        } catch (NotEnoughMoneyException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally 블럭의 내용이 동작함.");
        }
        System.out.println("프로그램을 종료합니다.");

    }
}
