package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.AgregarFichas;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Incorporacion;

public class RondaAgregarCincoFichas extends RondaAgregarFichas {

    public RondaAgregarCincoFichas(Juego juego){
        this.juego = juego;
        cantFichas = 5;
        acciones.add(new AgregarFichas(5));
    }

    public Ronda siguienteRonda(){
        return new RondaAgregarTresFichas(this.juego);
    }

    @Override
    public void resetearAcciones() {
    }

    @Override
    public Accion dameFase() {
        return acciones.get(0);
    }

}
