package org.example.storeapi;

import org.example.storeapi.bo.ApiResponse;
import org.example.storeapi.bo.Article;
import org.example.storeapi.dao.ArticleRepository;
import org.example.storeapi.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class StoreApiApplicationTests {

    @Autowired
    private ArticleService articleService;


    @BeforeEach
    public void setup() {
    }

    @Test
    void contextLoads() {
        // Fonctionne avec une BDD vide

        // Test les méthodes qui rate
        assertEquals(articleService.getArticleById(1L).code, "701"); // Article existe pas
        assertEquals(articleService.deleteArticleById(1L).code, "701"); // Article existe pas
        assertEquals(articleService.getAllArticles().code, "701"); // Aucun article dans la BDD


        Article article = new Article("test");

        // Save Article
        assertEquals(articleService.saveArticle(article).code, "202"); // Article sauvegardé
        article.title = "test modifié";
        assertEquals(articleService.saveArticle(article).code, "203"); // Article modifié

        // Get All Articles
        assertEquals(articleService.getAllArticles().code, "202"); // Articles récupérés

        // Get Article by Id
        assertEquals(articleService.getArticleById(2L).code, "202"); // Article récupérer

        // Delete Article by Id
        assertEquals(articleService.deleteArticleById(2L).code, "202"); // Article supprimé
    }

}
