package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post>posts = postDao.findAll();
        model.addAttribute("posts",posts);
        return "posts/index";
    }

//    @GetMapping("/posts")
////    @ResponseBody
//    public String getPosts(Model model) {
//        List<Post> postList = new ArrayList<>(Arrays.asList(
//
//        ));
//        model.addAttribute("posts", postList);
//        return "posts/index";
//    }

    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String getPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
//    @ResponseBody
    public String getCreatePostForm() {

        return "posts/create";
    }

@PostMapping("/posts/create")
//    @ResponseBody
    public String savePost(@RequestParam String title,@RequestParam String body)  {
    Post post = new Post(title, body);
   postDao.save(post);
    return "redirect:/posts";
}
}
