package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.ColorVerde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoTest {

    @Test
    public void jugadorConUnPaisNoGanaElObjetivoDeTenerMasDeTresPaises() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        Objetivo objetivo = new Objetivo(jugador);
        objetivo.minimoDePaises(3);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorConUnPaisCumpleElObjetivoDeTenerMasDeCeroPaises() {
        Jugador jugador = new Jugador("Pepito", new ColorVerde(), new Canjeador(new Mazo()));
        Pais pais = new Pais("Nombre");
        jugador.agregarPais(pais);

        Objetivo objetivo = new Objetivo(jugador);
        objetivo.minimoDePaises(0);

        assertTrue(objetivo.cumplido());
    }

}