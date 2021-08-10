package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Mazo;
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
    private Jugador jugadorGanador;

    public Juego(Tablero tablero, Turno turno, Batalla unaBatalla, Mazo unMazo) {
        this.turno = turno;
        this.tablero = tablero;
        this.batalla = unaBatalla;
        this.mazo = unMazo;
        this.tablero.asignarPaises(this.turno);
        this.observadores = new ArrayList<>();
        this.jugadorGanador = null;
    }

    public void seleccionarRonda(Ronda ronda) {
        rondaActual = ronda;
    }

    public Jugador jugadorActual() {
        return turno.jugadorActual();
    }

    public void avanzar() {
        if (this.rondaActual.terminaste())
            terminaLaRonda();

        if (this.turno.jugadorActual().ganador()) {
            jugadorGanador = this.turno.jugadorActual();
            notifyObservers();
        } else {
            this.rondaActual.comenzarLaRonda(this.turno.jugadorActual());
            this.rondaActual.avanzar();
        }
    }

    private void terminaLaRonda() {
        if (this.turno.ultimoJugador()) {
            this.rondaActual = this.rondaActual.siguienteRonda();
            for (Observer observer : observadores)
                this.rondaActual.addObserver(observer);
        }
        this.rondaActual.resetearAcciones();
        this.turno.avanzarJugador();
    }

    public void cartaParaJugador(Jugador jugador) {
        if (jugador.merecesCarta())
            jugador.solicitarCarta(mazo.sacarCartaAleatoria());
    }

    public int fichasPorContinente(Jugador jugador) {
        return tablero.fichasPorContinente(jugador);
    }

    public Ronda dameRonda() {
        return this.rondaActual;
    }

    public Batalla getBatalla() {
        return this.batalla;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public Pais getPaisPorNombre(String nombre) {
        return tablero.getPaisPorNombre(nombre);
    }

    public void agregarObserverARondaActual(Observer observer) {
        this.rondaActual.addObserver(observer);
    }

    public void addObserverAPaises(Observer observer){
        this.tablero.addObserverAPaises(observer);
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
}
