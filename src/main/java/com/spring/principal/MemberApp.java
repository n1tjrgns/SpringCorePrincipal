package com.spring.principal;

import com.spring.principal.member.Grade;
import com.spring.principal.member.Member;
import com.spring.principal.member.MemberService;
import com.spring.principal.member.MemberServiceImpl;

//순수 테스트 방법
public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
