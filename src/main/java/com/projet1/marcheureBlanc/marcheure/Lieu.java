package com.projet1.marcheureBlanc.marcheure;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class Lieu {
    private final String nomDuLieu;
    private final List<Route> routesAdjacentes;
}