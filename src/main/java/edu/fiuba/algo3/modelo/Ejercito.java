package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
//    public List<Ficha> fichas;
//    private final static int cantidadMaximaDeDados = 3;
//
//    public Ejercito() {
//        this.fichas = new ArrayList<>();
//        Ficha ficha = new Ficha(new ColorNoAsignado());
//        fichas.add(ficha);
//    }
//
//    public void setColor(Color color) {
//        this.fichas.forEach(ficha -> { ficha.setColor(color);});
//    }
//
//    public Color getColor(){
//        return this.fichas.get(0).getColor();
//    }
//
//    public void agregarEjercitos(List<Ficha> fichas) {
//        this.fichas.addAll(fichas);
//    }
//
//    public int ejercitosParaAtaque() {
//        return Math.min(this.fichas.size() - 1, cantidadMaximaDeDados);
//    }
//
//    public int ejercitosParaDefensa() {
//        return Math.min(this.fichas.size(), cantidadMaximaDeDados);
//    }
//
//    public boolean tieneColor(Color unColor) { return this.getColor().tieneColor(unColor); }
//
//    public boolean puedeAtacar() {
//        return this.fichas.size() > 1;
//    }
//
//    public void conquista(Ejercito conquistado) {
//        conquistado.setColor(this.getColor());
//        this.moverTropa(conquistado);
//    }
//
//    public void moverTropa(Ejercito destino) {
//        List<Ficha> fichas = new ArrayList<>();
//        fichas.add(this.fichas.remove(0));
//        destino.agregarEjercitos(fichas);
//    }
//
//    public void pierdeContraEjercito(Ejercito conquistador) {
//        this.fichas.remove(0);
//        if (this.fichas.size() < 1)
//            conquistador.conquista(this);
//    }
//
//    public boolean esAliado(Ejercito unEjercito){
//        return (this.getColor() == unEjercito.getColor());
//    }

}
