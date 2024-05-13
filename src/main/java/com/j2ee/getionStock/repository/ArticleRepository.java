package com.j2ee.getionStock.repository;


import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByCategory(Category category) ;
    List<Article> findByCategoryId(Long id) ;

    List<Article> findBySell(Boolean sell) ;

}
