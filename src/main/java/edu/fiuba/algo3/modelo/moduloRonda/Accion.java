package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

public interface Accion {
    void ejecutar(Jugador jugador);

    String ID();
}
