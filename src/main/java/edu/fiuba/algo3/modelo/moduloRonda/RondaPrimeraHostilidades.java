package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Atacar;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Movimiento;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.SolicitarCarta;

public class RondaPrimeraHostilidades extends RondaHostilidades {

    public RondaPrimeraHostilidades(Juego juego) {
        super(juego);
        acciones.add(new Atacar());
        acciones.add(new Movimiento());
        acciones.add(new SolicitarCarta());
    }

    public Ronda siguienteRonda(){
        return new RondaHostilidadesGeneral(this.juego);
    }
}
/*
 * 5 fichas
 * 3 fichas
 * Ronda hostilidades
 * Ronda Incorporacion
 * Ronda hostilidades
 * Ronda Incorporacion
 */