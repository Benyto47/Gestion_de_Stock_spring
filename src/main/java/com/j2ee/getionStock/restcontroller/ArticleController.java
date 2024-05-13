package com.j2ee.getionStock.restcontroller;


import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.repository.ArticleRepository;
import com.j2ee.getionStock.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/articles")
@CrossOrigin  /* les methodes basique pour la gestion des articles et d'autre méthodes */
public class ArticleController {
    @Autowired
    private ArticleService articleService ;

    @Autowired
    private ArticleRepository articleRepository ;

    @PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        Article savedArticle = articleService.updateArticle(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.OK);
    }



    @GetMapping(value="/{id}")
    public Article findArticle(@PathVariable Long id){

        return articleService.getArticleById(id);
    }


    @GetMapping("/all")
    public List<Article> findAllArticle(){

        return articleService.getAllArticle() ;
    }

    @PutMapping("/allArticle")
    public List<Article> updateArticles(@RequestBody List<Article> articles) {
        // Code pour modifier la liste d'articles

        return articleService.updateAllArticle(articles) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //ADMIN afficher le nombre d'articles par pages
    @GetMapping("/admin")
    public Page<Article> getArticles(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return articleRepository.findAll(pageable);
    }

}
