package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.ColorAmarillo;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoTest {

    @Test
    public void elPrimerJugadorAgregadosEsElJugadorActual() {
        List<Jugador> jugadores = new ArrayList<>();
        Jugador primerJugador = new Jugador("Primero", new ColorVerde(), new Canjeador(new Mazo()));
        jugadores.add(primerJugador);
        for (int i = 0; i < 10; i++)
            jugadores.add(new Jugador("Mehs", new ColorAmarillo(), new Canjeador(new Mazo())));
        Turno turno = new Turno(jugadores);

        assertEquals(primerJugador, turno.jugadorActual());
    }

    @Test
    public void elSiguienteAlActualEsIgualQueAvanzarElTurno() {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            jugadores.add(new Jugador("Mehs", new ColorAmarillo(), new Canjeador(new Mazo())));
        Turno turno = new Turno(jugadores);

        Jugador segundo = turno.jugadorSiguiente();
        turno.avanzarJugador();

        assertEquals(segundo, turno.jugadorActual());
    }

    @Test
    public void avanzandoElTurnoHastaElUltimoJugador() {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            jugadores.add(new Jugador("Mehs", new ColorAmarillo(), new Canjeador(new Mazo())));
        Turno turno = new Turno(jugadores);

        for (int i = 0; i < 9; i++)
            turno.avanzarJugador();

        assertTrue(turno.ultimoJugador());
    }

    @Test
    public void elSiguienteDelUltimoEsElPrimero() {
        List<Jugador> jugadores = new ArrayList<>();
        Jugador primerJugador = new Jugador("Primero", new ColorVerde(), new Canjeador(new Mazo()));
        jugadores.add(primerJugador);
        for (int i = 0; i < 10; i++)
            jugadores.add(new Jugador("Mehs", new ColorAmarillo(), new Canjeador(new Mazo())));
        Turno turno = new Turno(jugadores);

        for (int i = 0; i < 10; i++)
            turno.avanzarJugador();

        assertEquals(primerJugador, turno.jugadorSiguiente());
    }
}