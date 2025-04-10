package com.example;

public class Article {
    private static int compteur = 1;
    private int id;
    private String nom;
    private double prix;

    public Article(String nom, double prix) {
        this.id = compteur++;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
    
    // Méthode equals() pour faciliter les comparaisons dans les tests
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Article))
            return false;
        Article other = (Article) obj;
        return id == other.id && nom.equals(other.nom) && Double.compare(prix, other.prix) == 0;
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, nom, prix);
    }
}