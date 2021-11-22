package com.example.inflearnpractice.controller;

import com.example.inflearnpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {


     private final MemberService memberService;


     @Autowired // service 를 가져다가 연결시켜줌, DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}

