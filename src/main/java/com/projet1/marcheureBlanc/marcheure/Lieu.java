package com.projet1.marcheureBlanc.marcheure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Lieu {
    private String nomDuLieu;
    private List<Route> routesAdjacentes;
}
