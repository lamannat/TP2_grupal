package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.*;

import java.util.ArrayList;
import java.util.List;

public class Juego implements Observable {
    private final Turno turno;
    private final Tablero tablero;
    private Ronda rondaActual;
    private final Batalla batalla;
    private final Mazo mazo;
    private final List<Observer> observadores;
    private Pais paisActual;

    public Juego(Tablero tablero, Turno turno, Batalla unaBatalla, Mazo unMazo) {
        this.turno = turno;
        this.tablero = tablero;
        this.batalla = unaBatalla;
        this.mazo = unMazo;
        this.tablero.asignarPaises(this.turno);
        this.observadores = new ArrayList<>();
    }

    public void seleccionarRonda(Ronda ronda) {
        rondaActual = ronda;
    }

    // suponer q esto no existe
    public void comenzarRonda(){
        Jugador cortarEn = turno.jugadorActual();
        rondaActual.comenzarLaRonda(cortarEn);

        Jugador jugador= turno.jugadorActual();

        while(cortarEn != jugador){
            rondaActual.comenzarLaRonda(jugador);
            jugador = turno.jugadorActual();
        }
    }

    public Jugador jugadorActual() {
        return turno.jugadorActual();
    }

    public Pais getPaisPorNombre(String nombre) {
        paisActual = tablero.getPaisPorNombre(nombre);
        notifyObservers();
        return paisActual;
    }

    public Pais getPaisActual() {
        return paisActual;
    }

    public void siguienteRonda(){
        this.rondaActual = this.rondaActual.siguienteRonda();
    }

    public void darleFichasAJugador(Jugador jugador, int cantFichas) {
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


    @Override
    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void notifyObservers() {
        observadores.forEach(Observer::change);
    }
}
