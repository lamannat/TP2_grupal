package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Canjeador {
    private final List<Carta> cartas;
    private int numeroDeCanje;

    public Canjeador() {
        this.cartas = new ArrayList<>();
        this.numeroDeCanje = 0;
    }

    // Map<String, String> map = new HashMap<String, String>();

    public Map<String, List<Carta>> generarMapaDeSimbolos() {
        Map<String, List<Carta>> mapaSimbolos = new HashMap<String, List<Carta>>();
        for (Carta cartaActual: this.cartas) {
            if (!mapaSimbolos.containsKey(cartaActual.getSimbolo())) {
                mapaSimbolos.put(cartaActual.getSimbolo(),new ArrayList<>());
            }
            List<Carta> cartas = mapaSimbolos.get(cartaActual.getSimbolo());
            cartas.add(cartaActual);
        }
        return mapaSimbolos;
    }

    public boolean verificarCanje() {
        Map<String, List<Carta>> mapaSimbolos = generarMapaDeSimbolos();

        boolean hayDiferentes = mapaSimbolos.size() >= 3;
        if (hayDiferentes) {
            int i = 0;
            for ( List<Carta> cartasActuales : mapaSimbolos.values() ) {
                if (i >= 3) {
                    break;
                }
                cartasActuales.remove(0);
                i++;
            }
            return true;
        }

        for ( List<Carta> cartasActuales : mapaSimbolos.values() ) {
            if (cartasActuales.size() >= 3) {
                cartasActuales.remove(0);
                cartasActuales.remove(0);
                cartasActuales.remove(0);
                return true;
            }
        }

        return false;
    }


    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    public int canjearCartas() {
        //canjeo se hace automaticamente

        if (cartas.size()<3) return 0;
        if (!verificarCanje()) return 0;

        this.numeroDeCanje++;
        return decidirNumeroFichas();
    }

    private List<List<Carta>> organizarCartas(){
        List<List<Carta>> cartasGlobal = new ArrayList<>();

        for (Carta carta: this.cartas){

            List<Carta> lista = simboloYaSeEncuentraEnGlobal(cartasGlobal,carta);
            lista.add(carta);
        }
        return cartasGlobal;
    }

    // listaGlobal = [[x,x],[y],[z,z]]
    private List<Carta> simboloYaSeEncuentraEnGlobal(List<List<Carta>> listaGlobal, Carta carta){
        for (List<Carta> listaCartas: listaGlobal){
            if (listaCartas.isEmpty())
                continue;
            if (carta.sosIgual(listaCartas.get(0))){
                return listaCartas;
            }
        }
        List<Carta> lista = new ArrayList<>();
        listaGlobal.add(lista);
        return lista;
    }

    private boolean cartasDiferentes(){
        List<List<Carta>> listaGlobal = organizarCartas();
        return listaGlobal.size()>=3;
    }

    private boolean cartasIguales(){
        for (Carta carta: this.cartas){
            int cantIguales = (int)this.cartas.stream().filter(carta::sosIgual).count();
            if (cantIguales >= 3) return true;
        }
        return false;
    }

    private int decidirNumeroFichas(){
        switch(this.numeroDeCanje){
            case 1:
                return 4;

            case 2:
                return 7;

            default:
                return (this.numeroDeCanje-1)*5;
        }
    }



}
