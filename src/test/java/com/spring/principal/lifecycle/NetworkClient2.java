package com.spring.principal.lifecycle;

//메소드 활용방식
public class NetworkClient2  {

    private String url;

    public NetworkClient2(){
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

    public void init() throws Exception {
        disconnect();
    }

    public void close() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }
}
