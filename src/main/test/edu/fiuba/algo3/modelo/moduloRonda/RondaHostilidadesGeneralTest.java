package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.color.ColorVerde;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RondaHostilidadesGeneralTest {

    @Test
    public void juegadorAtacaReagrupaYSolicitaCarta() {
        JugadorPrueba jugador = new JugadorPrueba("Nombre", new ColorVerde(), new Canjeador(new Mazo()));

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        Turno turno = new Turno(jugadores);
        Batalla batalla = new Batalla(new DadoEstandar());
        Mazo mazo = new Mazo();
        Carta carta = new Carta(new Pais("Pais"), new SimboloNormal("Simbolo"));
        mazo.agregarCarta(carta);
        Juego juego = new Juego(new Tablero(), turno, batalla, mazo);

        RondaHostilidadesGeneral ronda = new RondaHostilidadesGeneral(juego);
        juego.seleccionarRonda(ronda);

        juego.comenzarRonda();

        assertEquals(jugador.comiezaElAtaque, 1);
        assertEquals(jugador.reagruparFuerzas, 1);
        assertEquals(jugador.solicitarCartas, 1);
        assertEquals(jugador.jugadorReclamaPorTarjetas, 1);
    }

}