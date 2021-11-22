package com.example.inflearnpractice.controller;

import com.example.inflearnpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {


     private final MemberService memberService;


    /*@Autowired    setter 주입       누군가가 호출했을 때 public으로 열려있어야 함 즉 노출이 됨
    public setMemberController(MemberService memberService) {
        this.memberService = memberService;
    }*/


//     @Autowired private MemberService memberService;  field 주입

     @Autowired // service 를 가져다가 연결시켜줌, DI 생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}

