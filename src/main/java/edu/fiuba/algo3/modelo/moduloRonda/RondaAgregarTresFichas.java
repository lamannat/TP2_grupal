package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.AgregarFichas;

public class RondaAgregarTresFichas extends RondaAgregarFichas {

    public RondaAgregarTresFichas(Juego juego) {
        this.juego = juego;
        cantFichas = 3;
        acciones.add(new AgregarFichas(3));
    }


    public Ronda siguienteRonda(){
        return new RondaHostilidades(this.juego);
    }

    @Override
    public void resetearAcciones() {
    }

    @Override
    public Accion dameFase() {
        return acciones.get(0);
    }
}
