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
        if (!this.limitrofes.esLimitrofe(pais))
            this.limitrofes.agregarPaisLimitrofe(pais);
        if (!pais.tienePaisLimitrofe(this))
            pais.agregarPaisLimitrofe(this);
    }

    public Ejercitos atacoConEjercito() { return ejercitos; } //Este metodo deberia ser privado y solo usarse para llamar a Batalla. Refactorizar Batalla

    public void agregarEjercitos(int cantidad) {
        ejercitos.agregarEjercitos(cantidad);
    }

    public boolean puedeAtacar() {
        return this.ejercitos.puedeAtacar();
    }

//    public void conquista(Pais conquistado) {
//        Ejercitos ejercitoConquistado = conquistado.atacoConEjercito();
//        this.ejercitos.conquista(ejercitoConquistado);
//    }

    public boolean tienePaisLimitrofe(Pais pais) {
        return this.limitrofes.esLimitrofe(pais);
    }

    public boolean tieneColor(Colores unColor) { return this.ejercitos.tieneColor(unColor); }

    public void atacaPais(Pais pais, Dado dado) {
        if (!puedeAtacarAPais(pais))
            return;

        Ejercitos ejercitoDefensor = pais.atacoConEjercito();
        Ejercitos ejercitoAtacante = this.ejercitos;

        Batalla batalla = new Batalla(ejercitoDefensor, ejercitoAtacante);
        batalla.comenzarBatalla(dado);
    }

    private boolean puedeAtacarAPais(Pais pais) {
        boolean puedeAtacar = this.ejercitos.puedeAtacar();
        boolean esLimitrofe = this.limitrofes.esLimitrofe(pais);
        boolean esAleado = esAliado(pais);

        return puedeAtacar && esLimitrofe && !esAleado;
    }

    public boolean esAliado(Pais pais){
        return pais.tieneColor(this.ejercitos.getColor());
    }
}



