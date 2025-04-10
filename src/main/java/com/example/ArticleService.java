package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArticleService {
    private List<Article> articles = new ArrayList<>();

    // Ajoute un article et retourne l'article ajouté
    public Article ajouterArticle(String nom, double prix) {
        Article article = new Article(nom, prix);
        articles.add(article);
        return article;
    }

    // Supprime un article par son identifiant.
    // Retourne true si l'article est trouvé et supprimé, false sinon.
    public boolean supprimerArticle(int id) {
        Iterator<Article> iterator = articles.iterator();
        while (iterator.hasNext()) {
            Article article = iterator.next();
            if (article.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Retourne une copie de la liste des articles
    public List<Article> getArticles() {
        return new ArrayList<>(articles);
    }
}