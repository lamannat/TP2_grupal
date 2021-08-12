package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.moduloRonda.Turno;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final List<Continente> continentes;

    public Tablero() {
        continentes = new ArrayList<>();
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
            paisParaAsignar.agregarFichas(jugadorActual.generarFichas(1));
            paisParaAsignar = obtenerPaisNoAsignado();
        }
        turno.resetear();
    }

    public Pais getPaisPorNombre(String nombre) {
        for (Continente continente : continentes)
            if (continente.getPaisPorNombre(nombre) != null)
                return continente.getPaisPorNombre(nombre);
        return null;
    }

    public void addObserverAPaises(Observer observer){
        continentes.forEach(continente -> continente.addObserverAPaises(observer));
    }

    public int fichasPorContinente(Jugador jugador) {
        int fichasTotales = 0;

        for (Continente continente : continentes)
            fichasTotales += continente.getFichasPorConquistado(jugador);

        return fichasTotales;
    }
}