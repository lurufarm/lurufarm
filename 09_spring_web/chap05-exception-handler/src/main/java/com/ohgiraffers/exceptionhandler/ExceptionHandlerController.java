package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest()
    {
        String str = null;
        System.out.println(str.charAt(0)); // 의도적으로 NullPointerException 발생시키는중
        return "/";
    }

    @ExceptionHandler(NullPointerException.class) // 속성으로 핸들링할 대상 익셉션 클래스의 메타데이터를 넣는다.
    public String nullPointerExceptionHandler(NullPointerException exception)
    {
        System.out.println("message: " + exception.getMessage());
        System.out.println("controller 레벨의 exception 처리");

        return "error/nullPointer"; // 이 에러가 발생했을 때 반환해줄 페이지
    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check)
        {
            throw new MemberRegistException("당신은 회원 자격이 없습니다.");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model, MemberRegistException exception)
    {
        model.addAttribute("exception", exception);
        return "error/memberRegist";
    }
}
