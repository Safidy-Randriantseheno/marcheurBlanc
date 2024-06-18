package com.projet1.marcheureBlanc;

import com.projet1.marcheureBlanc.marcheure.Carte;
import com.projet1.marcheureBlanc.marcheure.Lieu;
import com.projet1.marcheureBlanc.marcheure.Marcheur;
import com.projet1.marcheureBlanc.marcheure.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class MarcheurTest {
    @Test
    public void testMarcheurArriveToujoursADestination() {
        Lieu lieu1 = new Lieu("hei", null);
        Lieu lieu2 = new Lieu("Sekolintsika", null);
        Lieu lieu3 = new Lieu("Marais", null);
        Lieu lieu4 = new Lieu("Pullman", null);
        Lieu lieu5 = new Lieu("Balançoire", null);
        Lieu lieu6 = new Lieu("Boulevard", null);
        Lieu destination = new Lieu("Esti", null);

        Route route1 = new Route("Route 1");
        Route route2 = new Route("Route 2");
        Route route3 = new Route("Route 3");
        Route route4 = new Route("Route 4");
        Route route5 = new Route("Route 5");
        Route route6 = new Route("Route 6");

        lieu1.setRoutesAdjacentes(Arrays.asList(route1, route2));
        lieu2.setRoutesAdjacentes(Arrays.asList(route1, route3, route4));
        lieu3.setRoutesAdjacentes(Arrays.asList(route2, route4, route5));
        lieu4.setRoutesAdjacentes(Arrays.asList(route3, route6));
        lieu5.setRoutesAdjacentes(Arrays.asList(route5, route6));
        lieu6.setRoutesAdjacentes(Arrays.asList(route4, route5, route6));
        destination.setRoutesAdjacentes(Arrays.asList(route6));

        Carte carte = new Carte(Arrays.asList(lieu1, lieu2, lieu3, lieu4, lieu5, lieu6, destination));

        Marcheur marcheur = new Marcheur("Test Marcheur", lieu1, destination);

        List<Lieu> parcours = marcheur.marcher(carte);

        assertEquals(destination, parcours.get(parcours.size() - 1));

        marcheur.afficherTrajectoire(parcours);
    }
    @Test
    public void testMarcheurArriveToujoursADestinationMemeSansNomDeRue() {

        Lieu lieu1 = new Lieu("hei", null);
        Lieu lieu2 = new Lieu("Sekolintsika", null);
        Lieu lieu3 = new Lieu("Marais", null);
        Lieu lieu4 = new Lieu("Pullman", null);
        Lieu lieu5 = new Lieu("Balançoire", null);
        Lieu lieu6 = new Lieu("Boulevard", null);
        Lieu destination = new Lieu("Esti", null);

        Route route1 = new Route(null);
        Route route2 = new Route(null);
        Route route3 = new Route(null);
        Route route4 = new Route(null);
        Route route5 = new Route(null);
        Route route6 = new Route(null);

        lieu1.setRoutesAdjacentes(Arrays.asList(route1, route2));
        lieu2.setRoutesAdjacentes(Arrays.asList(route1, route3, route4));
        lieu3.setRoutesAdjacentes(Arrays.asList(route2, route4, route5));
        lieu4.setRoutesAdjacentes(Arrays.asList(route3, route6));
        lieu5.setRoutesAdjacentes(Arrays.asList(route5, route6));
        lieu6.setRoutesAdjacentes(Arrays.asList(route4, route5, route6));
        destination.setRoutesAdjacentes(Arrays.asList(route6));

        Carte carte = new Carte(Arrays.asList(lieu1, lieu2, lieu3, lieu4, lieu5, lieu6, destination));

        Marcheur marcheur = new Marcheur("Test Marcheur", lieu1, destination);

        List<Lieu> parcours = marcheur.marcher(carte);


        assertEquals(destination, parcours.get(parcours.size() - 1));

        marcheur.afficherTrajectoire(parcours);
    }
    @Test
    public void testPointDeDepartInchange() {
        Lieu lieu1 = new Lieu("hei", null);
        Lieu lieu2 = new Lieu("Sekolintsika", null);
        Lieu lieu3 = new Lieu("Marais", null);
        Lieu lieu4 = new Lieu("Pullman", null);
        Lieu lieu5 = new Lieu("Balançoire", null);
        Lieu lieu6 = new Lieu("Boulevard", null);
        Lieu destination = new Lieu("Esti", null);

        Route route1 = new Route("Route 1");
        Route route2 = new Route("Route 2");
        Route route3 = new Route("Route 3");
        Route route4 = new Route("Route 4");
        Route route5 = new Route("Route 5");
        Route route6 = new Route("Route 6");

        lieu1.setRoutesAdjacentes(Arrays.asList(route1, route2));
        lieu2.setRoutesAdjacentes(Arrays.asList(route1, route3, route4));
        lieu3.setRoutesAdjacentes(Arrays.asList(route2, route4, route5));
        lieu4.setRoutesAdjacentes(Arrays.asList(route3, route6));
        lieu5.setRoutesAdjacentes(Arrays.asList(route5, route6));
        lieu6.setRoutesAdjacentes(Arrays.asList(route4, route5, route6));
        destination.setRoutesAdjacentes(Arrays.asList(route6));

        Carte carte = new Carte(Arrays.asList(lieu1, lieu2, lieu3, lieu4, lieu5, lieu6, destination));

        Marcheur marcheur = new Marcheur("Test Marcheur", lieu1, destination);

        Lieu initialPosition = marcheur.getPositionActuelle();

        marcheur.marcher(carte);

        assertEquals(lieu1, initialPosition);
    }
}