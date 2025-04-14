package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("other-controller-null")
    public String otherNullPointerExceptionTest()
    {
        String str = null;
        System.out.println(str.charAt(0)); // 의도적으로 NullPointerException 발생시키는중
        return "/";
    }

    @GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check)
        {
            throw new MemberRegistException("당신은 회원 자격이 없습니다.");
        }
        return "/";
    }


}
