package com.bibliotech.model;

public record Livre(
    long id,
    String titre,
    String auteur,
    int anneePublication,
    int exemplairesTotal,
    int exemplairesDisponibles
) 
{ public Livre {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre est obligatoire");
        }
        if (auteur == null || auteur.isBlank()) {
    throw new IllegalArgumentException("L'auteur est obligatoire");
}
if (anneePublication < 1500 || anneePublication > java.time.Year.now().getValue()) {
    throw new IllegalArgumentException("Année de publication invalide");
}
if (exemplairesDisponibles > exemplairesTotal) {
    throw new IllegalArgumentException("Trop d'exemplaires disponibles");
}
if (exemplairesTotal < 0 || exemplairesDisponibles < 0) {
    throw new IllegalArgumentException("Le nombre d'exemplaires ne peut pas être négatif");
}
    }
    }