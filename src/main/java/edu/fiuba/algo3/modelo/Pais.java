package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pais {

    private final String nombre;
    private final Limitrofes limitrofes;
    private final Ejercitos ejercitos;

    public Pais(String nombre, Colores color) {
        this.nombre = nombre;
        this.limitrofes = new Limitrofes();
        this.ejercitos = new Ejercitos(color);
    }

    public void agregarPaisLimitrofe(Pais pais){
        this.limitrofes.agregarPaisLimitrofe(pais);
    }

    public Ejercitos atacoConEjercito() {
        return ejercitos;
    }

    public void agregarEjercitos(int cantidad) {
        ejercitos.agregarEjercitos(cantidad);
    }

    public boolean puedeAtacar() {
        return this.ejercitos.puedeAtacar();
    }

    public boolean perdioBatalla() {
        return this.ejercitos.perdioBatalla();
    }

    public void conquistadoPor(Pais pais) {
        Ejercitos ejercito = pais.atacoConEjercito();
        ejercito.conquistadoPor(this.ejercitos);
    }

    public boolean tienePaisLimitrofe(Pais pais) {
        return this.limitrofes.esLimitrofe(pais);
    }
}
