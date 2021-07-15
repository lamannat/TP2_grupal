package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {

    static void ejercitoAtacaAEjercito(Ejercitos atacante, Ejercitos defensor) {
        List<Integer> dadosAtaque, dadosDefensa;

        dadosAtaque = TiradaDeDados.tirarDadosDeClase(atacante.ejercitosParaAtaque());
        dadosDefensa = TiradaDeDados.tirarDadosDeClase(defensor.ejercitosParaDefensa());

        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
        for (int i = 0; i < cantidadDeAtaques; i++){
            if(dadosAtaque.get(i) > dadosDefensa.get(i))
                defensor.pierdeContraEjercito(atacante);
            else
                atacante.pierdeContraEjercito(defensor);
        }
    }
}
