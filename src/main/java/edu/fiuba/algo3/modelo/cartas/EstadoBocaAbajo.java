package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.cartas.EstadoCarta;

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
