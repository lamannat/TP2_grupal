package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {

    static void ejercitoAtacaAEjercito(EjercitoDeBatalla atacante, EjercitoDeBatalla defensor, Dado unDado) {

        TiradaDeDados tiradaAtacante = unDado.tirarDado(atacante.cantidadDeFichas());
        TiradaDeDados tiradaDefensor = unDado.tirarDado(defensor.cantidadDeFichas());

        while (!tiradaAtacante.tiradaVacia() && !tiradaDefensor.tiradaVacia()) {
            if (tiradaAtacante.primerResultadoMayor(tiradaDefensor))
                defensor.pierdeFicha();
            else
                atacante.pierdeFicha();

        }
    }
}
