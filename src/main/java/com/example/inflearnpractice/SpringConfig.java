package com.example.inflearnpractice;


import com.example.inflearnpractice.repository.MemberRepository;
import com.example.inflearnpractice.repository.MemoryMemberRepository;
import com.example.inflearnpractice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();

    }



}


