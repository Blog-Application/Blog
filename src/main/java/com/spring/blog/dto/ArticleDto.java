package com.spring.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

    private long ID;
    private String content;
    private String title;
    private String username;

}
