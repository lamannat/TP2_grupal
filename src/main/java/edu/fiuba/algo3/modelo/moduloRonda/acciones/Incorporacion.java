package edu.fiuba.algo3.modelo.moduloRonda.acciones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

public class Incorporacion implements Accion {

    private final Juego juego;

    public Incorporacion(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void ejecutar(Jugador jugador) {
        jugador.darFichas(jugador.generarFichas(jugador.cantidadFichasGanadas(juego)));
    }

    @Override
    public String ID() {
        return "incorporar fichas";
    }
}
