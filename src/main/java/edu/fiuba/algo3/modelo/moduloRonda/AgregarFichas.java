package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

public class AgregarFichas implements Accion{
    private final Integer cantFichas;
    private final Juego juego;

    public AgregarFichas(Integer cantFichas, Juego juego){
        this.cantFichas = cantFichas;
        this.juego = juego;
    }

    @Override
    public void ejecutar(Jugador jugador) {

//        min(3, cantPais/2);
        int cantidadFichasTotal = jugador.cantidadFichasGanadas(juego) + cantFichas;

        jugador.darFichas(jugador.generarFichas(cantidadFichasTotal));
    }

    @Override
    public String ID() {
        return "AgregarFichas";
    }
}
