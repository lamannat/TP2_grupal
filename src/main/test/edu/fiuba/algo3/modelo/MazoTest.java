package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {

    @Test
    public void seAgregaUnaCartaEnUnMazo() {

        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("Globo"));

        Mazo mazo = new Mazo();
        assertFalse(mazo.contienteCarta(carta1));
        mazo.agregarCarta(carta1);
        assertTrue(mazo.contienteCarta(carta1));
    }

    @Test
    public void seAgregaUnaCartaEnUnMazoYOtraQueNoPertenece() {
        Mazo mazo = new Mazo();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("Globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new SimboloNormal("Barco"));

        mazo.agregarCarta(carta1);
        assertTrue(mazo.contienteCarta(carta1));
        assertFalse(mazo.contienteCarta(carta2));
    }

    @Test
    public void obtenerCartaAleatoriaDelMazo() {
        Mazo mazo = new Mazo();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("Globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new SimboloNormal("Barco"));
        Carta carta3 = new Carta(new Pais("Gobi"),new SimboloNormal("Cañon"));

        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        mazo.agregarCarta(carta3);

        mazo.sacarCartaAleatoria();

        assertFalse(mazo.contienteCarta(carta1) && mazo.contienteCarta(carta2) && mazo.contienteCarta(carta3));
    }

    @Test
    public void obtenerCartaEspecificaDelMazo() {
        Mazo mazo = new Mazo();
        Carta carta1 = new Carta(new Pais("Argentina"),new SimboloNormal("Globo"));
        Carta carta2 = new Carta(new Pais("Mexico"),new SimboloNormal("Barco"));
        Carta carta3 = new Carta(new Pais("Gobi"),new SimboloNormal("Cañon"));

        mazo.agregarCarta(carta1);
        mazo.agregarCarta(carta2);
        mazo.agregarCarta(carta3);

        mazo.sacarCarta(carta2);

        assertTrue(mazo.contienteCarta(carta1));
        assertFalse(mazo.contienteCarta(carta2));
        assertTrue(mazo.contienteCarta(carta3));
    }


}