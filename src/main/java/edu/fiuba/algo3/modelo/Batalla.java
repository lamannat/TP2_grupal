package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {

    static void ejercitoAtacaAEjercito(EjercitoDeBatalla atacante, EjercitoDeBatalla defensor) {
        List<Integer> dadosAtaque, dadosDefensa;

        dadosAtaque = TiradaDeDados.tirarDadosDeClase(atacante.cantidadDeFichas());
        dadosDefensa = TiradaDeDados.tirarDadosDeClase(defensor.cantidadDeFichas());

        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
        for (int i = 0; i < cantidadDeAtaques; i++){
            if(dadosAtaque.get(i) > dadosDefensa.get(i))
                defensor.pierdeFicha();
            else
                atacante.pierdeFicha();
        }
    }
}
