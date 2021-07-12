package edu.fiuba.algo3.modelo;

public class Ejercitos {
    private String color;
    public int ejercitos;
    private final static int cantidadMaximaDeEjercitos = 3;

    public Ejercitos(String color) {
        setColor(color);
        this.ejercitos = 1;
    }

    public void setColor(String color) {
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

    public boolean puedeAtacar() {
        return this.ejercitos > 1;
    }

    public boolean perdioBatalla() {
        return this.ejercitos < 1;
    }

    public void conquistadoPor(Ejercitos ejercitos) {
        ejercitos.conquistar(this);
    }

    public void conquistar(Ejercitos ejercitos) {
        ejercitos.setColor(this.color);
        ejercitos.agregarEjercitos(1);
        ejercitos.pierdeEjercitos(1);
    }

}
