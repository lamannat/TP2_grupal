package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {
    private Pais defensor;
    private Pais atacante;

    public Batalla(Pais defensor, Pais atacante) {
        this.defensor = defensor;
        this.atacante = atacante;
    }

    public void comenzarBatalla(Dado dado) {
        List<Integer> dadosAtaque, dadosDefensa;

        if (!this.atacante.puedeAtacar())
            return;

        dadosAtaque = dado.tirarDados(this.atacante.ejercitosParaAtaque());
        dadosDefensa = dado.tirarDados(this.defensor.ejercitosParaDefensa());

        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
        for (int i = 0; i < cantidadDeAtaques; i++){
            if(dadosAtaque.get(i) > dadosDefensa.get(i))
                this.defensor.pierdeEjercito();
            else
                this.atacante.pierdeEjercito();
        }

        if (this.defensor.perdioBatalla())
            this.defensor.conquistadoPor(this.atacante);
    }

}
