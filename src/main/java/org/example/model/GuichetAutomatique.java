package org.example.controller;

import org.example.model.Compte;

public class GuichetAutomatique {
    private final double id;
    private final String contactSoutien = "support@quebbanque.ca | 1-800-123-4567";

    public GuichetAutomatique() {
        this.id = Math.floor(Math.random()*10);
    }

    public void selectionner(Compte compte) {


    }

    public double getId() {
        return id;
    }

    public String getContactSoutien() {
        return contactSoutien;
    }

    public String obtenirLesCoordonneesDuSoutienTechnique() {
        return "Appelez-nous au 1-543-348-4895 ";
    }

    public void selectionner(Compte compte) {

    }
}