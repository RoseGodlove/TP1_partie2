package org.example.model;

public class Client {
    public void selectionner(Compte compte, GuichetAutomatique guichetAutomatique) {
        guichetAutomatique.selectionner(compte);
    }
    
    public String obtenirDeLAide(GuichetAutomatique guichetAutomatique){
        return GuichetAutomatique.obtenirLesCoordonneesDuSoutienTechnique();
    }

    public void effectuerUnDepot(float montantDArgent, GuichetAutomatique guichetAutomatique) {
    }

    public void effectuerUnRetrait(BallotDeBilletDe20 ballotDeBilletDe20, GuichetAutomatique guichetAutomatique) {
    }
}
