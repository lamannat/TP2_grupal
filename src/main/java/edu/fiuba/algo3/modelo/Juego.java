package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.*;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Turno turno;
    private final Tablero tablero;
    private Ronda rondaActual;
    private final Dado dado;

    public Juego(Tablero tablero, Turno turno, Dado unDado) {
        this.turno = turno;
        this.tablero = tablero;
        this.dado = unDado;
        rondaActual = new RondaAgregarCincoEjercitos(this);
        this.tablero.asignarPaises(this.turno);
    }

    public Dado getDado() { return this.dado; }

    public void comenzarRonda(){
        Jugador cortarEn = turno.jugadorActual();
        rondaActual.comenzarLaRonda(cortarEn);

        Jugador jugador= turno.jugadorActual();

        while(cortarEn != jugador){
            rondaActual.comenzarLaRonda(jugador);
            jugador = turno.jugadorActual();
        }
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
        jugador.hacerCanje();
    }

    public List<Carta> cartasParaJugador(Jugador jugador) {
        List<Carta> cartas = new ArrayList<>();
        if (jugador.merecesCarta())
            cartas.add(tablero.darCarta());
        return cartas;
    }
}
