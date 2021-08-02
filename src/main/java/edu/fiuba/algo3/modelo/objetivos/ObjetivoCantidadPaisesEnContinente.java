package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoCantidadPaisesEnContinente implements Objetivo{
    private final Continente continente;
    private final int cantidad;
    private final Jugador jugador;

    public ObjetivoCantidadPaisesEnContinente(Continente continente, Jugador jugador, int cantidad) {
        this.continente = continente;
        this.jugador = jugador;
        this.cantidad = cantidad;
    }

    @Override
    public boolean cumplido() {
        return this.continente.conquistoCantidadDePaises(this.jugador, this.cantidad);
    }
}
