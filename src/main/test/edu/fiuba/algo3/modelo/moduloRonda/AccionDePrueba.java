package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;

import java.util.ArrayList;
import java.util.List;

public class AccionDePrueba implements Accion {

    private List<Jugador> jugadores;

    public AccionDePrueba() {
        jugadores = new ArrayList<>();
    }

    @Override
    public void ejecutar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public boolean comprobar(int cantidad, Jugador jugador) {
        return jugadores.stream().filter(jugador::equals).count() == cantidad;
    }

    @Override
    public String ID() {
        return null;
    }
}
