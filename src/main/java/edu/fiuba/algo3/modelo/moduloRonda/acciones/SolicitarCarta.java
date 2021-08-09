package edu.fiuba.algo3.modelo.moduloRonda.acciones;

import edu.fiuba.algo3.modelo.Jugador;

public class SolicitarCarta implements Accion {

    private final int minPaisesConquistados;

    public SolicitarCarta(int minPaisesConquistados){
        this.minPaisesConquistados = minPaisesConquistados;
    }

    @Override
    public void ejecutar(Jugador jugador) {
//        Boolean cumple = jugador.con
        jugador.merecesConseguirUnaCarta(minPaisesConquistados);

    }

    @Override
    public String ID() {
        return "solicitar carta";
    }
}
