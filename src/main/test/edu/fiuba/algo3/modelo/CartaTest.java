package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.simbolo.Simbolo;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void unaCartaGuardaElPaisQueSeLeAsigna() {

        Pais unPais = new Pais("Argentina");
        Carta carta = new Carta(unPais,new SimboloNormal("Globo"));

        assertEquals("Argentina", carta.toString());
    }

    @Test
    public void unaCartaGuardaElSimboloQueSeLeAsigna() {

        Pais unPais = new Pais("Argentina");
        Simbolo simbolo = new SimboloNormal("Globo");
        Carta carta = new Carta(unPais,simbolo);

        assertEquals(simbolo, carta.getSimbolo());
        assertEquals("Globo", carta.getSimbolo().toString());
    }

    @Test
    public void unaCartaEmpiezaBocaAbajo() {

        Pais unPais = new Pais("Argentina");
        Simbolo simbolo = new SimboloNormal("Globo");
        Carta carta = new Carta(unPais,simbolo);

        assertEquals("No Declarada", carta.getEstado().toString());
    }

    @Test
    public void unaCartaOtorgaDosFichasASuPais() {

        Pais unPais = new Pais("Argentina");
        Simbolo simbolo = new SimboloNormal("Globo");
        Carta carta = new Carta(unPais,simbolo);

        assertEquals(2, carta.fichasPorPais(unPais));
    }

    @Test
    public void unaCartaQueOtorgaFichasQuedaBocaArriba() {

        Pais unPais = new Pais("Argentina");
        Simbolo simbolo = new SimboloNormal("Globo");
        Carta carta = new Carta(unPais,simbolo);
        carta.fichasPorPais(unPais);
        assertEquals("Declarada", carta.getEstado().toString());
    }

    @Test
    public void unaCartaQueSeDevuelveAlMazoQuedaBocaAbajo() {

        Pais unPais = new Pais("Argentina");
        Simbolo simbolo = new SimboloNormal("Globo");

        Carta carta = new Carta(unPais,simbolo);
        carta.fichasPorPais(unPais);
        carta.devolverAlMazo(new Mazo());
        assertEquals("No Declarada", carta.getEstado().toString());
    }

    @Test
    public void dosCartasConElMismoSimboloSeConsideranIguales() {

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Chile");
        Simbolo simbolo = new SimboloNormal("Globo");
        Carta carta1 = new Carta(unPais,simbolo);
        Carta carta2 = new Carta(otroPais,simbolo);

        assertTrue(carta2.sonIguales(carta1));
    }
}
