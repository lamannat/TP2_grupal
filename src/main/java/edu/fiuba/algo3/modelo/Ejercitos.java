package edu.fiuba.algo3.modelo;

public class Ejercitos {
    private Colores color;
    public int ejercitos;
    private final static int cantidadMaximaDeDados = 3;

    public Ejercitos(Colores color) {
        setColor(color);
        this.ejercitos = 1;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public void agregarEjercitos(int cantidad) {
        this.ejercitos += cantidad;
    }

    public int ejercitosParaAtaque() {
        return Math.min(this.ejercitos - 1, cantidadMaximaDeDados);
    }

    public int ejercitosParaDefensa() {
        return Math.min(this.ejercitos, cantidadMaximaDeDados);
    }

    public boolean tieneColor(Colores unColor) { return this.color.equals(unColor); }

    public boolean puedeAtacar() {
        return this.ejercitos > 1;
    }

    public void conquista(Ejercitos conquistado) {
        conquistado.setColor(this.color);
        this.moverTropa(conquistado);
    }

    public void moverTropa(Ejercitos destino) {
        this.ejercitos -= 1;
        destino.agregarEjercitos(1);
    }

    public void pierdeContraEjercito(Ejercitos conquistador) {
        this.ejercitos -= 1;
        if (this.ejercitos < 1)
            conquistador.conquista(this);
    }

    public Colores getColor(){
        return this.color;
    }

    public boolean esAliado(Ejercitos unEjercito){
        return (this.color == unEjercito.getColor());
    }

}
