package org.example.model;

public class Comptabilite {

    private DonCharite donCharite = new DonCharite();

    /**
     * Enregistre une facture en calculant le total avec taxes, les frais selon le mode de paiement
     * et le don de charité associé. Le don est automatiquement ajouté à l'objet DonCharite.
     *
     * @param nom             Le nom de l'acheteur (non utilisé dans le calcul mais inclus pour future utilisation ou suivi).
     * @param montantSansTaxes Le montant initial de la facture, sans les taxes.
     * @param montantTaxes     Le montant des taxes appliquées.
     * @param modePaiement     Le mode de paiement utilisé (ex. "Argent", "Carte de débit", "Carte de crédit").
     * @return Le montant total de la facture incluant les taxes, arrondi au cent supérieur.
     */
    public double enregistrerFacture(String nom, double montantSansTaxes, double montantTaxes, String modePaiement) {
        double totalAvecTaxes = Math.ceil((montantSansTaxes + montantTaxes) * 100.0) / 100.0;

        double tauxFrais = switch (modePaiement) {
            case "Carte de débit" -> 0.01;
            case "Carte de crédit" -> 0.03;
            default -> 0.0;
        };

        double frais = totalAvecTaxes * tauxFrais;
        double don = (totalAvecTaxes - frais) * 0.02;

        donCharite.ajouterDon(don);
        return totalAvecTaxes; // retourne juste le montant avec taxes
    }

    public double getTotalDesDons() {
        return donCharite.getTotalDons();
    }
}
