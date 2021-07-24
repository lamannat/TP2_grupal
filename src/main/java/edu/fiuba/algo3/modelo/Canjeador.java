package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Canjeador {
    private final List<Carta> cartas;
    private int numeroDeCanje;
    private Jugador jugador;

    public Canjeador(Jugador jugador) {
        this.cartas = new ArrayList<>();
        this.numeroDeCanje = 0;
        this.jugador = jugador;
    }

    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    public List<Ficha> canjearCartas() {
        //canjeo se hace automaticamente

        if (cartas.size()<3) return new ArrayList<>();
        if (!cartasIguales() && !cartasDiferentes()) return new ArrayList<>();

        this.numeroDeCanje++;
        int cant = decidirNumeroFichas();
        List<Ficha> fichas = GeneradorFichas.generar(cant, jugador.getColor());

        return new ArrayList<>();
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
