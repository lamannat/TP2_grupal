package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Atacar;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Incorporacion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Movimiento;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.SolicitarCarta;

public class RondaHostilidadesGeneral extends RondaHostilidades {

    public RondaHostilidadesGeneral(Juego juego) {
        super(juego);
        acciones.add(new Incorporacion(juego));
        acciones.add(new Atacar());
        acciones.add(new Movimiento());
        acciones.add(new SolicitarCarta());
    }

    public Ronda siguienteRonda(){
        return new RondaHostilidadesGeneral(this.juego);
    }
}
