package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;

public class JugadorPrueba extends Jugador {

    public int comiezaElAtaque;
    public int reagruparFuerzas;
    public int solicitarCartas;
    public int jugadorReclamaPorTarjetas;

    public JugadorPrueba(String nombre, Color color, Canjeador canjeador) {
        super(nombre, color, canjeador);
        comiezaElAtaque = 0;
        reagruparFuerzas = 0;
        solicitarCartas = 0;
        jugadorReclamaPorTarjetas = 0;
    }

    public boolean merecesCarta() {
        return true;
    }

    @Override
    public void comienzaElAtaque(Batalla unaBatalla) {
        comiezaElAtaque++;
    }

    @Override
    public void reagruparFuerzas() {
        reagruparFuerzas++;
    }

    @Override
    public void solicitarCarta(Carta carta) {
        solicitarCartas++;
    }

    @Override
    public void hacerCanjePorCarta() {
        jugadorReclamaPorTarjetas++;
    }
}
