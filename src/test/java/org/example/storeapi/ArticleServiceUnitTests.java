package org.example.storeapi;

import org.example.storeapi.bo.Article;
import org.example.storeapi.dao.ArticleRepository;
import org.example.storeapi.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ArticleServiceUnitTests {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private LocaleHelper localeHelper;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        when(localeHelper.i18n("article.getId.notFound"))
                .thenReturn("Article not found");
        when(localeHelper.i18n("article.getId.success"))
                .thenReturn("Article found");
        when(localeHelper.i18n("article.getAll.success"))
                .thenReturn("Articles found");
        when(localeHelper.i18n("article.delete.notFound"))
                .thenReturn("Article not found");
        when(localeHelper.i18n("article.delete.success"))
                .thenReturn("Article deleted");
        when(localeHelper.i18n("article.save.created"))
                .thenReturn("Article created");
        when(localeHelper.i18n("article.save.updated"))
                .thenReturn("Article updated");
    }

    @Test
    void test() {
        //Fonctionne a moitié

        // Aucun article
        when(articleRepository.findById(1L)).thenReturn(Optional.empty());
        when(articleRepository.findAll()).thenReturn(List.of());

        assertEquals("701", articleService.getArticleById(1L).code);
        assertEquals("701", articleService.getAllArticles().code);
        assertEquals("701", articleService.deleteArticleById(1L).code);

        // Création
        Article article = new Article(1L, "test");

        when(articleRepository.save(article)).thenReturn(article);
        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));

        assertEquals("202", articleService.saveArticle(article).code);
        assertEquals("202", articleService.getArticleById(1L).code);

        // Modification
        article.title = "test modifié";
        assertEquals("203", articleService.saveArticle(article).code);

        // Liste avec 1 article
        when(articleRepository.findAll())
                .thenReturn(List.of(article));

        assertEquals("202", articleService.getAllArticles().code);

        // Suppression
        doNothing().when(articleRepository).deleteById(1L);
        when(articleRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertEquals("202", articleService.deleteArticleById(1L).code);
    }
}
