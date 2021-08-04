package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public void agregarCartaPais(Carta carta) {
        cartas.add(carta);
    }

    private boolean hayPatronDeIguales() {
        for (Carta cartaActual : this.cartas) {
            List<Carta> listaIguales = cartas.stream().filter(cartaActual::sonIguales).collect(Collectors.toList());
            if (listaIguales.size() >= cantidadCartasConPatron) {
                for (Carta unaCarta : listaIguales){
                    cartas.remove(unaCarta);
                    unaCarta.devolverAlMazo(mazo);
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
                        unaCarta.devolverAlMazo(mazo);
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

    public void canjearConTarjetaPais(List<Pais> paisesDelJugador, Jugador jugador) {
        for (Pais pais : paisesDelJugador)
            for (Carta carta : cartas)
                pais.agregarFichas(jugador.generarFichas(carta.fichasPorPais(pais)));
    }
}
