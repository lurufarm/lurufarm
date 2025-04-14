package com.ohgiraffers.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleStringController {

    @GetMapping("/simple-string")
    public String showSimpleString()
    // 데이터를 전송한 뒤 새로고침 없이 fetch를 이용하여(비동기적으로 통신하여) 그 데이터를 화면에 보여주는 방법
    {
        return "async/simple-string";
    }

    @GetMapping("/fetch/simple-string")
    public @ResponseBody String fetchTest(@RequestParam String keyword)
    {
        return "서버로 전달 된 문자열은 " + keyword + " 입니다.";
    }

    @GetMapping("/axios/simple-string")
    public @ResponseBody String axiosTest(@RequestParam String keyword)
    {
        return "서버로 전달 된 문자열은 " + keyword + " 입니다.";
    }

}
