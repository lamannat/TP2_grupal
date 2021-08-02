package edu.fiuba.algo3.modelo;


import java.util.ArrayList;
import java.util.List;

public class SetUpJuego implements Observable {
    private final List<Observer> observers;
    private int cantidadJugadores;

    public SetUpJuego() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    public void asignarCantidadJugadores(int cantidad) {
        this.cantidadJugadores = cantidad;
        this.notifyObservers();
    }

    public int getCantidadJugadores() {
        return this.cantidadJugadores;
    }
}
