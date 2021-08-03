package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Ronda implements Observable {
    protected List<Observer> observadores;
    protected List<Accion> acciones;

    public Ronda(){
        this.observadores = new ArrayList<>();
        this.acciones = new ArrayList<>();
    }

    public abstract void comenzarLaRonda(Jugador jugador);

    public abstract Ronda siguienteRonda();

    public abstract boolean terminaste();

    public abstract void resetearAcciones();

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
