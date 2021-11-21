package com.example.inflearnpractice.service;

import com.example.inflearnpractice.domain.Member;
import com.example.inflearnpractice.repository.MemberRepository;
import com.example.inflearnpractice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberSercvice {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        // 중복검사
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> fineOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
