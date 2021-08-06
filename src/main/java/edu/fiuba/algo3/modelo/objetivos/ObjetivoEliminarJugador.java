package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoEliminarJugador implements Objetivo {

    private Jugador jugador;
    private Jugador paraEliminar;

    public ObjetivoEliminarJugador(Jugador jugador, Jugador paraEliminar){
        this.jugador = jugador;
        this.paraEliminar = paraEliminar;
    }

    @Override
    public boolean cumplido() {
        return this.paraEliminar.perdistePorJugador(this.jugador);
    }

    @Override
    public String toString(){
        String o = "Destruir el ejercito " + paraEliminar.getColor().getNombre();
        return o;
    }
}
