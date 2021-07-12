package edu.fiuba.algo3.modelo;

import java.util.List;

public class Batalla {
    private final Pais defensor;
    private final Pais atacante;

    public Batalla(Pais defensor, Pais atacante) {
        this.defensor = defensor;
        this.atacante = atacante;
    }

    public void comenzarBatalla(Dado dado) {
        List<Integer> dadosAtaque, dadosDefensa;

        if (!batallaValida())
            return;

        Ejercitos ejercitoAtacante = atacante.atacoConEjercito();
        Ejercitos ejercitoDefensor = defensor.atacoConEjercito();

        dadosAtaque = dado.tirarDados(ejercitoAtacante.ejercitosParaAtaque());
        dadosDefensa = dado.tirarDados(ejercitoDefensor.ejercitosParaDefensa());

        int cantidadDeAtaques = Math.min(dadosAtaque.size(), dadosDefensa.size());
        for (int i = 0; i < cantidadDeAtaques; i++){
            if(dadosAtaque.get(i) > dadosDefensa.get(i))
                ejercitoDefensor.pierdeEjercitos(1);
            else
                ejercitoAtacante.pierdeEjercitos(1);
        }

        if (ejercitoDefensor.perdioBatalla())
            this.defensor.conquistadoPor(this.atacante);
    }

    private boolean batallaValida() {
        boolean atacantePuedeLuchar = this.atacante.puedeAtacar();
        boolean sonLimitrofes = this.atacante.tienePaisLimitrofe(this.defensor);

        return atacantePuedeLuchar && sonLimitrofes;
    }

}
