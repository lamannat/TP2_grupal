package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private final List<Pais> paises;
    private final List<Continente> continentes;
    private final List<Carta> cartasPais;

    public Tablero() {
        paises = new ArrayList<>();
        continentes = new ArrayList<>();
        cartasPais = new ArrayList<>();

        for (List<String> continentes : LeerArchivo.leerArchivo("paisesEnContinentes.txt"))
            this.agregarContinentes(continentes);

        for (List<String> pais : LeerArchivo.leerArchivo("paisesLimitrofes.txt"))
            this.agregrarLimitrofes(pais);

        for (List<String> carta : LeerArchivo.leerArchivo("tegCartas.txt"))
            this.agregrarCartas(carta);
    }


    private void agregarContinentes(List<String> continenteYPaises) {
        Continente continente = new Continente(continenteYPaises.get(0));
        this.continentes.add(continente);

        for (int i = 1; i < continenteYPaises.size(); i++) {
            Pais pais = new Pais(continenteYPaises.get(i));
            continente.agregarPais(pais);
            paises.add(pais);
        }
    }


    private Pais encontrarPais(String nombrePais) {
        for (Pais pais : this.paises)
            if (pais.tieneNombre(nombrePais))
                return pais;
        return null;
    }

    public Continente encontrarContinente(String nombreContinente) {
        for (Continente continente : this.continentes)
            if (continente.tieneNombre(nombreContinente))
                return continente;
        return null;
    }

    private void agregrarLimitrofes(List<String> paisYLimitrofes) {

        String nombrePais = paisYLimitrofes.get(0);
        Pais pais = encontrarPais(nombrePais);

        for (int i = 1; i < paisYLimitrofes.size(); i++) {
            Pais limitrofe = encontrarPais(paisYLimitrofes.get(i));
            pais.agregarPaisLimitrofe(limitrofe);
        }
    }

    private void agregrarCartas(List<String> carta) {
        String nombrePais = carta.get(0);
        Pais pais = encontrarPais(nombrePais);

        String tipoCarta = carta.get(1);
        cartasPais.add(new Carta(pais,tipoCarta));
    }

    public void asignarPaises(Turno turno) {

        List<Pais> copiaPaises = new ArrayList<Pais>(this.paises);

        while (copiaPaises.size()>0){
            int i = (int) Math.floor(Math.random() * copiaPaises.size());
            Jugador jugadorActual = turno.jugadorActual();
            Color color = jugadorActual.getColor();
            Pais paisActual = copiaPaises.remove(i);
            paisActual.agregarFichas(GeneradorFichas.generar(1,color));
            jugadorActual.agregarPais(paisActual);
        }
    }
}