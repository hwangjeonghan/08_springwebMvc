package com.ohgiraffers.webpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class PracticeController {


    @GetMapping("/mession1")
    public ModelAndView mession1(ModelAndView mv, @RequestParam("pathValue") String value){
        mv.addObject("message", value);
        mv.setViewName("mession1");
        return mv;
    }
}
