package org.example.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class GuichetController extends Application {



    @FXML private TextField numeroCompteField;
    @FXML private TextField montantDepotField;
    @FXML private TextField montantRetraitField;

    private final Banque banque = new Banque();
    private GuichetAutomatique guichet;

    @FXML
    private void initialize() {
        guichet = new GuichetAutomatique();
        banque.attribuer(guichet);
        afficherMessage("Guichet attribué", "Guichet #" + guichet.getId() + " vous est attribué.");
    }


    @FXML
    private void afficherAide() {
        afficherMessage("Aide", "Coordonnées du soutien technique :\n" + guichet.getContactSoutien());
    }

    @FXML
    private void selectionnerCompte() {
        String numCompte = numeroCompteField.getText();
        if (numCompte.matches("\\d+")) {
            afficherMessage("Compte sélectionné", "Compte #" + numCompte + " sélectionné avec succès.");
        } else {
            afficherErreur("Veuillez entrer un numéro de compte valide.");
        }
    }

    @FXML
    private void effectuerDepot() {
        String montantStr = montantDepotField.getText();
        try {
            double montant = Double.parseDouble(montantStr);
            afficherMessage("Dépôt réussi", "Montant déposé : $" + montant);
        } catch (NumberFormatException e) {
            afficherErreur("Veuillez entrer un montant valide pour le dépôt.");
        }
    }

    @FXML
    private void effectuerRetrait() {
        String montantStr = montantRetraitField.getText();
        try {
            int montant = Integer.parseInt(montantStr);
            if (montant % 20 == 0) {
                afficherMessage("Retrait réussi", "Montant retiré : $" + montant);
            } else {
                afficherErreur("Le montant doit être un multiple de 20.");
            }
        } catch (NumberFormatException e) {
            afficherErreur("Veuillez entrer un montant entier pour le retrait.");
        }
    }

    private void afficherMessage(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void afficherErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/guichet.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("QuébBanque - Guichet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
