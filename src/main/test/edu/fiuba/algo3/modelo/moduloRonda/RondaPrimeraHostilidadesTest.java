package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.GeneradorFichas;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.color.ColorMagenta;
import edu.fiuba.algo3.modelo.color.ColorNegro;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RondaPrimeraHostilidadesTest {

    @Test
    public void RondaDeAtaqueJugador1AtacaYConquistaUnPais(){
        Jugador Valentin = mock(Jugador.class);
        Jugador Juan = new Jugador("Juan", new ColorMagenta());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Valentin);
        jugadores.add(Juan);

        Tablero tablero = new Tablero();
        Turno turno = new Turno(jugadores);
        Juego juego = new Juego(tablero,turno);
        Ronda ronda = new RondaPrimeraHostilidades(juego);

        Juan.colocarFichas(GeneradorFichas.generar(1,new ColorMagenta()));

        Juan.comienzaElAtaque();
    }
}