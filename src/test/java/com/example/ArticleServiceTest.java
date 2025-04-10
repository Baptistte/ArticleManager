package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class ArticleServiceTest {

    private ArticleService service;

    @Before
    public void setUp() {
        service = new ArticleService();
    }

    // Test : Ajout d'un article (phase RED puis GREEN)
    @Test
    public void testAjouterArticle() {
        Article article = service.ajouterArticle("Livre", 29.99);
        List<Article> liste = service.getArticles();

        // Vérifier que la liste contient l'article ajouté
        assertEquals(1, liste.size());
        assertEquals("Livre", article.getNom());
        assertEquals(29.99, article.getPrix(), 0.001);
    }

    // Test : Suppression d'un article existant
    @Test
    public void testSupprimerArticle() {
        Article article = service.ajouterArticle("Stylo", 1.50);
        boolean supprime = service.supprimerArticle(article.getId());

        assertTrue(supprime);
        // La liste doit être vide après suppression
        assertEquals(0, service.getArticles().size());
    }

    // Test : Tentative de suppression d'un article inexistant
    @Test
    public void testSupprimerArticleInexistant() {
        service.ajouterArticle("Cahier", 5.00);
        boolean supprime = service.supprimerArticle(999); // ID inexistant

        assertFalse(supprime);
        // La liste doit toujours contenir le Cahier
        assertEquals(1, service.getArticles().size());
    }

    // Test : Récupération de la liste des articles après plusieurs ajouts
    @Test
    public void testGetArticles() {
        service.ajouterArticle("Clavier", 49.99);
        service.ajouterArticle("Souris", 19.99);

        List<Article> liste = service.getArticles();
        assertEquals(2, liste.size());
    }
}