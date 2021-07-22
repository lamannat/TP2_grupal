package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;

public class RondaAgregarTresFichas extends RondaAgregarFichas {

    public RondaAgregarTresFichas(Juego juego) {
        this.juego = juego;
        cantFichas = 3;
    }

    public Ronda siguienteRonda(){
        return new RondaPrimeraHostilidades(this.juego);
    }
}
