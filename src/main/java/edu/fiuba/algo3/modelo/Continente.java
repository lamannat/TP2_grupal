package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Continente {

    private final List<Pais> paises;
    private final String nombre;
    private int fichasPorConquistado;

    public Continente(String nombre) {
        this.nombre = nombre;
        this.paises = new ArrayList<>();
        this.fichasPorConquistado = 0;
    }

    public void agregarPais(Pais pais) {
        paises.add(pais);
    }

    public boolean conquistadoPorJugador(Jugador jugador) {
        return paises.stream().allMatch(paisActual -> paisActual.conquistadoPorJugador(jugador));
    }

    public void setFichasPorConquistado(int cantidadFichas) {
        fichasPorConquistado = cantidadFichas;
    }

    public int getFichasPorConquistado(Jugador jugador) {
        return (conquistadoPorJugador(jugador) ? fichasPorConquistado : 0);
    }

    public boolean conquistoCantidadDePaises(Jugador unJugador, int cantidad) {
        return (int) paises.stream().filter(paisActual -> paisActual.conquistadoPorJugador(unJugador)).count() >= cantidad;
    }

    public Pais obtenerPaisNoAsignado() {
        Collections.shuffle(paises);
        return paises.stream().filter(limitrofe -> !limitrofe.estaAsignado()).findAny().orElse(null);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    public Pais getPaisPorNombre(String nombre) {
        return paises.stream().filter(pais -> pais.tieneNombre(nombre)).findFirst().orElse(null);
    }

    public void addObserverAPaises(Observer observer) {
        paises.forEach(pais -> pais.addObserver(observer));
    }

    public String getNombre() {
        return nombre;
    }
}
