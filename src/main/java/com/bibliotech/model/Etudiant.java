package com.bibliotech.model;

public record Etudiant(
    long id,
    String numeroEtudiant,
    String nom,
    String prenom,
    String email
) 
{
    public Etudiant {
        if (numeroEtudiant == null || numeroEtudiant.isBlank()) {
            throw new IllegalArgumentException("Le numéro étudiant est obligatoire");
        }
        if (!numeroEtudiant.matches("[A-Z]{2}\\d{6}")) {
    throw new IllegalArgumentException("Format du numéro étudiant invalide");
}
if (nom == null || nom.isBlank()) {
    throw new IllegalArgumentException("Le nom est obligatoire");
}
if (prenom == null || prenom.isBlank()) {
    throw new IllegalArgumentException("Le prénom est obligatoire");
}
if (email == null || email.isBlank() || !email.contains("@")) {
    throw new IllegalArgumentException("Email invalide");
}
    }
}