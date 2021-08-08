package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Atacar;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Movimiento;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.SolicitarCarta;

public class RondaHostilidades extends Ronda {

    private int numeroAccion;

    public RondaHostilidades() {
        this.numeroAccion = 0;
        acciones.add(new Atacar());
        acciones.add(new Movimiento());
        acciones.add(new SolicitarCarta());
    }

    @Override
    public void comenzarLaRonda(Jugador jugador) {
        acciones.get(numeroAccion).ejecutar(jugador);
        this.notifyObservers();
        numeroAccion++;
    }

    @Override
    public boolean terminaste() {
        return numeroAccion == acciones.size();
    }

    @Override
    public void resetearAcciones() {
        numeroAccion = 0;
    }

    @Override
    public Accion dameFase() {
        return acciones.get(numeroAccion);
    }
}
