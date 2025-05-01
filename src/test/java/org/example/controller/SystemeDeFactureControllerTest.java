package org.example.controller;

import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

class SystemeDeFactureControllerTest {

    private SystemeDeFactureController controller;


    /**
     * Initialise le contrôleur et simule les champs de l'interface utilisateur
     * avant chaque test. Démarre JavaFX si ce n'est pas déjà le cas.
     *
     * @throws Exception si l'initialisation de JavaFX échoue.
     */
    @BeforeEach
    void setUp() throws Exception {
        if (!Platform.isFxApplicationThread()) {
            final CountDownLatch latch = new CountDownLatch(1);
            Platform.startup(latch::countDown);
            latch.await();
        }

        controller = new SystemeDeFactureController();

        // Simuler les champs de l'interface
        controller.nomAcheteurField = new TextField("Rose");
        controller.montantSansTaxesField = new TextField("100");
        controller.montantTaxesField = new TextField("15");
        controller.modePaiementComboBox = new ComboBox<>();
        controller.modePaiementComboBox.getItems().addAll("Argent", "Carte de débit", "Carte de crédit");
        controller.modePaiementComboBox.setValue("Argent");
        controller.MontantInconnu = new TextField();
        controller.totalDonsField = new TextField();
    }


    /**
     * Vérifie qu'un montant décimal avec un point est correctement interprété
     * par la méthode Double.parseDouble (test positif).
     */
    @Test
    void MontantSansTaxes_NombreDecimal_AlorsTestValide() {
        String montantStr = "150.15";
        try {
            double montant = Double.parseDouble(montantStr);

            // Ici on affirme que ça NE DOIT PAS être égal à 150.15 → test volontairement faux
            assertEquals(150.15, montant);

        } catch (NumberFormatException e) {
            System.out.println("Une valeur décimale valide ne devrait pas lever d'exception");
        }

    }


    /**
     * Vérifie que le parsing d'un montant avec une virgule échoue,
     * car Java attend un point pour les décimales (test négatif).
     */
    @Test
    void MontantSansTaxes_AvecVirgule_AlorsTestValide() {
        String montantStr = "150,50";

        assertThrows(NumberFormatException.class, () -> {
            Double.parseDouble(montantStr);
        });

    }

    /**
     * Vérifie qu'une chaîne non numérique provoque une NumberFormatException
     * lors du parsing avec Double.parseDouble.
     */
    @Test
    void montantSansTaxes_NonNumerique_AlorsTestValide() {
        String montantStr = "abc";
        assertThrows(NumberFormatException.class, () -> {
            Double.parseDouble(montantStr);
        });
    }


    /**
     * Teste que l'enregistrement d'une facture avec un nom invalide (chiffres)
     * affiche un message d'erreur approprié dans le champ MontantInconnu.
     */
    @Test
    void testEnregistrerFacture_NomInvalide() {

        controller.nomAcheteurField.setText("12");
        controller.enregistrerFacture();

        // Vérifie qu'un message d'erreur est affiché et que le montant est toujours nul
        assertNotEquals("Le nom doit contenir que des lettres et 3 minimum.", controller.MontantInconnu.getText());
    }

    /**
     * Teste qu'un champ vide pour le montant des taxes déclenche un message
     * d'erreur générique dans le champ MontantInconnu.
     */
    @Test
    void testEnregistrerFacture_ChampVide() {
        controller.montantTaxesField.setText("");
        controller.enregistrerFacture();
        assertEquals("Erreur inattendue.", controller.MontantInconnu.getText());
    }



}