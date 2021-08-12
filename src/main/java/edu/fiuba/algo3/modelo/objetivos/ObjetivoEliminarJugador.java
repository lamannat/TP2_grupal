package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoEliminarJugador implements Objetivo {

    private final Jugador jugador;
    private final Jugador paraEliminar;

    public ObjetivoEliminarJugador(Jugador jugador, Jugador paraEliminar){
        this.jugador = jugador;
        this.paraEliminar = paraEliminar;
    }

    @Override
    public boolean cumplido() {
        return this.paraEliminar.perdistePorJugador(this.jugador);
    }

    @Override
    public String toString() {
        return "Destruir el ejercito " + paraEliminar.getColor().getNombre();
    }
}
