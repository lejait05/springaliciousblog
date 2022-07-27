package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String getPost(@PathVariable long id){
    return "Viewing post: " + id;
}
@GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm(){
    return "Form to create post";
}
@PostMapping("/posts/create")
    @ResponseBody
    public String savePost(){
    return "Saving post";
}
}
