package com.spring.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
public class Article {

    @Id
    @Column
    private long ID;

    @Column
    private String title;

    @Column
    private Date publishDate;

    @Column
    private String text;

    @Column
    private String publisher;


}
