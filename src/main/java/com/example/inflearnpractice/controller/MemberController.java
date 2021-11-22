package com.example.inflearnpractice.controller;


import com.example.inflearnpractice.domain.Member;
import com.example.inflearnpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/members/new")
    private String createForm(){
         return "members/createMemberForm";
    }


    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";
    }

}

