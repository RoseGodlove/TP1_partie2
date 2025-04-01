package org.example.controller;

public class GuichetAutomatique {
    private final double id;
    private final String contactSoutien = "support@quebbanque.ca | 1-800-123-4567";

    public GuichetAutomatique() {
        this.id = Math.random();
    }

    public double getId() {
        return id;
    }

    public String getContactSoutien() {
        return contactSoutien;
    }
}
