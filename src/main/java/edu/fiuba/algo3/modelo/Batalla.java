package edu.fiuba.algo3.modelo;

import java.util.List;


public class Batalla {
    private Dado dado;

    public Batalla(Dado unDado){
        this.dado = unDado;
    }

    public void ejercitoAtacaAEjercito(EjercitoDeBatalla atacante, EjercitoDeBatalla defensor) {

        TiradaDeDados tiradaAtacante = this.dado.tirarDado(atacante.cantidadDeFichas());
        TiradaDeDados tiradaDefensor = this.dado.tirarDado(defensor.cantidadDeFichas());

        while (!tiradaAtacante.tiradaVacia() && !tiradaDefensor.tiradaVacia()) {
            if (tiradaAtacante.primerResultadoMayor(tiradaDefensor))
                defensor.pierdeFicha();
            else
                atacante.pierdeFicha();
        }
    }

//    public void cambiarDado(Dado unDado){
//        this.dado = unDado;
//    }
}
