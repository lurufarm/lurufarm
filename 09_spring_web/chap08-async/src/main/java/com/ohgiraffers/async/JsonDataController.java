package com.ohgiraffers.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class JsonDataController {

    private final List<UserDTO> userList;

    public JsonDataController()
    {
        userList = new ArrayList<>();
        userList.add(new UserDTO("1", "판다", 20, "panda@gmail.com", new Date()));
        userList.add(new UserDTO("2", "원숭이", 40, "monkey@gmail.com", new Date()));
        userList.add(new UserDTO("3", "코알라", 5, "koala@gmail.com", new Date()));
    }

    @GetMapping("/json-data")
    public String showJsonData()
    {
        return "async/json-data";
    }

    /** @RequestBody: 요청 바디에 담긴 데이터를 java 객체에 매핑할 때 사용하는 어노테이션
     * spring boot web 모듈에는 Jackson-databind 라이브러리가 기본 포함되어있어 JSON => Java Object 파싱이 자동 처리된다. */
    @PostMapping("/fetch/json")
    public @ResponseBody String fetchJsonTest(@RequestBody Map<String, String> requestBody)
    {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    @GetMapping("/fetch/json")
    public @ResponseBody List<UserDTO> fetchJsonTest()
    {
        return userList;
    }

}
