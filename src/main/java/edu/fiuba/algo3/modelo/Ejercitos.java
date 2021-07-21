package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercitos {
    public List<Ficha> fichas;
    private final static int cantidadMaximaDeDados = 3;

    public Ejercitos() {
        this.fichas = new ArrayList<>();
        Ficha ficha = new Ficha(Colores.NO_ASIGNADO);
        fichas.add(ficha);
    }

    public void setColor(Colores color) {
        this.fichas.forEach(ficha -> { ficha.setColor(color);});
    }

    public Colores getColor(){
        return this.fichas.get(0).getColor();
    }

    public void agregarEjercitos(int cantidad, ) {
        for (int i = 0; i < cantidad; i++) {
            Ficha ficha = new Ficha(this.getColor());
            this.fichas.add(ficha);
        }
    }

    public int ejercitosParaAtaque() {
        return Math.min(this.fichas.size() - 1, cantidadMaximaDeDados);
    }

    public int ejercitosParaDefensa() {
        return Math.min(this.fichas.size(), cantidadMaximaDeDados);
    }

    public boolean tieneColor(Colores unColor) { return this.getColor().equals(unColor); }

    public boolean puedeAtacar() {
        return this.fichas.size() > 1;
    }

    public void conquista(Ejercitos conquistado) {
        conquistado.setColor(this.getColor());
        this.moverTropa(conquistado);
    }

    public void moverTropa(Ejercitos destino) {
        Ficha ficha = this.fichas.remove(0);

        destino.agregarEjercitos(1);
    }

    public void pierdeContraEjercito(Ejercitos conquistador) {
        this.fichas.remove(0);
        if (this.fichas.size() < 1)
            conquistador.conquista(this);
    }

    public boolean esAliado(Ejercitos unEjercito){
        return (this.getColor() == unEjercito.getColor());
    }

}
