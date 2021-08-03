package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pais implements Observable{

    private final String nombre;
    private final List<Pais> limitrofes;
    private final List<Ficha> fichas;
    private Jugador jugador;
    private final List<Observer> observers;

    private final static int cantidadMaximaDeDados = 3;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
        this.fichas = new ArrayList<>();
        this.jugador = null;
        this.observers = new ArrayList<>();
    }

    public void agregarPaisLimitrofe(Pais pais){
        if (!this.tienePaisLimitrofe(pais)) {
            this.limitrofes.add(pais);
            pais.agregarPaisLimitrofe(this);
        }
    }

    public void asignarJugador(Jugador unJugador) {
        this.jugador = unJugador;
    }
    
    public void agregarFichas(List<Ficha> fichas) {
        this.fichas.addAll(fichas);
    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    private void puedeAtacarAPais(Pais pais) throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        boolean fichasSuficientes = this.fichasSuficientes();
        if (!fichasSuficientes) { throw new FichasInsuficientesException(); }
        boolean esLimitrofe = this.tienePaisLimitrofe(pais);
        if (!esLimitrofe) { throw new NoEsLimitrofeException(); }
        boolean esAliado = esAliado(pais);
        if (esAliado) { throw new AtaqueAPaisAliadoException(); }
    }

    public boolean fichasSuficientes() {
        return this.fichas.size() > 1;
    }

    public boolean tienePaisLimitrofe(Pais pais) { return limitrofes.stream().anyMatch(estePais -> estePais == pais); }

    public boolean esAliado(Pais pais){
        return pais.conquistadoPorJugador(this.jugador);
    }

    public boolean tieneNombre(String unNombre){
        return this.nombre.equals(unNombre);
    }

    private EjercitoDeBatalla ejercitoParaDefensa()
    {
        List<Ficha> ejercito = new ArrayList<>();
        Integer cantidadDeFichas = Math.min(this.fichas.size(), cantidadMaximaDeDados);
        for (int i = 0; i < cantidadDeFichas; i++)
            ejercito.add(this.fichas.remove(0));
        return new EjercitoDeBatalla(ejercito);
    }

    private EjercitoDeBatalla ejercitoParaAtaque()
    {
        List<Ficha> ejercito = new ArrayList<>();
        Integer cantidadDeFichas = Math.min(this.fichas.size() - 1, cantidadMaximaDeDados);
        for (int i = 0; i < cantidadDeFichas; i++)
            ejercito.add(this.fichas.remove(0));
        return new EjercitoDeBatalla(ejercito);
    }

    public Integer fichasParaMover() {
        return Math.min(this.fichas.size() - 1, cantidadMaximaDeDados);
    }

    public void paisAtacaAPais(Pais paisDefensor, Batalla unaBatalla) throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        puedeAtacarAPais(paisDefensor);

        System.out.println(this.nombre + " ataca a " + paisDefensor.nombre);

        EjercitoDeBatalla ejercitoAtacante = this.ejercitoParaAtaque();
        EjercitoDeBatalla ejercitoDefensor = paisDefensor.ejercitoParaDefensa();

        unaBatalla.ejercitoAtacaAEjercito(ejercitoAtacante, ejercitoDefensor);

        this.agregarFichas(ejercitoAtacante.fichasRestantes());
        paisDefensor.agregarFichas(ejercitoDefensor.fichasRestantes());

        if (paisDefensor.fueConquistado()) {
            this.moverTropa(paisDefensor);
            paisDefensor.meConquisto(this.jugador);
            System.out.println(this.nombre + " conquisto a " + paisDefensor.nombre);
            this.jugador.merecesConseguirUnaCarta();
        }

        notifyObservers();
    }

    private void meConquisto(Jugador unJugador) {
        this.jugador.quitarPais(this);
        unJugador.agregarPais(this);
    }

    private boolean fueConquistado() {
        return fichas.isEmpty();
    }

    public void moverTropa(Pais paisDestino) {
        paisDestino.agregarFicha(this.fichas.remove(0));
    }

    public int cantidadFichas(){
        return fichas.size();
    }

    public boolean estaAsignado() {
        return this.jugador != null;
    }

    public boolean conquistadoPorJugador(Jugador jugador) {
        return this.jugador == jugador;
    }

    public List<Pais> getPaisesParaAtacar() {
        List<Pais> paisesParaAtacar = new ArrayList<>();
        for (Pais pais : limitrofes)
            try {
                this.puedeAtacarAPais(pais);
                paisesParaAtacar.add(pais);
            } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException e ) {
                // oh no, anyways
            }
        return paisesParaAtacar;
    }

    public List<Pais> getPaisesAleados() {
        List<Pais> paises = new ArrayList<>();
        for (Pais pais : this.limitrofes)
            if (pais.esAliado(this))
                paises.add(pais);
        return paises;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}



