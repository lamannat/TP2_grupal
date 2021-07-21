package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void TableroDividePaisesEntreJugadoresEquitativamente(){
        Tablero tablero = new Tablero();

        Jugador Valentin = new Jugador("Valentin", new ColorAmarillo());
        Jugador Juance = new Jugador("Juance", new ColorVerde());

        tablero.agregarJugador(Valentin);
        tablero.agregarJugador(Juance);

        tablero.asignarPaises();

        assertEquals(Valentin.cuantosPaisesConquistados(),Juance.cuantosPaisesConquistados());
    }

    @Test
    public void TableroDividePaisesEntreJugadoresNoEquitativamente(){
        Tablero tablero = new Tablero();

        Jugador Valentin = new Jugador("Valentin", new ColorAmarillo());
        Jugador Juance = new Jugador("Juance", new ColorVerde());
        Jugador Tobias = new Jugador("Tobias", new ColorRojo());

        tablero.agregarJugador(Valentin);
        tablero.agregarJugador(Juance);
        tablero.agregarJugador(Tobias);

        tablero.asignarPaises();

        Integer paisesValentin = Valentin.cuantosPaisesConquistados();
        Integer paisesJuance = Juance.cuantosPaisesConquistados();
        Integer paisesTobias = Tobias.cuantosPaisesConquistados();

        assertTrue(paisesValentin == 16 || paisesValentin == 17);
        assertTrue(paisesJuance == 16 || paisesJuance == 17);
        assertTrue(paisesTobias == 16 || paisesTobias == 17);
    }

}