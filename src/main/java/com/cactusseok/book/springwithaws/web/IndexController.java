package com.cactusseok.book.springwithaws.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}

/*
index를 반환하므로 View Resolver가 처리
 */