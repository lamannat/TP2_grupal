package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.*;
import edu.fiuba.algo3.vista.VistaJuego;

import java.util.ArrayList;
import java.util.List;

public class Juego implements Observable {
    private final Turno turno;
    private final Tablero tablero;
    private Ronda rondaActual;
    private final Batalla batalla;
    private final Mazo mazo;
    private final List<Observer> observadores;

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

    public Jugador jugadorActual() {
        return turno.jugadorActual();
    }

    public Pais getPaisPorNombre(String nombre) {
        return tablero.getPaisPorNombre(nombre);
    }

    public void avanzar(Observer observer){ // 0, ataque, 1, mover, 2, solicitar, 0
        if (this.rondaActual.terminaste()){
            if (this.turno.ultimoJugador()){
                System.out.println("Se cambio de ronda RPH");
                this.rondaActual = this.rondaActual.siguienteRonda();
                this.rondaActual.addObserver(observer);
            }
            this.rondaActual.resetearAcciones();
            this.turno.avanzarJugador();
        }
        this.rondaActual.comenzarLaRonda(this.turno.jugadorActual());
    }

    public void cartaParaJugador(Jugador jugador) {
        if (jugador.merecesCarta())
            jugador.solicitarCarta(mazo.sacarCartaAleatoria());
    }

    public Batalla getBatalla() {
        return this.batalla;
    }

    public Ronda dameRonda() {
        return this.rondaActual;
    }


    @Override
    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void notifyObservers() {
        observadores.forEach(Observer::change);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    public void addObserverAPaises(Observer observer){
        this.tablero.addObserverAPaises(observer);
    }

    public void agregarObserverARondaActual(Observer observer) {
        this.rondaActual.addObserver(observer);
    }


    public int fichasPorContinente(Jugador jugador) {
        return tablero.fichasPorContinente(jugador);
    }
}
