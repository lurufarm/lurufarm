package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** HandlerInterceptor 인터페이스를 구현해서 작성 */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

//    @Autowired
    public StopWatchInterceptor(MenuService menuService)
    {
        this.menuService = menuService;
    }

    /** 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 메소드 호출함");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        // true 반환 시 '이 요청을 다음 단계로 넘겨라'는 의미, false는 '여기서 멈추겠다'는 의미
        return true;
    }

    /** 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 메소드 호출함");
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime"); // 위에 오브젝트로 들어가있기때문에 다시 꺼내올 때 형변환 필요

        modelAndView.addObject("interval", endTime - startTime);
    }

    /** 뷰가 렌더링된 이후 동작하는 메소드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 호출함");
        menuService.method();
    }
}
