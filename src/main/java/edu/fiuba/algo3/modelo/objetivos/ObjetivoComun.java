package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoComun implements Objetivo{
    private Jugador jugador;
    private final static int minimoDePaises = 30;

    public ObjetivoComun(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public boolean cumplido(){ return jugador.ganador(minimoDePaises);}
}
