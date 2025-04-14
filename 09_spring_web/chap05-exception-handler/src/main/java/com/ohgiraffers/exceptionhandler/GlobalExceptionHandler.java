package com.ohgiraffers.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/** @ControllerAdvice 어노테이션 적용된 클래스의 @ExceptionHandler는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class) // 속성으로 핸들링할 대상 익셉션 클래스의 메타데이터를 넣는다.
    public String nullPointerExceptionHandler(NullPointerException exception)
    {
        System.out.println("message: " + exception.getMessage());
        System.out.println("global 레벨의 exception 처리");

        return "error/nullPointer"; // 이 에러가 발생했을 때 반환해줄 페이지
    }

    /** 상위 타입인 Exception을 통해 Handler를 작성하면 하위 타입의 모든 Exception을 처리할 수 있다. */
    @ExceptionHandler(Exception.class)
    public String defaultException(Exception exception)
    {
        return "error/default";
    }

}
