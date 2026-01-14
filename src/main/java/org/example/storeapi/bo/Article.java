package org.example.storeapi.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

    public Article(String title) {
        this.title = title;
    }

    public Article(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Article() {
    }
}
