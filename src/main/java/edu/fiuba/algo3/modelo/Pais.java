package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private final String nombre;
    private final List<Pais> limitrofes;
    private final Ejercitos ejercitos;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
        this.ejercitos = new Ejercitos();
    }

    public void agregarPaisLimitrofe(Pais pais){
        if (!this.tienePaisLimitrofe(pais)) {
            this.limitrofes.add(pais);
            pais.agregarPaisLimitrofe(this);
        }
    }

    public void setColor(Colores color){
        ejercitos.setColor(color);
    }

    public void agregarEjercitos(int cantidad) {
        ejercitos.agregarEjercitos(cantidad);
    }

    private void puedeAtacarAPais(Pais pais) throws AtaqueInvalidoExcepcion, EjercitosInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        boolean puedeAtacar = this.ejercitos.puedeAtacar();
        boolean esLimitrofe = this.tienePaisLimitrofe(pais);
        boolean esAliado = esAliado(pais);

        boolean ataqueValido = puedeAtacar && esLimitrofe && !esAliado;

        if (!ataqueValido)
            throw new AtaqueInvalidoExcepcion(puedeAtacar, esLimitrofe, esAliado);
    }

    public boolean puedeAtacar() {
        return this.ejercitos.puedeAtacar();
    }

    public boolean tienePaisLimitrofe(Pais pais) { return limitrofes.stream().anyMatch(estePais -> estePais == pais); }

    public boolean esAliado(Pais pais){ return pais.tieneColor(this.ejercitos.getColor()); }

    public boolean tieneColor(Colores unColor) {
        return this.ejercitos.tieneColor(unColor);
    }

    public boolean perteneceAContinente(Continente continente){
        return continente.tienePais(this);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    public void paisAtacaAPais(Pais paisDefensor) throws AtaqueInvalidoExcepcion, EjercitosInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        puedeAtacarAPais(paisDefensor);
        paisDefensor.seDefiendeDe(this.ejercitos);
    }

    public void seDefiendeDe(Ejercitos ejercitoAtacante) {
        Batalla.ejercitoAtacaAEjercito(ejercitoAtacante, this.ejercitos);
    }
}



