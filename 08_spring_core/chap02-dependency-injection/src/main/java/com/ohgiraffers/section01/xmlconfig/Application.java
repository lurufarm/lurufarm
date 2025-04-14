package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        MemberDTO memberDTO = context.getBean(MemberDTO.class);
        System.out.println(memberDTO.getPersonalAccount());
        System.out.println(memberDTO.getPersonalAccount().deposit(10000));
        System.out.println(memberDTO.getPersonalAccount().getBalance());
        System.out.println(memberDTO.getPersonalAccount().withDraw(5000));
        System.out.println(memberDTO.getPersonalAccount().getBalance());
    }
}
