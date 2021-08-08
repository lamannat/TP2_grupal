package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
        Jugador jugador = mock(Jugador.class);
        RondaIncorporacion ronda = new RondaIncorporacion(juego);
    }
}