package com.ohgiraffers.sessionsecurity.config;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import com.ohgiraffers.sessionsecurity.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    /** 비밀번호 암호화에 사용될 객체 Bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** 정적 리소스에 대한 요청은 제외하는 설정 */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    /** HTTP 요청에 대한 설정을 시큐리티필터체인에 설정 */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /** 요청에 대한 권한 체크 */
        http.authorizeHttpRequests(auth -> {
            // 누구나 접근 가능한 페이지 허용
            auth.requestMatchers("/auth/login", "/user/signup", "/auth/fail", "/", "/main").permitAll();
            // 어드민으로 시작되는 모든 요청들은 어드민만 접근 가능하도록 설정. 유저도 마찬가지
            auth.requestMatchers("/admin/*").hasAnyAuthority("ROLE_ADMIN");
            auth.requestMatchers("/user/*").hasAnyAuthority("ROLE_USER");
            // 그 외의 요청들은 인증(로그인)이 필요하다
            auth.anyRequest().authenticated();
        /** 로그인 설정 */
        }).formLogin(login -> {
            login.loginPage("/auth/login"); // 로그인 페이지는 어디로 할 것인지 정함
            login.usernameParameter("user");
            login.passwordParameter("pass");
            login.defaultSuccessUrl("/", true); // 로그인을 성공했을 때 어디로 갈것인지(랜딩페이지) 설정
            login.failureHandler(authFailHandler); // 로그인 실패 시 처리할 핸들러 지정
        /** 로그아웃 설정 */
        }).logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")); // 로그아웃 요청 url이 뭔지
            logout.deleteCookies("JSESSIONID"); // JSESSIONID 쿠키 삭제
            logout.invalidateHttpSession(true); // 세션을 만료시킨다(true)
            logout.logoutSuccessUrl("/"); // 로그아웃 시 어디로 갈것인지 (랜딩페이지) 설정

        }).sessionManagement(session -> {
            session.maximumSessions(1);
            session.invalidSessionUrl("/");
        /** CSRF 보호 비활성화 */
        }).csrf(csrf -> csrf.disable());

        return http.build();
    }

}
