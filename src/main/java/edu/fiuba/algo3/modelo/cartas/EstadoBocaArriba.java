package edu.fiuba.algo3.modelo.cartas;

public class EstadoBocaArriba implements EstadoCarta {

    @Override
    public boolean esCanjeable() {
        return false;
    }

    @Override
    public String toString() {
        return "Declarada";
    }
}