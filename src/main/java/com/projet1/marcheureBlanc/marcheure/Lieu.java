package com.projet1.marcheureBlanc.marcheure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Lieu {
    private final String nomDuLieu;
    private final List<Route> routesAdjacentes;
}