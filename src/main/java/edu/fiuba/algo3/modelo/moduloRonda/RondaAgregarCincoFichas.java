package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;

public class RondaAgregarCincoFichas extends RondaAgregarFichas {

    public RondaAgregarCincoFichas(Juego juego){
        this.juego = juego;
        cantFichas = 5;
    }

    public Ronda siguienteRonda(){
        return new RondaAgregarTresFichas(this.juego);
    }

}
