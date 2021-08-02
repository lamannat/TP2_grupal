package edu.fiuba.algo3.modelo;

public interface Observable {
    public void addObserver(Observer observer);
    public void notifyObservers();
}
