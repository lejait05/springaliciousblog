package com.example.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;


public interface PostRepository extends JpaRepository <Post, Long>{
Post findByTitle(String title);
Post findFirstByTitle(String title);
Post getPostById(long id);
}