package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Canjeador {
    private final List<Carta> cartas;
    private int numeroDeCanje;
    private final static int cantidadCartasConPatron = 3;

    public Canjeador() {
        this.cartas = new ArrayList<>();
        this.numeroDeCanje = 0;
    }

    public List<List<Carta>> generarMapaDeCartas() {
        List<List<Carta>> mapaCartas = new ArrayList<>();
        for (Carta cartaActual : this.cartas) {
            if (mapaCartas.stream().anyMatch(lista -> lista.get(0).sonIguales(cartaActual))) {
                mapaCartas.forEach(lista -> agregarCarta(lista, cartaActual));
            } else {
                List<Carta> lista = new ArrayList<>();
                lista.add(cartaActual);
                mapaCartas.add(lista);
            }
        }
        return mapaCartas;
    }

    private void agregarCarta(List<Carta> lista, Carta carta) {
        if (lista.isEmpty())
            return;
        if (lista.get(0).sonIguales(carta))
            lista.add(carta);
    }

    // Map<String, String> map = new HashMap<String, String>();
//    public Map<String, List<Carta>> generarMapaDeSimbolos() {
//        Map<String, List<Carta>> mapaSimbolos = new HashMap<String, List<Carta>>();
//        for (Carta cartaActual: this.cartas) {
//            if (!mapaSimbolos.containsKey(cartaActual.getSimbolo())) {
//                mapaSimbolos.put(cartaActual.getSimbolo(),new ArrayList<>());
//            }
//            List<Carta> cartas = mapaSimbolos.get(cartaActual.getSimbolo());
//            cartas.add(cartaActual);
//        }
//        return mapaSimbolos;
//    }

    public boolean verificarCanje() {
//        Map<String, List<Carta>> mapaSimbolos = generarMapaDeSimbolos();
        List<List<Carta>> mapaCartas = generarMapaDeCartas();

        if (sonDiferentes(mapaCartas))
            return true;
        return sonIguales(mapaCartas);

//        if (sonDiferentes(mapaSimbolos))
//            return true;
//
//        return sonIguales(mapaSimbolos);
    }

//    private boolean sonDiferentes(Map<String, List<Carta>> mapaSimbolos) {
//        if (mapaSimbolos.size() < cantidadCartasConPatron)
//            return false;
//        int i = 0;
//        for (List<Carta> cartasActuales : mapaSimbolos.values()) {
//            if (i >= cantidadCartasConPatron)
//                break;
//            cartasActuales.remove(0);
//            i++;
//        }
//        return true;
//    }

    private boolean sonDiferentes(List<List<Carta>> mapaCartas) {
        if (mapaCartas.size() < cantidadCartasConPatron)
            return false;
        int i = 0;
        for (List<Carta> cartasActuales : mapaCartas) {
            if (i >= cantidadCartasConPatron)
                break;
            cartasActuales.remove(0);
            i++;
        }
        return true;
    }

//    private boolean sonIguales(Map<String, List<Carta>> mapaSimbolos) {
//        for (List<Carta> cartasActuales : mapaSimbolos.values())
//            if (cartasActuales.size() >= cantidadCartasConPatron) {
//                cartasActuales.subList(0, cantidadCartasConPatron).clear();
//                return true;
//            }
//        return false;
//    }
    private boolean sonIguales(List<List<Carta>> mapaCartas) {
        for (List<Carta> cartasActuales : mapaCartas)
            if (cartasActuales.size() >= cantidadCartasConPatron) {
                cartasActuales.subList(0, cantidadCartasConPatron).clear();
                return true;
            }
        return false;
    }

    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    public int canjearCartas() {
        //canjeo se hace automaticamente

        if (cartas.size() < 3)
            return 0;
        if (!verificarCanje())
            return 0;

        this.numeroDeCanje++;
        return decidirNumeroFichas();
    }

    private int decidirNumeroFichas(){
        switch(this.numeroDeCanje){
            case 1: return 4;
            case 2: return 7;
            default: return (this.numeroDeCanje - 1) * 5;
        }
    }



}
