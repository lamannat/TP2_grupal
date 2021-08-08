package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

import java.util.ArrayList;
import java.util.List;

public abstract class Ronda implements Observable {
    protected List<Observer> observadores;
    protected List<Accion> acciones;
    protected Ronda ronda;

    public Ronda(){
        this.observadores = new ArrayList<>();
        this.acciones = new ArrayList<>();
        this.ronda = null;
    }

    public abstract void comenzarLaRonda(Jugador jugador);

    public abstract boolean terminaste();

    public abstract void resetearAcciones();

    public void setSiguienteRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Ronda siguienteRonda() {
        return ronda;
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

    public abstract Accion dameFase();
}
