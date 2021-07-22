package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void SeIniciaElJuegoYLosDosJugadoresTienen25FichasCadaUno(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno);

        assertEquals(Valentin.contarTotalFichas(), 25);
        assertEquals(Juan.contarTotalFichas(), 25);
    }

    @Test
    public void DespuesDeLaPrimeraRondaLosDosJugadoresTienen30Fichas(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno);
        juego.comenzarRonda();

        assertEquals(Valentin.contarTotalFichas(), 30);
        assertEquals(Juan.contarTotalFichas(), 30);
    }

    @Test
    public void DespuesDeLaSegundaRondaLosDosJugadoresTienen33Fichas(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        Turno turno = new Turno(jugadores);

        Juego juego = new Juego(tablero, turno);
        juego.comenzarRonda();
        juego.siguienteRonda();
        juego.comenzarRonda();

        assertEquals(Valentin.contarTotalFichas(), 33);
        assertEquals(Juan.contarTotalFichas(), 33);
    }

}