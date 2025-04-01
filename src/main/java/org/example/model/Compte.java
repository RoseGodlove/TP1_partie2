package org.example.model;

import org.example.controller.GuichetAutomatique;

public class Compte {

private static final int NO_COMPTE = 12345678;
    double solde;

    public Compte(int client) {
        this.solde = solde;
    }


    /**
     *
     * @return
     */
    public double getSolde() {
        return solde;
    }

    /**
     *
     * @param solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     *
     * @param guichetAutomatique
     * @return
     */
    public int deposerMontant(GuichetAutomatique guichetAutomatique) {

        return 0;
    }

    /**
     *
     * @param guichetAutomatique
     * @return
     */
    public int retireMontant(GuichetAutomatique guichetAutomatique){
        return 0;
    }

    /**
     *
     * @return
     */
    public int getNumeroCompte() {
        return 0;
    }
}
