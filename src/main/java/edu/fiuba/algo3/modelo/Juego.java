package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.moduloRonda.*;

import java.util.List;

public class Juego {
    private final Turno turno;
    private final Tablero tablero;
    private Ronda rondaActual;
    private final Batalla batalla;
    private final Mazo mazo;
    private Canjeador tipoCanjeador;

    public Juego(Tablero tablero, Turno turno, Batalla unaBatalla, Mazo unMazo, Canjeador canjeador) {
        this.turno = turno;
        this.tablero = tablero;
        this.batalla = unaBatalla;
        this.mazo = unMazo;
        this.tipoCanjeador = canjeador;
    }

    public Juego(Tablero tablero, Turno turno, Batalla unaBatalla, Mazo unMazo) { // este se tiene que ir
        this.turno = turno;
        this.tablero = tablero;
        this.batalla = unaBatalla;
        this.mazo = unMazo;
        this.tablero.asignarPaises(this.turno);
    }

    public void agregarJugadores(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++)
            turno.agregarJugador(new Jugador(tipoCanjeador.getInstanciaNueva()));
    }

    public int cantJugadores() {
        return turno.cantJugadores();
    }

    public void seleccionarRonda(Ronda ronda) {
        rondaActual = ronda;
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
        if (jugador.merecesCarta())
            return mazo.sacarCartaAleatoria();
       return null;
    }

    public Batalla getBatalla() {
        return this.batalla;
    }

    public void setearJugador(String nombre, Color color) {
        Jugador jugador = turno.jugadorActual();
        jugador.setJugador(nombre, color);
    }
}
