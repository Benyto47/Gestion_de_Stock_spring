package com.j2ee.getionStock.service;


import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.entities.Category;
import com.j2ee.getionStock.repository.ArticleRepository;
import com.j2ee.getionStock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository ;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Article saveArticle(Article article) {

        Article art = article ;

        if (art.getImage() == null || art.getImage().isEmpty()) {
            String categoryNom = art.getCategory().getNom();
            if (categoryNom.equals("Téléphone"))
                art.setImage("/image/telephone/apple-14-pro-renders.jpg");
            else if (categoryNom.equals("Tablette"))
                art.setImage("/image/tablette/tablette noire.jpg");
            else if (categoryNom.equals("Ordinateur"))
                art.setImage("/image/pc/dell 13.jpg");
            else if (categoryNom.equals("Lunette"))
                art.setImage("/image/lunette/hugo-boss.jpg");
        }


        //Gérer automatiquement la date actuelle sous format String.
        Date date = new Date(); // Obtenir la date actuelle
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        String formattedDate = dateFormat.format(date);

        article.setDate(formattedDate);

        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {

        Article art = articleRepository.findById(article.getId()).get() ;

        if (art.getImage() == null || art.getImage().isEmpty()) {
            String categoryNom = art.getCategory().getNom();
            if (categoryNom.equals("Téléphone"))
                art.setImage("/image/telephone/apple-14-pro-renders.jpg");
            else if (categoryNom.equals("Tablette"))
                art.setImage("/image/tablette/tablette noire.jpg");
            else if (categoryNom.equals("Ordinateur"))
                art.setImage("/image/pc/dell 13.jpg");
            else if (categoryNom.equals("Lunette"))
                art.setImage("/image/lunette/hugo-boss.jpg");
        }

        //Gérer automatiquement la date actuelle sous format String.
        Date date = new Date(); // Obtenir la date actuelle
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        String formattedDate = dateFormat.format(date);

        article.setDate(formattedDate);

        return articleRepository.save(article);
    }

    @Override
    public void deleteArticleById(Long id) {

        articleRepository.deleteById(id);
    }

    @Override
    public void deleteArticle(Article article) {

        articleRepository.delete(article);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> getArticleByCategory(Category category) {
        return articleRepository.findByCategory(category);
    }

    @Override
    public List<Article> getArticleByCategoryId(Long id) {
        return articleRepository.findByCategoryId(id);
    }

    @Override
    public List<Article> updateAllArticle(List<Article> articles) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Article> updatedArticles = new ArrayList<>();

        for (Article art : articles) {
            if (art.getImage() == null || art.getImage().isEmpty()) {
                String categoryNom = art.getCategory().getNom();
                if (categoryNom.equals("Téléphone"))
                    art.setImage("/image/telephone/apple-14-pro-renders.jpg");
                else if (categoryNom.equals("Tablette"))
                    art.setImage("/image/tablette/tablette-noire.jpg");
                else if (categoryNom.equals("Ordinateur"))
                    art.setImage("/image/pc/dell-13.jpg");
                else if (categoryNom.equals("Lunette"))
                    art.setImage("/image/lunette/hugo-boss.jpg");
            }

            // Formater la date
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);
            art.setDate(formattedDate);

            updatedArticles.add(art);
        }

// Enregistrer la liste d'articles modifiés
        articleRepository.saveAll(updatedArticles);

        return articleRepository.saveAll(articles);
    }


}
