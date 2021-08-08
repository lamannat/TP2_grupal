package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.AgregarFichas;

public class RondaAgregarTresFichas extends RondaAgregarFichas {

    public RondaAgregarTresFichas() {
        cantFichas = 3;
        acciones.add(new AgregarFichas(3));
    }

    @Override
    public Accion dameFase() {
        return acciones.get(0);
    }
}
