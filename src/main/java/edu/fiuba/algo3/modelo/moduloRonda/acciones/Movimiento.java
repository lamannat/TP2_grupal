package edu.fiuba.algo3.modelo.moduloRonda.acciones;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

public class Movimiento implements Accion {
    @Override
    public void ejecutar(Jugador jugador) {
        jugador.prepararTropas();
    }

    @Override
    public String ID() {
        return "reagrupar";
    }
}
