package edu.fiuba.algo3.modelo;

public class Ejercitos {
    private Colores color;
    public int ejercitos;
    private final static int cantidadMaximaDeEjercitos = 3; //esto esta mal, es la cantidad maxima de dados, no de ejercitos.

    public Ejercitos(Colores color) {
        setColor(color);
        this.ejercitos = 1;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    // es solo un wrapper de sumar y restar
    public void agregarEjercitos(int cantidad) {
        this.ejercitos += cantidad;
    }

    public void pierdeEjercitos(int cantidad) {

        this.ejercitos -= cantidad;
    }

    public int ejercitosParaAtaque() {
        return Math.min(this.ejercitos - 1, cantidadMaximaDeEjercitos);
    }

    public int ejercitosParaDefensa() {
        return Math.min(this.ejercitos, cantidadMaximaDeEjercitos);
    }

    public boolean tieneColor(Colores unColor) { return this.color.equals(unColor); }

    public boolean puedeAtacar() {
        return this.ejercitos > 1;
    }

    public boolean perdioBatalla() {
        return this.ejercitos < 1;
    }

    public void conquista(Ejercitos conquistado) {
        conquistado.setColor(this.color);
        conquistado.agregarEjercitos(1);
        this.pierdeEjercitos(1);
    }

    public Colores getColor(){
        return this.color;
    }

    public boolean esAliado(Ejercitos unEjercito){
        return (this.color == unEjercito.getColor());
    }

}
