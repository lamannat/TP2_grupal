package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

import java.util.ArrayList;
import java.util.List;

public class Ronda implements Observable {

    protected List<Observer> observadores;
    protected List<Accion> acciones;
    protected Ronda ronda;
    protected int numeroAccion;

    public Ronda() {
        this.observadores = new ArrayList<>();
        this.acciones = new ArrayList<>();
        this.ronda = null;
        this.numeroAccion = 0;
    }

    public void agregarAccion(Accion accion) {
        this.acciones.add(accion);
    }

    public void comenzarLaRonda(Jugador jugador) {
        if (acciones.size() < 1 || numeroAccion > acciones.size() - 1)
            return;
        this.acciones.get(this.numeroAccion).ejecutar(jugador);
        this.notifyObservers();
    }

    public boolean terminaste() {
        return numeroAccion == acciones.size();
    }

    public void avanzar() {
        numeroAccion++;
    }

    public void resetearAcciones() {
        this.numeroAccion = 0;
    }

    public void setSiguienteRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Ronda siguienteRonda() {
        return ronda;
    }

    public Accion dameFase() {
        if (acciones.size() < 1) return null;
        return this.acciones.get(this.numeroAccion);
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
