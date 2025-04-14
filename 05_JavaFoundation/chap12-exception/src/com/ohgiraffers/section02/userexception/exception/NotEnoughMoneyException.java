package com.ohgiraffers.section02.userexception.exception;

public class NotEnoughMoneyException extends Exception{

    public NotEnoughMoneyException() {}

    /** 문자열을 부모 생정자쪽으로 전달하며 초기화하는 생성자 */
    public NotEnoughMoneyException(String message)
    {

        super(message);
    }

}
