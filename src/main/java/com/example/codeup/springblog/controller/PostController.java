package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import com.example.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {

        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

    public String showCreatePostForm(Model model) {
model.addAttribute("newPost", new Post());
        return "posts/create";
    }

@PostMapping("/posts/create")
//    @ResponseBody
    public String create(@ModelAttribute Post  newPost)  {
User user = userDao.findById(1L).get();
newPost.setUser(user);
   postDao.save(newPost);
    emailService.prepareAndSend(newPost, "You created a new post!");
    return "redirect:/posts";
}
@GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        Post postToEdit = postDao.findById(id).get();
        model.addAttribute("postToEdit", postToEdit);
        return "posts/edit";
}
    @PostMapping("/posts/{id}/edit")
    public String submitEditForm(@ModelAttribute Post postToEdit) {
        User user = userDao.findById(1L).get();
        postToEdit.setUser(user);
        postDao.save(postToEdit);
        return "redirect:/posts";
    }
}
