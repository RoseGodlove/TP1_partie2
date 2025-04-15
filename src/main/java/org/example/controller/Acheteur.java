package org.example.controller;

public class Acheteur {

    private String nom;
    private String prenom;
    private ModePaiement modePaiement;
    private String adresse;


    public Acheteur(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Acheteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", modePaiement=" + modePaiement +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}

