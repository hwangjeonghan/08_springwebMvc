package com.ohgiraffers.webpractice.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ApiController {
    @GetMapping("/test")
    public ResponseEntity test(Map<String, String> test){

        if(test == null){
            return ResponseEntity.status(404).body("데이터가 없습니다.");
        }
        boolean result = false;
        if(result){
            return ResponseEntity.status(500).body("서버 오류가 발생하였습니다.");
        }

        ResponseEntity.ok("성공")
        return ResponseEntity.status(200).body("성공");
    }
}
