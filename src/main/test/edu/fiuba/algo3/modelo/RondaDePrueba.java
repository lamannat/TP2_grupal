package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.Ronda;

public class RondaDePrueba extends Ronda {

    public int cantDeReseteos = 0;

    public void resetearAcciones() {
        cantDeReseteos++;
    }
}
