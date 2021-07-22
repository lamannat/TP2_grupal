package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.*;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private final List<Jugador> jugadores;
    private final Tablero tablero;
    private Ronda rondaActual;

    public Juego(List<Jugador> listaJugadores, Tablero tablero) {
        jugadores = listaJugadores;
        this.tablero = tablero;
        rondaActual = new RondaAgregarCincoEjercitos(this);
        this.tablero.asignarPaises(listaJugadores);
    }

    public void comenzarRonda(){
        for (Jugador jugador : jugadores)
            rondaActual.comenzarLaRonda(jugador);
    }

    public void siguienteRonda(){
        this.rondaActual = this.rondaActual.siguienteRonda();
    }

    public void darleFichasAJugador(Jugador jugador, int cantFichas) {
        List<Ficha> fichas = GeneradorFichas.generar(cantFichas,jugador.getColor());
        //preguntar por paises, devuelve lista de paises
        jugador.colocarFichas(fichas);
    }

    public void jugadorReclamaPorPaises(Jugador jugador) {
    }

    public void jugadorReclamaPorContinentes(Jugador jugador) {
    }

    public void jugadorReclamaPorTarjetas(Jugador jugador) {
    }
}
