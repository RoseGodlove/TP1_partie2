package org.example.model;

import org.example.controller.GuichetAutomatique;

public class Client {

    int noCompte;
    GuichetAutomatique guichetAttribue;

    Banque banque;

    public void selectionner(Compte compte, GuichetAutomatique guichetAutomatique) {
        guichetAutomatique.selectionner(compte);

    }


    public void effectuerUnDepot(double montant, GuichetAutomatique guichetAutomatique) {
    }

    public String obtenirLesCoordonneesDuSoutienTechnique() {

        return guichetAttribue.getContactSoutien();
    }

//    public void effectuerUnRetrait(BallotBilletDeVingt montantDArgentEntierMultipleDeVingt) {
//
//
//    }


}
