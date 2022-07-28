package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @GetMapping("/firstview/{name}")
    public String firstview(@PathVariable String name, Model model) {
     model.addAttribute("name", name);
     return "first-view";
    }
//    @GetMapping("/needed")
//    public String returnFavoriteCity(){
//        return "needed";
//    }
//    @PostMapping("/needed")
//    public  String returnFavoriteCityResults{return "needed-results";}
}
