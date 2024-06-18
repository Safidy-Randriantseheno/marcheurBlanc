package com.projet1.marcheureBlanc.marcheure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public record Route {
    private final String nom;

    public Lieu obtenirAutreExtremite(Lieu extremiteActuelle, Carte carte) {
        List<Lieu> possibilités = carte.lieux().stream()
                .filter(lieu -> !lieu.equals(extremiteActuelle))
                .filter(lieu -> lieu.getRoutesAdjacentes().stream()
                        .anyMatch(route -> extremiteActuelle.getRoutesAdjacentes().contains(route)))
                .collect(Collectors.toList());

        if (possibilités.isEmpty()) {
            throw new IllegalStateException("Impossible de trouver un lieu avec des routes adjacentes communes.");
        }

        return possibilités.get(new Random().nextInt(possibilités.size()));
    }
}
