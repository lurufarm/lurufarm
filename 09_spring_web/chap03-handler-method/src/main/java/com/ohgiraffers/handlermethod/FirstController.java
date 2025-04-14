package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@SessionAttributes("id")
@RequestMapping("/first/*")
public class FirstController {

    /** 핸들러 메서드의 반환 값을 void로 설정하면 요청 주소가 view의 이름이 된다.
     * => /first/modify 요청이 들어오면 /first/modify 뷰를 응답한다. */
    @GetMapping
    public void modify(){}

    /** @RequestParam 이용하여 요청 파라미터 전달 받기
     * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 매개변수 앞에 작성한다.
     * form 태그 안쪽에 있는 input 태그의 값들을 받아온다. (name 속성값과 매개변수 이름을 맞춰주어야 함)
     *
     * 파라미터로 꺼내는 값들은 기본적으로 String이다. */
    @PostMapping("modify")
    public String modifyMenuPrice(Model model,
                                  @RequestParam(name="modifyName", required = false) String modifyName,
                                  @RequestParam(defaultValue = "0") int modifyPrice)
    {
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) // Map을 쓸 때는 @RequestParam annotation 생략 불가
    {
        String modifyMenu = parameters.get("modifyNameAll");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPriceAll"));

        String message = "메뉴의 이름을 " +  modifyMenu + "(으)로, 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        System.out.println("message");
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search(){}

    /** @ModelAttribute
     * 커맨드객체: 리퀘스트를 통해 받은 값들을 토대로 객체를 생성하고, 그 객체에 값들을 바인딩해서 만들어진 객체
     * @ModelAttribute의 경우 커맨드객체를 생성하여 매개변수로 전달해준 뒤 해당 인스턴스를 model에 담는다.
     * @ModelAttribute("모델에담을key값")을 지정할 수 있으며, 지정하지 않으면 타입의 앞글자를 소문자로 한 네이밍 규칙을 따른다.
     * 폼에서 입력한 값을 다음 화면으로 바로 전달해야하는 경우에 유용하게 사용할 수 있다.
     * 어노테이션은 생략이 가능하지만 명시적으로 작성하는 것이 좋다. */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menuInfo") MenuDTO menu)
    {
        System.out.println(menu);
        return "first/searchResult";
    }

    @GetMapping("login")
    public void login(){}

    /** 통상적으로 로그인에 대한 정보같은 것들은 세션에 담긴다.
     * HttpSession을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id)
    {
        session.setAttribute("id", id);
        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session)
    {
        session.invalidate(); // 세션을 종료
        return "first/loginResult";
    }

    /** 클래스레벨에 @SessionAttributes 어노테이션을 이용하여 세션에 값을 담을 key 값을 설정해두면
     * Model 영역에 해당 key로 attribute가 추가되는 경우 세션에 자동 등록한다. */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id)
    {
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    /** SessionAttributes로 등록된 값은 session의 상태를 관리하는 SessionStatus의 setComplete() 메소드로 사용 만료시켜야 함 */
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus)
    {
        /** 현재 세션에 저장된 모든 정보를 제거 */
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("body")
    public void body(){}

    @PostMapping("body")
    public void bodyTest(@RequestBody String body,
                         @RequestHeader("content-type") String contentType,
                         @CookieValue(value="JSESSIONID") String sessionId) throws UnsupportedEncodingException {
        System.out.println(contentType);
        System.out.println(sessionId);
        System.out.println(body);
        System.out.println(URLDecoder.decode(body, "UTF-8"));
    }

}
