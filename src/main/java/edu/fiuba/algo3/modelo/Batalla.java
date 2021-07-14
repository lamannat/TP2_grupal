package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {
    private final Ejercitos defensor;
    private final Ejercitos atacante;

    public Batalla(Ejercitos defensor, Ejercitos atacante) {
        this.defensor = defensor;
        this.atacante = atacante;
    }
//
//    public void comenzarBatalla(Dado dado) {
//        List<Integer> dadosAtaque, dadosDefensa;
//
//        dadosAtaque = dado.tirarDados(atacante.ejercitosParaAtaque());
//        dadosDefensa = dado.tirarDados(defensor.ejercitosParaDefensa());
//
//        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
//        for (int i = 0; i < cantidadDeAtaques; i++){
//            if(dadosAtaque.get(i) > dadosDefensa.get(i))
//                defensor.pierdeContraEjercito(atacante);
//            else
//                atacante.pierdeContraEjercito(defensor);
//        }
//    }

//    private boolean batallaValida() {
//        boolean atacantePuedeLuchar = this.atacante.puedeAtacar();
//        boolean sonLimitrofes = this.atacante.tienePaisLimitrofe(this.defensor);
//        boolean esAliado = this.atacante.esAliado(this.defensor);
//
//        return atacantePuedeLuchar && sonLimitrofes && !esAliado;
//    }

    static void ejercitoAtacaAEjercito(Ejercitos atacante, Ejercitos defensor) {
        List<Integer> dadosAtaque, dadosDefensa;

        dadosAtaque = Dado.tirarDadosDeClase(atacante.ejercitosParaAtaque());
        dadosDefensa = Dado.tirarDadosDeClase(defensor.ejercitosParaDefensa());

        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
        for (int i = 0; i < cantidadDeAtaques; i++){
            if(dadosAtaque.get(i) > dadosDefensa.get(i))
                defensor.pierdeContraEjercito(atacante);
            else
                atacante.pierdeContraEjercito(defensor);
        }
    }
}
