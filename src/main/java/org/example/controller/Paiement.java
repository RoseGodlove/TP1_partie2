package org.example.controller;

public class Paiement {

    private String type;
    private double tauxFrais; // En pourcentage : 0%, 1%, 3%, etc.

    // Constructeur
    public Paiement(String type) {
        this.type = type;
        this.tauxFrais = tauxFrais;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getTauxFrais() {
        return tauxFrais;
    }

    // Calcule les frais selon le total fourni
    public double obtenirFrais(double total) {
        return (tauxFrais / 100.0) * total;
    }

    @Override
    public String toString() {
        return type + " (" + tauxFrais + "% de frais)";
    }
}
