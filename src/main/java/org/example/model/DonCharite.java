package org.example.model;

public class DonCharite {

    private double totalDons;

    // Constructeur : initialise les dons à zéro
    public DonCharite() {
        this.totalDons = 0.0;
    }


    public void ajouterDon(double montant) {
        if (montant > 0) {
            this.totalDons += montant;
        }
    }

    // Afficher le total actuel des dons
    public void afficherTotalDons() {
        System.out.println("Total des dons de charité : " + String.format("%.2f", totalDons) + " $");
    }

    public double getTotalDons() {
        return totalDons;
    }

    // Setter (optionnel, selon usage)
    public void setTotalDons(double totalDons) {
        this.totalDons = totalDons;
    }
}
