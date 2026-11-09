package com.bibliotech.model;
import java.time.LocalDate;
public record Emprunt(
    long id,
    long livreId,
    long etudiantId,
    LocalDate dateEmprunt,
    LocalDate dateRetourPrevue,
    LocalDate dateRetourEffective,
    StatutEmprunt statut
) {
    public Emprunt {
    if (dateEmprunt == null || dateRetourPrevue == null || statut == null) {
        throw new IllegalArgumentException("Les dates et le statut sont obligatoires");
    }
    if (dateRetourPrevue.isBefore(dateEmprunt)) {
    throw new IllegalArgumentException("La date de retour prévue est invalide");
}
    if (dateRetourEffective != null && dateRetourEffective.isBefore(dateEmprunt)) {
    throw new IllegalArgumentException("La date de retour effective est invalide");
}
}
}