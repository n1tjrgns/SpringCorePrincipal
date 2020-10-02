package com.spring.principal;

import com.spring.principal.discount.FixDiscountPolicy;
import com.spring.principal.member.MemberService;
import com.spring.principal.member.MemberServiceImpl;
import com.spring.principal.member.MemoryMemberRepository;
import com.spring.principal.order.OrderService;
import com.spring.principal.order.OrderServiceImpl;

public class AppConfig {

    //생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
