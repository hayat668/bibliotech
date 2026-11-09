package com.bibliotech.model;

public sealed interface StatutEmprunt
        permits StatutEmprunt.EnCours,
                StatutEmprunt.Rendu,
                StatutEmprunt.EnRetard {

    record EnCours(java.time.LocalDate dateLimite)
            implements StatutEmprunt {
    }

    record Rendu(
        java.time.LocalDate dateRetour,
        boolean enRetardLorsDuRetour
    ) implements StatutEmprunt {
    }
    record EnRetard(
    java.time.LocalDate dateLimite,
    long joursDeRetard
) implements StatutEmprunt {
}
}