package org.example.storeapi.service;

import org.example.storeapi.LocaleHelper;
import org.example.storeapi.bo.ApiResponse;
import org.example.storeapi.bo.Article;
import org.example.storeapi.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final LocaleHelper localeHelper;
    //@Autowired
    //LocaleHelper localeHelper;

    public ArticleService(ArticleRepository articleRepository, LocaleHelper localeHelper) {
        this.localeHelper = localeHelper;
        this.articleRepository = articleRepository;
    }

    public ApiResponse<?> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty())
        {
            return new ApiResponse<String>("701", localeHelper.i18n("article.delete.notFound"), "No data");
        }
        return new ApiResponse<List<Article>>("202", localeHelper.i18n("article.getAll.success"), articles);
    }


    public ApiResponse<?> getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null)
        {
            return new ApiResponse<String>("701", localeHelper.i18n("article.getId.notFound"), "Pas d'article avec l'id: " + id);
        }
        return new ApiResponse<Article>("202", localeHelper.i18n("article.getId.success"), article);
    }


    public ApiResponse<?> deleteArticleById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        //Article article = articleRepository.deleteById();
        if (article == null)
            {
                return new ApiResponse<String>("701", localeHelper.i18n("article.delete.notFound"), "Pas d'article avec l'id: " + id);
        }else {
            articleRepository.deleteById(id);
            return new ApiResponse<String>("202", localeHelper.i18n("article.delete.success"), "Article avec l'id: " + id + " supprimé.");
        }
    }

    public ApiResponse<?> saveArticle(Article article) {
        if (article.id != null && articleRepository.existsById(article.id)) {
            articleRepository.save(article);
            return new ApiResponse<Article>("203", localeHelper.i18n("article.save.updated"), article);
        }
        article.id = null;
        articleRepository.save(article);
        return new ApiResponse<Article>("202", localeHelper.i18n("article.save.created"), article);
    }
}
