package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final List<Pais> paises;
    private final List<Continente> continentes;
    private List<Jugador> jugadores;

    public Tablero() {
        paises = new ArrayList<>();
        continentes = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador unJugador) {
        jugadores.add(unJugador);
    }


    private void agregarContinentes(List<String> continenteYPaises) {
        Continente continente = new Continente(continenteYPaises.get(0));

        for (int i = 1; i < continenteYPaises.size(); i++) {
            Pais pais = new Pais(continenteYPaises.get(i));
            continente.agregarPais(pais);
            paises.add(pais);
        }
    }

    private Pais encontrarPais(String nombrePais) {
        for (Pais pais : this.paises) {
            boolean esNombre = pais.tieneNombre(nombrePais);
            if (esNombre) {
                return pais;
            }
        }
    }

    private void agregrarLimitrofes(List<String> paisYLimitrofes) {

        String nombrePais = paisYLimitrofes.get(0);
        Pais pais = encontrarPais(nombrePais);

        for (int i = 1; i < paisYLimitrofes.size(); i++) {
            Pais limitrofe = encontrarPais(paisYLimitrofes.get(i));
            pais.agregarPaisLimitrofe(limitrofe);
        }
    }

    public void asignarPaises() {

        List<Pais> copiaPaises = new ArrayList<Pais>(this.paises);

        int contador = 0;
        while (copiaPaises.size() > 0) {
            int min = 0;
            int max = copiaPaises.size() - 1;
            int i = (int) Math.floor(Math.random() * (max - min + 1) + min);
            this.jugadores.get(contador).agregarPais(copiaPaises.get(i));
            copiaPaises.remove(i);
            contador = (contador + 1) % this.jugadores.size();
        }
    }


//    public Tablero(List<Jugadores> jugadores){
//
//        for (int i; i<3; i+=1){
//            Pais p = new Pais(nombresPaises[i]);
//            this.paises.add(p);
//        }
//        int paisesPorJugador = this.paises.size()/Jugadores.size();
//
//        tablero.repartirPaises(paisesPorJugador, jugadores);
//
//    }

}