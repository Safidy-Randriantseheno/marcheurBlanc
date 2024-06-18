package com.projet1.marcheureBlanc.marcheure;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Marcheur {
    private String nom;
    private Lieu positionActuelle;
    private Lieu destination;
    private final HashSet<Lieu> lieuxVisites = new HashSet<>();

    public List<Lieu> marcher(Carte carte) {
        Random random = new Random();
        List<Lieu> lieuxVisitesList = new ArrayList<>();
        lieuxVisites.add(positionActuelle);
        lieuxVisitesList.add(positionActuelle);

        while (!positionActuelle.equals(destination)) {
            positionActuelle = choisirProchainePosition(carte, random);
            lieuxVisites.add(positionActuelle);
            lieuxVisitesList.add(positionActuelle);
        }

        afficherTrajectoire(lieuxVisitesList);
        return lieuxVisitesList;
    }

    private Lieu choisirProchainePosition(Carte carte, Random random) {
        List<Lieu> lieuxPossibles = positionActuelle.getRoutesAdjacentes().stream()
                .map(route -> route.obtenirAutreExtremite(positionActuelle, carte))
                .filter(nouvellePosition -> !lieuxVisites.contains(nouvellePosition))
                .collect(Collectors.toList());

        if (lieuxPossibles.isEmpty()) {
            lieuxPossibles = positionActuelle.getRoutesAdjacentes().stream()
                    .map(route -> route.obtenirAutreExtremite(positionActuelle, carte))
                    .collect(Collectors.toList());
        }

        if (lieuxPossibles.isEmpty()) {
            throw new IllegalStateException("Impossible de trouver un lieu avec des routes adjacentes.");
        }

        return lieuxPossibles.get(random.nextInt(lieuxPossibles.size()));
    }

    public void afficherTrajectoire(List<Lieu> lieuxVisitesList) {
        String trajectoire = lieuxVisitesList.stream()
                .map(Lieu::getNomDuLieu)
                .collect(Collectors.joining(", après ", "Voici la trajectoire pour arriver à " + destination.getNomDuLieu() + ": ", "."));
        trajectoire = trajectoire.replaceFirst(", après ", " d'abord, après ");

        System.out.println(trajectoire);
    }
}