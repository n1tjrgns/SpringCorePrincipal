package com.spring.principal.discount;

import com.spring.principal.member.Grade;
import com.spring.principal.member.Member;

//정액 할인 정책
public class FixDiscountPolicy implements  DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum 타입은 == 으로 비교함
            return discountFixAmount;
        }
        return 0;
    }
}
