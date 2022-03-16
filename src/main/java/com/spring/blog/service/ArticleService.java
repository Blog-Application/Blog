package com.spring.blog.service;

import com.spring.blog.dto.ArticleDto;
import com.spring.blog.exception.ArticleNotFoundException;
import com.spring.blog.model.Article;

import com.spring.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {
    @Autowired
    private AuthService authService;
    @Autowired
    private ArticleRepository articleRepository;


    @Transactional
    public List<ArticleDto> showAllArticles() {
        List<Article> articles= articleRepository.findAll();
        return articles.stream().map(this::mapFromArticleToDto).collect(toList());
    }

    @Transactional
    public void createArticle(ArticleDto articleDto) {
        Article article = mapFromDtoToArticle(articleDto);
        articleRepository.save(article);
    }

    @Transactional
    public ArticleDto readSingleArticle(Long id) {
        Article post = articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("For id " + id));
        return mapFromArticleToDto(post);
    }

    public Article mapFromDtoToArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        article.setContent(articleDto.getContent());
        article.setUsername(loggedInUser.getUsername());
        return article;
    }

    private ArticleDto mapFromArticleToDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setID(article.getID());
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(article.getContent());
        articleDto.setUsername(article.getUsername());
        return articleDto;
    }

}