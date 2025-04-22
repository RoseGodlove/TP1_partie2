package org.example.controller;

public class Acheteur {

    private String nomComplet;
    private String adresse;


    public Acheteur(String nomComplet, String adresse) {
        this.nomComplet = nomComplet;
        this.adresse = adresse;
    }


    public String getNomComplet() {
        return nomComplet;
    }

    public String getAdresse() {
        return adresse;
    }

    // Méthode pour afficher les détails
    public void afficherDetails() {
        System.out.println("Acheteur : " + nomComplet);
        System.out.println("Adresse : " + adresse);
    }

    // toString pour affichage ou debug
    @Override
    public String toString() {
        return nomComplet + "\n" + adresse;
    }
}
