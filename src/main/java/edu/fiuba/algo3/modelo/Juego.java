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

//    // suponer q esto no existe
//    public void comenzarRonda(){
//
//        Jugador ultimoJugador = turno.jugadorActual();
//        turno.avanzarJugador();
//        Jugador jugadorActual = turno.jugadorActual();
//
//        while(ultimoJugador != jugadorActual){
//            rondaActual.comenzarLaRonda(jugadorActual);
//            turno.avanzarJugador();
//            jugadorActual = turno.jugadorActual();
//        }
//
//        rondaActual.comenzarLaRonda(jugadorActual); //se ejecuta una vez mas por el ultimo jugador que no se ejecuto en el while
//    }

    public Jugador jugadorActual() {
        return turno.jugadorActual();
    }

    public Pais getPaisPorNombre(String nombre) {
        return tablero.getPaisPorNombre(nombre);
    }


    public void siguienteRonda(){
        this.rondaActual = this.rondaActual.siguienteRonda();
    }

    public void avanzar(Observer observer){
        if (this.rondaActual.terminaste()){
            if (this.turno.ultimoJugador()){
                this.rondaActual = this.rondaActual.siguienteRonda();
                this.rondaActual.addObserver(observer);
            }
            this.turno.avanzarJugador();
        }
        this.rondaActual.comenzarLaRonda(this.turno.jugadorActual());
    }

//    public void darleFichasAJugador(Jugador jugador, int cantFichas) {
//        //falta lo del input
//        jugador.darFichas(jugador.generarFichas(cantFichas));
//
//    }

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


}
