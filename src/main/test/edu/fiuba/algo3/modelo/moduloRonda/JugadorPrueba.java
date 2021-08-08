package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.fichas.Ficha;

import java.util.List;

public class JugadorPrueba extends Jugador {

    public int seLeDieronCartas;

    public JugadorPrueba(String nombre, Color color, Canjeador canjeador) {
        super(nombre, color, canjeador);
        seLeDieronCartas = 0;
    }

    public boolean merecesCarta() {
        return true;
    }

    @Override
    public void darFichas(List<Ficha> fichas) {
        seLeDieronCartas++;
    }
}
