package org.example.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    private ComboBox<String> modePaiementComboBox;
    private final Comptabilite comptabilite = new Comptabilite();


    @FXML
    private TextField totalDonsField;

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
        totalDonsField.setText(String.format(String.format("Total des dons de charité : %.2f $", donCharite.getTotalDons())));

    }

    private void afficherErreur() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez entrer des montants valides.");
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
     *
     */
    public void enregistrerFacture() {
        try {
            String nom = nomAcheteurField.getText();
            double montantSansTaxes = Double.parseDouble(montantSansTaxesField.getText());
            double montantTaxes = Double.parseDouble(montantTaxesField.getText());
            String modePaiement = modePaiementComboBox.getValue();

            // Délégation à Comptabilite
            double totalAvecTaxes = comptabilite.enregistrerFacture(nom, montantSansTaxes, montantTaxes, modePaiement);

            // Mise à jour de l'affichage
            MontantInconnu.setText(String.format("%.2f $", totalAvecTaxes));
            totalDonsField.setText(String.format("Total des dons de charité : %.2f $", comptabilite.getTotalDesDons()));

        } catch (NumberFormatException e) {
            afficherErreur();
        }
    }

}

