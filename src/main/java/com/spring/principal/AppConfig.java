package com.spring.principal;

import com.spring.principal.discount.DiscountPolicy;
import com.spring.principal.discount.FixDiscountPolicy;
import com.spring.principal.member.MemberRepository;
import com.spring.principal.member.MemberService;
import com.spring.principal.member.MemberServiceImpl;
import com.spring.principal.member.MemoryMemberRepository;
import com.spring.principal.order.OrderService;
import com.spring.principal.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}