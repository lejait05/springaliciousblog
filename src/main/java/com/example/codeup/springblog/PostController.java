package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
@GetMapping("/posts")
//    @ResponseBody
    public String getPosts(Model model){
    List<Post> postList = new ArrayList<>(List.of());
    model.addAttribute("posts",postList);
    return "posts/index";
}
@GetMapping("/posts/{id}")
//    @ResponseBody
    public String getPost(@PathVariable long id){
    return "Viewing post: " + id;
}

@GetMapping("/posts/create")
//    @ResponseBody
    public String getCreatePostForm(@RequestParam String query, Model model) {
    model.addAttribute("create", query);
    return "create";
}

@PostMapping("/posts/create")
//    @ResponseBody
    public String savePost(@RequestParam String query, Model model) {
    model.addAttribute("create", query);
    return "show";
}
}
