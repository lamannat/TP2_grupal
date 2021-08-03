package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Continente {

    private final List<Pais> paises;
    private final String nombre;

    public Continente(String nombre) {
        this.nombre = nombre;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais) {
        paises.add(pais);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    public boolean conquistadoPorJugador(Jugador jugador) {
        return paises.stream().allMatch(paisActual -> paisActual.conquistadoPorJugador(jugador));
    }

    public boolean conquistoCantidadDePaises(Jugador unJugador, int cantidad) {
        return (int) paises.stream().filter(paisActual -> paisActual.conquistadoPorJugador(unJugador)).count() >= cantidad;
    }

    public Pais obtenerPaisNoAsignado() {
        Collections.shuffle(paises);
        return paises.stream().filter(limitrofe -> !limitrofe.estaAsignado()).findAny().orElse(null);
    }

    public Pais getPaisPorNombre(String nombre) {
        for (Pais pais : paises)
            if (pais.tieneNombre(nombre))
                return pais;
        return null;
    }

    public void addObserverAPaises(Observer observer){
        for (Pais pais : paises){
            pais.addObserver(observer);
        }
    }
}
