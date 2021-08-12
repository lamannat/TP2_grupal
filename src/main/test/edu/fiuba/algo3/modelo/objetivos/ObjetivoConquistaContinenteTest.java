package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAzul;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoConquistaContinenteTest {

    @Test
    public void objetivoGeneraStringAPartirDeContinenteAsignado() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("Africa");
        Objetivo objetivo = new ObjetivoConquistaContinente(continente, jugador);
        assertEquals("Ocupar Africa", objetivo.toString());
    }

    @Test
    public void jugadorNoConquistaTodoElContinente() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            if (i % 2 == 0)
                jugador.agregarPais(pais);
        }
        Objetivo objetivo = new ObjetivoConquistaContinente(continente, jugador);
        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorConquistaTodoElContinente() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            jugador.agregarPais(pais);
        }
        Objetivo objetivo = new ObjetivoConquistaContinente(continente, jugador);
        assertTrue(objetivo.cumplido());
    }

    @Test
    public void casoBordeJugadorNoConquistaNingunPaisDelContinente() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
        }
        Objetivo objetivo = new ObjetivoConquistaContinente(continente, jugador);
        assertFalse(objetivo.cumplido());
    }
}