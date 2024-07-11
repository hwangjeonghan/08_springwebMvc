package com.ohgiraffers.chap05interceptor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/*")
public class InterceptorTestController {

    @GetMapping("stopwatch")
    public String handlerMenthod() throws InterruptedException {
        System.out.println("핸들러 메서드  호출함 ....");
        Thread.sleep(1000);
        return "result";
    }
}
