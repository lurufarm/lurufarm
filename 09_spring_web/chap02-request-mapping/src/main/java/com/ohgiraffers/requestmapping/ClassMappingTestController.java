package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 클래스 레벨에 @RequestMapping 어노테이션 사용 가능
 * URL 공통부분을 이용해 설정하면 매번 핸들러 메소드에 URL의 중복되는 내용을 작성하지 않아도 된다. */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registerOrder(Model model)
    {
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메서드 호출함");
        return "mappingResult";
    }

    /** 여러 개의 패턴 매핑 */
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDeleteOrder(Model model)
    {
        model.addAttribute("message", "POST 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메서드 호출함");
        return "mappingResult";
    }

    /** @PathVariable: 요청 Path로부터 변수를 받아올 수 있다.
     * path variable로 전달되는 {변수명}값은 반드시 매개변수명과 동일해야한다.
     * 만약 동일하지 않으면 @pathVariable("이름")을 설정해주어야 한다.
     */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo)
    {
        model.addAttribute("message", orderNo + "번 주문 상제 내용 조회용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    /** RequestMapping 어노테이션에 아무런 URL을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가 준비되지 않았을 때 해당 메소드 호출 */
    @RequestMapping
    public String otherRequest(Model model)
    {
        model.addAttribute("message", "order요청이긴 하지만 다른 기능은 아직 준비되지 않음");
        return "mappingResult";
    }

}
