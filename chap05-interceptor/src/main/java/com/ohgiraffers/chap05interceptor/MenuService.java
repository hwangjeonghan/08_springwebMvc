package com.ohgiraffers.chap05interceptor;


import org.springframework.stereotype.Service;

@Service
public class MenuService {

    public void method(){
        System.out.println("메서드 호출 확인");
    }
}
