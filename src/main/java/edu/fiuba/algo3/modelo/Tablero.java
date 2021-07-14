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

        List<List<String>> continentesYPaises = LeerArchivo.leerListaDeListaDePaises("paisesEnContinentes.txt");
        List<List<String>> paisesYLimitrofes = LeerArchivo.leerListaDeListaDePaises("paisesLimitrofes.txt");

        for (List<String> actual: continentesYPaises){
            this.agregarContinentes(actual);
        }
        for (List<String> actual: paisesYLimitrofes){
            this.agregrarLimitrofes(actual);
        }
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
        return this.paises.get(0);
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
}