package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private final String nombre;
    private final List<Pais> limitrofes;
    private final Ejercito ejercito;
    private final List<Ficha> fichas;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
        this.ejercito = new Ejercito();
        this.fichas = new ArrayList<>();
    }

    public void agregarPaisLimitrofe(Pais pais){
        if (!this.tienePaisLimitrofe(pais)) {
            this.limitrofes.add(pais);
            pais.agregarPaisLimitrofe(this);
        }
    }

    public void setColor(Color color){
        this.fichas.forEach(ficha -> { ficha.setColor(color);});
//        ejercito.setColor(color);
    }

    public void agregarFichas(List<Ficha> fichas) {
//        ejercito.agregarEjercitos(fichas);
        this.fichas.addAll(fichas);
    }

    private void puedeAtacarAPais(Pais pais) throws AtaqueInvalidoExcepcion, FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        boolean fichasSuficientes = this.fichasSuficientes();
//        boolean puedeAtacar = this.ejercito.puedeAtacar();
        boolean esLimitrofe = this.tienePaisLimitrofe(pais);
        boolean esAliado = esAliado(pais);

        boolean ataqueValido = fichasSuficientes && esLimitrofe && !esAliado;

        if (!ataqueValido)
            throw new AtaqueInvalidoExcepcion(fichasSuficientes, esLimitrofe, esAliado);
    }

    public boolean fichasSuficientes() {
        return this.fichas.size() > 1;
//        return this.ejercito.puedeAtacar();
    }

    public boolean tienePaisLimitrofe(Pais pais) { return limitrofes.stream().anyMatch(estePais -> estePais == pais); }

    public boolean esAliado(Pais pais){
        return pais.tieneColor(this.fichas.get(0).getColor());
//        return pais.tieneColor(this.ejercito.getColor());
    }

    public boolean tieneColor(Color unColor) {
        return this.fichas.get(0).getColor().tieneColor(unColor);
//        return this.ejercito.tieneColor(unColor);
    }

    public boolean perteneceAContinente(Continente continente){
        return continente.tienePais(this);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    public void paisAtacaAPais(Pais paisDefensor) throws AtaqueInvalidoExcepcion, FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        puedeAtacarAPais(paisDefensor);
        paisDefensor.seDefiendeDe(this.ejercito);
    }

    public void seDefiendeDe(Ejercito ejercitoAtacante) {
        Batalla.ejercitoAtacaAEjercito(ejercitoAtacante, this.ejercito);
    }
}



