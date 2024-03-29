package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoComun implements Objetivo{
    private final Jugador jugador;
    private final static int minimoDePaises = 30;

    public ObjetivoComun(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public boolean cumplido(){ return jugador.superaCantidadDePaises(minimoDePaises);}

    @Override
    public String toString() {
        return "OBJETIVO COMUN: \n- Ocupar " + minimoDePaises + " paises";
    }
}
