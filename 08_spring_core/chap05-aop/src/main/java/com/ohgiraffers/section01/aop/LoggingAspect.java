package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
/** @Aspect: pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션 */
@Component
public class LoggingAspect {

    /** @Pointcut: 여러 조인 포인트를 매치하기 위해 지정한 표현식
     * Service로 끝나는 모든 클래스의 모든 메서드 (매개변수가 0개 이상인 것들)을 모두 조인 포인트로 잡겠다는 의미 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){}

    /** JoinPoint: 포인트컷으로 패치한 실행 시점
     * 매치된 조인포인트에서 해야 할 일이 어드바이스이다.
     * 매개변수로 전달한 JoinPoint 객체는 현재 조인포인트의 자세한 정보에 엑세스할 수 있다. */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("Before joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() " + joinPoint.getSignature());

        if(joinPoint.getArgs().length > 0)
        {
            System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

    /** 포인트 컷을 동일한 클래스 내에서 사용하능 것이면 클래스명 생략 가능 */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint)
    {
        System.out.println("After joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() " + joinPoint.getSignature());

        if(joinPoint.getArgs().length > 0)
        {
            System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

    /** returning 속성은 리턴값으로 반환되는 애를 객체로 받는것이다.
     * 리턴값으로 받아올 객체의 매개변수 이름과 동일해야한다.
     * joinPoint는 반드시 첫번째 매개변수로 선언해야한다. */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result)
    {
        System.out.println("After Returning result: " + result);
        /** 리턴할 결과값을 가공해줄 수도 있다. */
        if (result != null && result instanceof Map)
        {
            ((Map<Long, MemberDTO>)result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }

    /** throwing 속성의 이름과 매개변수의 이름이 동일해야한다.
     * 예외가 발생한 예외의 내용을 Throwable 객체로 받아볼 수 있게 된다. */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception)
    {
        System.out.println("After Throwing exception " + exception);
    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());
        /** 원본 조인포인트를 실행한다. */
        Object result = joinPoint.proceed();
        System.out.println("Around After " + joinPoint.getSignature().getName());
        /** 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
        return result;
    }

}
