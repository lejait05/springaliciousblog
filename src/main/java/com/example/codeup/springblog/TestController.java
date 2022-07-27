package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {

    @GetMapping("/firstview/{name}")
    public String firstview(@PathVariable String name, Model model) {
     model.addAttribute("name", name);
     return "first-view";
    }
}
