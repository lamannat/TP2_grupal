package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAzul;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjetivoCantidadPaisesEnContinenteTest {

    @Test
    public void jugadorNoTieneLaCantidadDePaisesSuficienteParaCumplirElObjetivo() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            if (i % 2 == 0)
                jugador.agregarPais(pais);
        }

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador, 7);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorTieneLaCantidadDePaisesSuficienteParaCumplirElObjetivo() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            if (i % 2 == 0)
                jugador.agregarPais(pais);
        }

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador, 4);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void casoBordeJugadorSinPaisesDelContinenteNoCumpleElObjetivo() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
        }

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador, 5);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void casoBordeJugadorConTodosLosPaisesDelContinenteCumpleElObjetivo() {
        Jugador jugador = new Jugador("Jugador", new ColorAzul(), new Canjeador(new Mazo()));
        Continente continente = new Continente("UnContinente");
        for (int i = 0; i < 10; i++) {
            Pais pais = new Pais("Pais");
            continente.agregarPais(pais);
            jugador.agregarPais(pais);
        }

        Objetivo objetivo = new ObjetivoCantidadPaisesEnContinente(continente, jugador, 8);

        assertTrue(objetivo.cumplido());
    }
}