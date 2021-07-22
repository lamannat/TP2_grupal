package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private final Color color;
    private final List<Pais> paises;

    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais){
        this.paises.add(pais);
        pais.setColor(this.color);
    }

    public int cuantosPaisesConquistados(){
        return paises.size();
    }

    public void comienzaElAtaque() {
        //this.elegirPais();
    }

    public void reagruparFuerzas() {
    }

    public void solicitarTarjeta() {
    }
    public Color getColor(){
        return this.color;
    }

    public void colocarFichas(List<Ficha> fichas) {
        // por ahora le agrega las fichas a los paises de forma "aleatoria"
        for (int i = 0; i < fichas.size(); i++)
            paises.get(i % paises.size()).agregarFicha(fichas.get(i));
    }

    public int contarTotalFichas(){
        int total = 0;
        for (Pais pais : paises){
            total += pais.cantidadFichas();
        }
        return total;
    }
}
