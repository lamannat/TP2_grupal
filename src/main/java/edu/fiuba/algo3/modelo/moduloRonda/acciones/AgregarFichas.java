package edu.fiuba.algo3.modelo.moduloRonda.acciones;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

public class AgregarFichas implements Accion {
    private final Integer cantFichas;

    public AgregarFichas(Integer cantFichas){
        this.cantFichas = cantFichas;
    }

    @Override
    public void ejecutar(Jugador jugador) {
        jugador.darFichas(jugador.generarFichas(cantFichas));
    }

    @Override
    public String ID() {
        return "incorporar fichas";
    }
}
