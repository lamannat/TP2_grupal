package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.color.ColorAzul;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RondaIncorporacionTest {

    private Juego juegoVacio() {
        return new Juego(new Tablero(), new Turno(new ArrayList<>()), new Batalla(new DadoEstandar()), new Mazo());
    }

    @Test
    public void inicialmenteLaRondaNoTermino() {
        Juego juego = juegoVacio();
        RondaIncorporacion ronda = new RondaIncorporacion(juego);

        assertFalse(ronda.terminaste());
    }

    @Test
    public void despuesDeIncorporarTerminaLaRonda() {
        Juego juego = juegoVacio();
        Jugador jugador = new Jugador("Juan", new ColorAmarillo(), new Canjeador(new Mazo()));
        RondaIncorporacion ronda = new RondaIncorporacion(juego);

        ronda.comenzarLaRonda(jugador);

        assertTrue(ronda.terminaste());
    }

    @Test
    public void seLeDanFichasAlJugador() {
        Juego juego = juegoVacio();
        JugadorPrueba jugador = new JugadorPrueba("Mejor que mock", new ColorAzul(), new Canjeador(new Mazo()));
        RondaIncorporacion ronda = new RondaIncorporacion(juego);

        ronda.comenzarLaRonda(jugador);

        assertEquals(1, jugador.seLeDieronCartas);
    }
}