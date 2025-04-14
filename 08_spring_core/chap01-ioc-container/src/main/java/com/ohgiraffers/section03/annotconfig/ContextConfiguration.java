package com.ohgiraffers.section03.annotconfig;

import org.springframework.context.annotation.ComponentScan;

/** basePackages로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록한다.
 * @Component 어노테이션이 작성된 클래스를 인식하여 bean으로 등록하고,
 * 특수 목적에 따라 세부 기능을 제공하는 @Controller, @Service, @Repository, @Configuration 등을 사용한다. */
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

}
