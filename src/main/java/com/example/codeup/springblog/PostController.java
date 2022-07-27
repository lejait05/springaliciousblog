package com.example.codeup.springblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
@GetMapping("/posts")
    @ResponseBody
    public String getPosts(){
    return "Viewing all posts.......";
}
@GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable long id){
    return "Viewing post: " + id;
}
}
//GET	/posts	posts index page
//        GET	/posts/{id}	view an individual post
//        GET	/posts/create	view the form for creating a post
//        POST	/posts/create	create a new post
