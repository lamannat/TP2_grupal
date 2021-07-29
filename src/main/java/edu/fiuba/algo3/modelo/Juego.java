package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.*;

import java.util.List;

public class Juego {
    private Turno turno;
    private final Tablero tablero;
    private Ronda rondaActual;
    private final Batalla batalla;
    private final Mazo mazo;

    public Juego(Tablero tablero, Turno turno, Batalla unaBatalla, Mazo unMazo) {
        this.turno = turno;
        this.tablero = tablero;
        this.batalla = unaBatalla;
        this.mazo = unMazo;
        rondaActual = new RondaAgregarCincoFichas(this);
        this.tablero.asignarPaises(this.turno);
    }

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
        //preguntar por paises, devuelve lista de paises
//        jugador.colocarFichas(fichas);

        //falta lo del input
        jugador.darFichas(jugador.generarFichas(cantFichas));
    }

    public void jugadorReclamaPorPaises(Jugador jugador) {
    }

    public void jugadorReclamaPorContinentes(Jugador jugador) {
    }

    public void jugadorReclamaPorTarjetas(Jugador jugador) {
        jugador.hacerCanjePorCarta();
    }

    public Carta cartaParaJugador(Jugador jugador) {
        if (jugador.merecesCarta()){
            return this.mazo.sacarCartaAleatoria();
        }
       return null;
    }

    public Batalla getBatalla() {
        return this.batalla;
    }
}
