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
    List<Post> postList = new ArrayList<>(Arrays.asList(
new Post("The Last Straw", "One day the camel just had enough. That was the day that the last straw was put on the camel's back."),
            new Post("I Want to Be Free!!!!", "Please help me. I want to be free. I am tired of being locked in this place some call home. I call it HELL. There is no way out. There is no way in. How did I even get here? I just want to be free.")
    ));
    model.addAttribute("posts",postList);
    return "posts/index";
}
//@GetMapping("/posts/{id}")
////    @ResponseBody
//    public String getPost(@PathVariable long id){
//
//    model.addAttribute();
//    return "Viewing post: " + id;
//}

@GetMapping("/posts/create")
//    @ResponseBody
    public String getCreatePostForm() {

    return "posts/create";
}

@PostMapping("/posts/create")
//    @ResponseBody
    public String savePost(@RequestParam String query, Model model) {
    model.addAttribute("posts",savePost());
    return "posts";
}
}
