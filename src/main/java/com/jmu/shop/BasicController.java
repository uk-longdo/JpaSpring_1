package com.jmu.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String Hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "소개페이지 입니다.";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        LocalDate now = LocalDate.now();
        Date today = new Date();
        return LocalDate.now().toString();
    }

}
