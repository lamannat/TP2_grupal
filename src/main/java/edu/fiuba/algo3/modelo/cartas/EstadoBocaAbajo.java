package edu.fiuba.algo3.modelo.cartas;

public class EstadoBocaAbajo implements EstadoCarta {

    @Override
    public boolean esCanjeable() {
        return true;
    }

    @Override
    public String toString() {
        return "No Declarada";
    }

}
