package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.*;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private final String nombre;
    private final List<Pais> limitrofes;
    private final List<Ficha> fichas;

    private final static int cantidadMaximaDeDados = 3;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
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
    }

    public void agregarFichas(List<Ficha> fichas) {
        this.fichas.addAll(fichas);
    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    private void puedeAtacarAPais(Pais pais) throws AtaqueInvalidoExcepcion, FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        boolean fichasSuficientes = this.fichasSuficientes();
        boolean esLimitrofe = this.tienePaisLimitrofe(pais);
        boolean esAliado = esAliado(pais);

        boolean ataqueValido = fichasSuficientes && esLimitrofe && !esAliado;

        if (!ataqueValido)
            throw new AtaqueInvalidoExcepcion(fichasSuficientes, esLimitrofe, esAliado);
    }

    public boolean fichasSuficientes() {
        return this.fichas.size() > 1;
    }

    public boolean tienePaisLimitrofe(Pais pais) { return limitrofes.stream().anyMatch(estePais -> estePais == pais); }

    public boolean esAliado(Pais pais){
        return pais.tieneColor(this.fichas.get(0).getColor());
    }

    public boolean tieneColor(Color unColor) {
        if (this.fichas.isEmpty())
            return false;
        return this.fichas.get(0).getColor().tieneColor(unColor);
    }

    public boolean perteneceAContinente(Continente continente){
        return continente.tienePais(this);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    private EjercitoDeBatalla ejercitoParaDefensa()
    {
        List<Ficha> ejercito = new ArrayList<>();
        for (int i = 0; i < Math.min(this.fichas.size(), cantidadMaximaDeDados); i++)
            ejercito.add(this.fichas.remove(0));
        return new EjercitoDeBatalla(ejercito);
    }

    private EjercitoDeBatalla ejercitoParaAtaque()
    {
        List<Ficha> ejercito = new ArrayList<>();
        for (int i = 0; i < Math.min(this.fichas.size() - 1, cantidadMaximaDeDados); i++)
            ejercito.add(this.fichas.remove(0));
        return new EjercitoDeBatalla(ejercito);
    }

    public void paisAtacaAPais(Pais paisDefensor, Dado unDado) throws AtaqueInvalidoExcepcion, FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        puedeAtacarAPais(paisDefensor);

        EjercitoDeBatalla ejercitoAtacante = this.ejercitoParaAtaque();
        EjercitoDeBatalla ejercitoDefensor = paisDefensor.ejercitoParaDefensa();

        Batalla.ejercitoAtacaAEjercito(ejercitoAtacante, ejercitoDefensor, unDado);

        this.agregarFichas(ejercitoAtacante.fichasRestantes());
        paisDefensor.agregarFichas(ejercitoDefensor.fichasRestantes());

        if (paisDefensor.fueConquistado())
            this.moverTropas(paisDefensor);
    }

    private boolean fueConquistado() {
        return fichas.isEmpty();
    }

    private void moverTropas(Pais paisDestino) {
        paisDestino.agregarFicha(this.fichas.remove(0));
    }


}



