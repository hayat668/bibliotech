package com.bibliotech.model;

public class PenaliteCalculator {
    public static double calculerPenalite(StatutEmprunt statut) {
        return switch (statut) {
    case StatutEmprunt.EnCours enCours -> 0.0;
    case StatutEmprunt.Rendu rendu -> 0.0;
    case StatutEmprunt.EnRetard enRetard ->
    Math.min(enRetard.joursDeRetard() * 0.50, 30.0);
};

}


}