package org.example.storeapi.rest;

import org.example.storeapi.annotations.RequireJwt;
import org.example.storeapi.bo.ApiResponse;
import org.example.storeapi.bo.Article;
import org.example.storeapi.dao.ArticleRepository;
import org.example.storeapi.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //@GetMapping("/getAll")
    //public java.util.List<Article> getAllArticles() {
    //    return articleRepository.findAll();
    //}

    @GetMapping("/getAll")
    public ApiResponse<?> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/getId/{id}")
    public ApiResponse<?> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id); //
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<?> deleteArticleById(@PathVariable Long id) {
        return articleService.deleteArticleById(id);
    }

    @PostMapping("/save")
    public ApiResponse<?> saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

}
