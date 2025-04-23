package org.example.model;

public class DonCharite {

    private double totalDons;


    public DonCharite() {
        this.totalDons = 0.0;
    }

    /**
     * Ajoute un montant au total des dons s'il est positif
     * et affiche automatiquement le nouveau total.
     *
     */
    public void ajouterDon(double montant) {
        if (montant > 0) {
            this.totalDons += montant;
            afficherTotalDons(); // Affichage automatique à chaque ajout
        }
    }

    /**
     * Affiche le total actuel des dons de charité dans la console.
     */
    public void afficherTotalDons() {
        System.out.println("Total des dons de charité : " + String.format("%.2f", totalDons) + " $");
    }

    public double getTotalDons() {
        return totalDons;
    }

    /**
     * Définit un nouveau total de dons (optionnel).
     *
     * @param totalDons Nouveau total à définir.
     */
    public void setTotalDons(double totalDons) {
        this.totalDons = totalDons;
        afficherTotalDons();
    }
}
