package com.spring.principal.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//어노테이션 활용방식
public class NetworkClient3 {

    private String url;

    public NetworkClient3(){
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message : " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        disconnect();
    }

    @PreDestroy
    public void close() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }
}
