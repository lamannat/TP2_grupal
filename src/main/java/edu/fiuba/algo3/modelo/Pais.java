package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pais {

    private final String nombre;
    private Limitrofes limitrofes;
    private String color;
    public int ejercitos;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new Limitrofes();
        this.ejercitos = 1;
    }

    public void agregarPaisLimitrofe(Pais pais){
        this.limitrofes.agregarPaisLimitrofe(pais);
    }
    //color corresponde a clase Ejercito
    public void setColor(String color){
        this.color = color;
    }

    //ejercitos corresponde a clase Ejercito
    public void agregarEjercitos(int cantidad){
        this.ejercitos += cantidad;
    }

    // cambiar el 3 para que sea una variable estatica final
    public int ejercitosParaAtaque(){
        return Math.min(this.ejercitos - 1, 3);
    }

    public int ejercitosParaDefensa(){
        return Math.min(this.ejercitos, 3);
    }

    public boolean puedeAtacar() {
        return this.ejercitos > 1;
    }

    public boolean perdioBatalla() {
        return this.ejercitos < 1;
    }

    public void pierdeEjercito(){
        this.ejercitos -= 1;
    }

    public void conquistadoPor(Pais pais) {
        pais.conquistar(this);
    }

    public void conquistar(Pais pais) {
        pais.setColor(this.color);
        pais.agregarEjercitos(1);
        this.ejercitos -= 1;
    }

    public boolean tienePaisLimitrofe(Pais pais) {
        return this.limitrofes.esLimitrofe(pais);
    }
}
