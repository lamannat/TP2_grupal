package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoEliminarJugador implements Objetivo {
    private Jugador paraEliminar;

    public ObjetivoEliminarJugador(Jugador paraEliminar){
        this.paraEliminar = paraEliminar;
    }

    @Override
    public boolean cumplido() {
        return !this.paraEliminar.seguisJugando();
    }
}
