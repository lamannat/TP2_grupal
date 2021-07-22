package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class RondaAgregarTresEjercitos extends RondaAgregarEjercitos {

    public RondaAgregarTresEjercitos(Juego juego) {
        this.juego = juego;
        cantFichas = 3;
    }

    public Ronda siguienteRonda(){
        return new RondaPrimeraHostilidades(this.juego);
    }
}
