package org.example.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.model.Acheteur;
import org.example.model.Comptabilite;
import org.example.model.DonCharite;


public class SystemeDeFactureController extends Application {


    public TextField TotalAvecTaxes;
    public Button enregistrerButton;
    public TextField montantTaxesField;
    public TextField montantSansTaxesField;
    public TextField nomAcheteurField;
    public TextField MontantInconnu;
    @FXML
    public ComboBox<String> modePaiementComboBox;
    private final Comptabilite comptabilite = new Comptabilite();

    @FXML
    public TextField totalDonsField;  // Remplacer java.awt.TextField par javafx.scene.control.TextField

    private final DonCharite donCharite = new DonCharite();

    public SystemeDeFactureController() {

    }

    @FXML
    public void initialize() {
        modePaiementComboBox.getItems().addAll("Argent", "Carte de débit", "Carte de crédit");
        modePaiementComboBox.getSelectionModel().selectFirst();
        mettreAJourAffichageDon();
        MontantInconnu.setText("inconnu");
    }

    private void mettreAJourAffichageDon() {
        totalDonsField.setText(String.format(String.format("Total dons de charité : %.2f $", donCharite.getTotalDons())));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/facture.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("TopVentes - Facture");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Calcule le total avec taxes et le don de charité à partir des données saisies.
     * Met à jour l'affichage du total avec taxes et du total des dons de charité.
     * Affiche un message d'erreur en cas de saisie invalide.
     */
    public void enregistrerFacture() {
        try {
            String nom = nomAcheteurField.getText();
            String montantSansTaxesStr = montantSansTaxesField.getText();
            String montantTaxesStr = montantTaxesField.getText();
            String modePaiement = modePaiementComboBox.getValue();
            Acheteur acheteur = new Acheteur(nom, "feud");

            // Vérification des champs vides
            if (nom.isEmpty() || montantSansTaxesStr.isEmpty() || montantTaxesStr.isEmpty() || modePaiement == null) {
                afficherErreur("Veuillez remplir tous les champs.");
                return;
            }

            if (!acheteur.validerNom(nom)) {
                afficherErreur("Le nom doit contenir que des lettres et 3 minimum.");
                return;
            }
            double montantSansTaxes = Double.parseDouble(montantSansTaxesStr);
            double montantTaxes = Double.parseDouble(montantTaxesStr);

            // Délégation à Comptabilite
            double totalAvecTaxes = comptabilite.saisirFacture(montantSansTaxes, montantTaxes, modePaiement);

            // Mise à jour de l'affichage
            MontantInconnu.setText(String.format("%.2f $", totalAvecTaxes));
            totalDonsField.setText(String.format("Total dons de charité : %.2f $", comptabilite.getTotalDesDons()));

        } catch (NumberFormatException e) {
            afficherErreur("Entrée invalide pour les montants.");
        } catch (Exception e) {
            MontantInconnu.setText("Erreur inattendue.");
        }
    }
}

