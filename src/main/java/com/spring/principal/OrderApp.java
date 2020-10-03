package com.spring.principal;

import com.spring.principal.member.Grade;
import com.spring.principal.member.Member;
import com.spring.principal.member.MemberService;
import com.spring.principal.member.MemberServiceImpl;
import com.spring.principal.order.Order;
import com.spring.principal.order.OrderService;
import com.spring.principal.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //toString을 오버라이딩 해놨기떄문에 order를 출력하면 원하는 재정의 해놓은대로 값이 출력된다.
        System.out.println("order : "+ order);
        System.out.println("order.calculate : "+ order.calculatePrice());
    }
}
