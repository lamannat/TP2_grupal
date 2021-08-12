package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Escena;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEscena {
    private int ordenDeEscena;
    private final List<Escena> listaDeEscenas;
    private int anchoVentana;
    private int altoVentana;

    public ControladorDeEscena(int anchoVentana, int altoVentana) {
        ordenDeEscena = 0;
        listaDeEscenas = new ArrayList<>();
        this.altoVentana = altoVentana;
        this.anchoVentana = anchoVentana;
    }

    public void agregarEscena(Escena escena) {
        listaDeEscenas.add(escena);
    }

    public Escena siguienteEscena() {
        Escena escena = listaDeEscenas.get(ordenDeEscena);
        ordenDeEscena = (ordenDeEscena + 1) % listaDeEscenas.size();
        return escena;
    }

    public int getResolucionAncho(){
        return this.anchoVentana;
    }

    public int getResolucionAlto(){
        return this.altoVentana;
    }
}
