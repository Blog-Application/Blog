package com.spring.blog.controller;

import com.spring.blog.dto.ArticleDto;
import com.spring.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody ArticleDto articleDto) {
        articleService.createArticle(articleDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> showAllPosts() {
        return new ResponseEntity<>(articleService.showAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ArticleDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(articleService.readSingleArticle(id), HttpStatus.OK);
    }
}