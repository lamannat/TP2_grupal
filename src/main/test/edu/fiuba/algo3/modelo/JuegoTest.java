package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void JugadorConquistoAsia(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        Jugador Tobias = new Jugador("Tobias", new ColorVerde());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);
        jugadores.add(Tobias);

        Tablero tablero = new Tablero();
        Turno turno = mock(Turno.class);
        when(turno.jugadorActual()).thenReturn(Valentin);

        Juego juego = new Juego(tablero, turno);

        Continente Asia = tablero.encontrarContinente("Asia");
        assertTrue(Asia.conquistadoPor(new ColorNegro()));
    }

    @Test
    public void JugadorConquistoEuropa(){
        Jugador Valentin = new Jugador("Valentin", new ColorNegro());
        Jugador Juan = new Jugador("Juan", new ColorMagenta());
        Jugador Tobias = new Jugador("Tobias", new ColorVerde());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);
        jugadores.add(Tobias);

        Tablero tablero = new Tablero();
        Turno turno = mock(Turno.class);
        when(turno.jugadorActual()).thenReturn(Juan);

        Juego juego = new Juego(tablero, turno);

        Continente Asia = tablero.encontrarContinente("Europa");
        assertTrue(Asia.conquistadoPor(new ColorMagenta()));
    }

}