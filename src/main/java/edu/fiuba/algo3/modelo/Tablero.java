package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.Turno;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final List<Continente> continentes;

    public Tablero() {
        continentes = new ArrayList<>();
    }

    public Continente encontrarContinente(String nombreContinente) {
        for (Continente continente : this.continentes)
            if (continente.tieneNombre(nombreContinente))
                return continente;
        return null;
    }

    public void agregarContinente(Continente continente) {
        continentes.add(continente);
    }

    public Pais obtenerPaisNoAsignado() {
        for (Continente continente : continentes) {
            Pais paisNoAsignado = continente.obtenerPaisNoAsignado();
            if (paisNoAsignado != null)
                return paisNoAsignado;
        }
        return null;
    }

    public void asignarPaises(Turno turno) {
        Pais paisParaAsignar = obtenerPaisNoAsignado();
        while (paisParaAsignar != null) {
            Jugador jugadorActual = turno.jugadorActual();
            jugadorActual.agregarPais(paisParaAsignar);
            paisParaAsignar.agregarFichas(jugadorActual.generarFichas(1)); // cambiar feo
            paisParaAsignar = obtenerPaisNoAsignado();
            turno.avanzarJugador();
        }
    }

    public Pais getPaisPorNombre(String nombre) {
        for (Continente continente : continentes) {
            Pais pais = continente.getPaisPorNombre(nombre);
            if (pais != null)
                return pais;
        }
        return null;
    }

    public void addObserverAPaises(Observer observer){
        for (Continente continente : continentes) {
            continente.addObserverAPaises(observer);
        }
    }
}