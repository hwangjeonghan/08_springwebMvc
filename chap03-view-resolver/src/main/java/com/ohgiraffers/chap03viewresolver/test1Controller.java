package com.ohgiraffers.chap03viewresolver;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class test1Controller {

    @GetMapping("2nd")
    public String test1(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함..");
        return "input";
    }
    @GetMapping("3nd")
    public String test2(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함..");
        return "select";
    }
}