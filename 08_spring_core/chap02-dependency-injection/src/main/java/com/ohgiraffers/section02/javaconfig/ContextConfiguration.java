package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator()
    {
        return new PersonalAccount(20, "110-234-56789");
    }

    @Bean
    public MemberDTO memberGenerator()
    {
        /** 생성자 주입
         * MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴값을 전달하여 bean 조립 */
//        return new MemberDTO(1,"코알라","010-1234-5678", "koala@gmail.com", accountGenerator());
        /** setter 주입
         * setter를 통해 Account를 생성하는 메소드를 호출한 리턴값을 전달하여 bean 조립 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("호랑이");
        member.setPhone("010-9876-5432");
        member.setEmail("tiger@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
