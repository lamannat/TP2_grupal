package edu.fiuba.algo3.modelo;

enum Colores {
    ROJO,
    AZUL,
    MAGENTA,
    VERDE,
    AMARILLO,
    NEGRO
}

public class Ejercitos {
    private Colores color;
    public int ejercitos;
    private final static int cantidadMaximaDeEjercitos = 3;

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

    public void conquistadoPor(Ejercitos ejercitos) {
        ejercitos.conquistar(this);
        this.pierdeEjercitos(1);
    }

    private void conquistar(Ejercitos ejercitos) {
        ejercitos.setColor(this.color);
        ejercitos.agregarEjercitos(1);
    }

}