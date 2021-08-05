package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.cartas.EstadoCarta;

public class EstadoBocaArriba implements EstadoCarta {

    @Override
    public boolean esCanjeable() {
        return false;
    }
}