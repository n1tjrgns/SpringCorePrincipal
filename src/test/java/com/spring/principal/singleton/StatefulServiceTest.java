package com.spring.principal.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        //멀티쓰레드 환경에서 동시성 처리를 해주지 않았을 경우 생기는 문제
        //현재 이 price는 싱글톤으로 관리되므로 공유되고 있다.

        //ThreadA: a사용자 10000원 주문
        bean1.order("userA", 10000);
        //ThreadB: b사용자 20000원 주문
        bean2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
        int price = bean1.getPrice();
        System.out.println("price = " + price);

        org.assertj.core.api.Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}