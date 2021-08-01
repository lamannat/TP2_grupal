package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Canjeador {
    private final List<Carta> cartas;
    private final Mazo mazo;
    private int numeroDeCanje;
    private final static int cantidadCartasConPatron = 3;

    public Canjeador(Mazo unMazo) {
        this.cartas = new ArrayList<>();
        this.mazo = unMazo;
        this.numeroDeCanje = 0;
    }

    public void agregarCartaPais(Carta carta) { cartas.add(carta); }

    private boolean hayPatronDeIguales() {
        for (Carta cartaActual : this.cartas) {
            List<Carta> listaIguales = cartas.stream().filter(cartaActual::sonIguales).collect(Collectors.toList());
            if (listaIguales.size() >= cantidadCartasConPatron) {
                for (Carta unaCarta : listaIguales){
                    cartas.remove(unaCarta);
                    mazo.agregarCarta(unaCarta);
                }
                return true;
            }
        }
        return false;
    }

    private boolean hayPatronDeDiferentes() {
        List<Carta> listaDiferentes = new ArrayList<>();
        for (Carta cartaActual : this.cartas) {
            listaDiferentes.add(cartaActual);
            for(Carta cartaAuxiliar: this.cartas) {
                if (listaDiferentes.size() >= cantidadCartasConPatron) {
                    for (Carta unaCarta : listaDiferentes) {
                        cartas.remove(unaCarta);
                        mazo.agregarCarta(unaCarta);
                    }
                    return true;
                }
                if( listaDiferentes.stream().noneMatch(carta -> carta.sonIguales(cartaAuxiliar)) )
                    listaDiferentes.add(cartaAuxiliar);
            }
            listaDiferentes.clear();
        }
        return false;
    }

    public int canjearCartas() { //canjeo se hace automaticamente
        if (cartas.size() < 3)
            return 0;
        if (!hayPatronDeIguales() && !hayPatronDeDiferentes())
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

    public Canjeador getInstanciaNueva() {
        return new Canjeador(mazo);
    }

}
