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

//    public boolean conquistadoPor(Color unColor) {
//        return paises.stream().allMatch(paisActual -> paisActual.tieneColor(unColor));
//    }

    public boolean conquistadoPorJugador(Jugador jugador) {
        return paises.stream().allMatch(paisActual -> paisActual.conquistadoPorJugador(jugador));
    }

    public Integer cantidadPaisesConquistadosPorJugador(Jugador unJugador) {

        return (int)this.paises.stream().filter(paisActual -> paisActual.conquistadoPorJugador(unJugador)).count();

//        int cantidadFinal = 0;
//        for (Pais paisActual: paises) {
//            if(paisActual.conquistadoPorJugador(unJugador)) {
//                cantidadFinal++;
//            }
//        }
//        return cantidadFinal;
    }

//    public int cantidadPaisesConquistadosPor(Color unColor) {
//        int cantidadFinal = 0;
//        for (Pais paisActual: paises) {
//            if(paisActual.tieneColor(unColor)) {
//                cantidadFinal++;
//            }
//        }
//        return cantidadFinal;
//    }

//    public boolean sinPaisesDe(Jugador jugador) {
//        return this.cantidadPaisesConquistadosPorJugador(jugador) == 0;
//    }

//    public boolean sinPaisesDe(Color unColor) {
//        return this.cantidadPaisesConquistadosPor(unColor) == 0;
//    }
//    public boolean tienePais(Pais pais){ return paises.contains(pais); }

    public Pais obtenerPaisNoAsignado() {
        for (Pais pais : paises)
            if (!pais.estaAsignado())
                return pais;
        return null;
    }
}
