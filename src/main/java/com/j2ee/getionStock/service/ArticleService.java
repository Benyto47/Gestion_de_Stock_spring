package com.j2ee.getionStock.service;


import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.entities.Category;

import java.util.List;


public interface ArticleService {
    Article saveArticle(Article article) ;
    Article updateArticle(Article article) ;
    void deleteArticleById(Long id) ;
    void deleteArticle(Article article) ;
    List<Article> getAllArticle() ;
    Article getArticleById(Long id) ;

    List<Article> getArticleByCategory(Category category) ;
    List<Article> getArticleByCategoryId(Long id) ;

    List<Article> updateAllArticle(List<Article> articles) ;

}
