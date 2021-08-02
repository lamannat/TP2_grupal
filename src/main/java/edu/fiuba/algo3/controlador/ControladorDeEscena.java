package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Escena;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEscena {
    private int ordenDeEscena;
    private final List<Escena> listaDeEscenas;

    public ControladorDeEscena() {
        ordenDeEscena = 0;
        listaDeEscenas = new ArrayList<>();
    }

    public void agregarEscena(Escena escena) {
        listaDeEscenas.add(escena);
    }

    public Escena siguienteEscena() {
        Escena escena = listaDeEscenas.get(ordenDeEscena);
        ordenDeEscena++;
        ordenDeEscena = (ordenDeEscena + 1) % listaDeEscenas.size(); // despues q haga un return null y explote la compu poquito
        return escena;
    }
}
