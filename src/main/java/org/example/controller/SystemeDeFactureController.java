package org.example.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.model.DonCharite;

public class SystemeDeFactureController extends Application {


    @FXML
    private ComboBox<String> modePaiementComboBox;


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



    }

    private void mettreAJourAffichageDon() {
        totalDonsField.setText(String.format("Total des dons de charité : ", donCharite.getTotalDons()));
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
}
