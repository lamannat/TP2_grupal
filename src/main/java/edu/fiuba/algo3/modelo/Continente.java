package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
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

    public Integer cantidadPaisesConquistadosPorJugador(Jugador unJugador) {
        return (int) paises.stream().filter(paisActual -> paisActual.conquistadoPorJugador(unJugador)).count();
    }

    public Pais obtenerPaisNoAsignado() {
        return paises.stream().filter(limitrofe -> !limitrofe.estaAsignado()).findFirst().orElse(null);
    }
}
