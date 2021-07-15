package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void agregarPaisesAJugador() {
        Jugador jugador = new Jugador("Pedro",Colores.ROJO);

        Pais pais1 = new Pais("Aral");
        Pais pais2 = new Pais("Mongolia");
        Pais pais3 = new Pais("China");

        jugador.agregarPais(pais1);
        jugador.agregarPais(pais2);
        jugador.agregarPais(pais3);

        assertEquals(jugador.cuantosPaisesConquistados(),3);
    }
}