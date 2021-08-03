package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

public class AgregarFichas implements Accion{
    private final Integer cantFichas;

    public AgregarFichas(Integer cantFichas){
        this.cantFichas = cantFichas;
    }

    @Override
    public void ejecutar(Jugador jugador) {
        jugador.darFichas(jugador.generarFichas(cantFichas));
        System.out.println(cantFichas);
    }

    @Override
    public String ID() {
        return "AgregarFichas";
    }
}
