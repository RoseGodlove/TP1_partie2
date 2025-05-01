package org.example.model;

public class Acheteur {

    private String nomComplet;
    private String adresse;


    public Acheteur(String nomComplet, String adresse) {
        this.nomComplet = nomComplet;
        this.adresse = adresse;
    }

    /**
     * Valide que le nom contient au moins 3 lettres alphabétiques.
     * @param nom Le nom à valider.
     * @return true si le nom est valide, sinon false.
     */
    public boolean validerNom(String nom) {
        return nom != null && nom.matches("[a-zA-ZÀ-ÿ\\s'-]{3,}");
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
