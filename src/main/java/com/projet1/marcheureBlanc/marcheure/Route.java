package com.projet1.marcheureBlanc.marcheure;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Route {
    private final String nom;

    public Lieu obtenirAutreExtremite(Lieu extremiteActuelle, Carte carte) {
        List<Lieu> possibilites = carte.getLieux().stream()
                .filter(lieu -> !lieu.equals(extremiteActuelle))
                .filter(lieu -> lieu.getRoutesAdjacentes().stream()
                        .anyMatch(route -> extremiteActuelle.getRoutesAdjacentes().contains(route)))
                .collect(Collectors.toList());

        if (possibilites.isEmpty()) {
            throw new IllegalStateException("Impossible de trouver un lieu avec des routes adjacentes communes.");
        }

        return possibilites.get(new Random().nextInt(possibilites.size()));
    }
}
