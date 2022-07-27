package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExampleViewController {
    @GetMapping("/search")
    public String returnSearchForm(){
        return "search";
    }
@PostMapping("/search")
    public String returnSearchResults(){
        return "search-results";
}
}
