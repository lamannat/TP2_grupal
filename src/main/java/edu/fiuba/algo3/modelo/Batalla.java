package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {

    static void ejercitoAtacaAEjercito(EjercitoDeBatalla atacante, EjercitoDeBatalla defensor, Dado unDado) {
//        List<Integer> dadosAtaque, dadosDefensa;

//        dadosAtaque = TiradaDeDados.tirarDadosDeClase(atacante.cantidadDeFichas());
//        dadosDefensa = TiradaDeDados.tirarDadosDeClase(defensor.cantidadDeFichas());

        TiradaDeDados tiradaAtacante = unDado.tirarDado(atacante.cantidadDeFichas());
        TiradaDeDados tiradaDefensor = unDado.tirarDado(defensor.cantidadDeFichas());

        while (!tiradaAtacante.tiradaVacia() && !tiradaDefensor.tiradaVacia()) {
            if (tiradaAtacante.primerResultadoMayor(tiradaDefensor))
                defensor.pierdeFicha();
            else
                atacante.pierdeFicha();

        }


//        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
//        for (int i = 0; i < cantidadDeAtaques; i++){
//            if(dadosAtaque.get(i) > dadosDefensa.get(i))
//                defensor.pierdeFicha();
//            else
//                atacante.pierdeFicha();
//        }
    }
}
