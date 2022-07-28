package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {
    @RequestMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public int add(@PathVariable int number1, @PathVariable int number2){
        return number1 + number2;
    }

}
///add/3/and/4	7
//        /subtract/3/from/10	7
//        /multiply/4/and/5	20
//        /divide/6/by/3	2
