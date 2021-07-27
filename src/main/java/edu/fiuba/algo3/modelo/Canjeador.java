package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


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
        System.out.println("MAPA DE CARTAS IGUALES:" + mapaCartas);
        return mapaCartas;
    }


    private void agregarCarta(List<Carta> lista, Carta carta) {
        if (lista.isEmpty())
            return;
        if (lista.get(0).sonIguales(carta))
            lista.add(carta);
    }

    public boolean verificarCanje() {
        List<List<Carta>> mapaCartas = generarMapaDeCartas();

        System.out.println("Voy a verificar");
        if (sonDiferentes(mapaCartas))
            return true;
        return sonIguales(mapaCartas);

    }


    private boolean sonDiferentes(List<List<Carta>> mapaCartas) {
        if (mapaCartas.size() < cantidadCartasConPatron)
            return false;
        int i = 0;
        for (List<Carta> cartasActuales : mapaCartas) {
            if (i >= cantidadCartasConPatron)
                break;
            this.cartas.remove(cartasActuales.get(0));
            i++;
        }
        return true;
    }


    private boolean sonIguales(List<List<Carta>> mapaCartas) {
        for (List<Carta> cartasActuales : mapaCartas)
            if (cartasActuales.size() >= cantidadCartasConPatron) {
                for (int i = 0; i < cantidadCartasConPatron; i++) {
                    this.cartas.remove(cartasActuales.get(i));
                }
                return true;
            }
        return false;
    }

    private boolean hayPatronDeIguales() {
        List<Carta> listaIguales = new ArrayList<>();
        for (Carta carta : this.cartas) {
            listaIguales = (List<Carta>) this.cartas.stream().filter(carta::sonIguales);
            if (listaIguales.size() >= cantidadCartasConPatron) {
                for (int i = 0; i < cantidadCartasConPatron; i++)
                    this.cartas.remove(listaIguales.get(i));
                return true;
            }
        }
        return false;
    }

    private boolean hayPatronDeDiferentes() {
        return false;
    }

    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    public int canjearCartas() {
        //canjeo se hace automaticamente
        System.out.println("CARTAS ANTES DE CANJEAR:" + cartas);
        if (cartas.size() < 3)
            return 0;
        if (!hayPatronDeIguales() && !hayPatronDeDiferentes())
            return 0;
        System.out.println("CARTAS DESPUES DE CANJEAR:" + cartas);
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
