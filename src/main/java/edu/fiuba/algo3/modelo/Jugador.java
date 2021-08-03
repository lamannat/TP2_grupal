package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Jugador implements Observable {

    private String nombre;
    private Color color;
    private final List<Pais> paisesConquistados;
    private final Canjeador canjeador;
    private boolean conquisteEnRonda;
    private final List<Ficha> fichasReservadas;
    private final List<Objetivo> objetivos;
    private List<Observer> observers;

    public Jugador(String nombre, Color color, Canjeador canjeador) {
        //despues vamos a editar los constructores
        this.nombre = nombre;
        this.color = color;
        this.paisesConquistados = new ArrayList<>();
        this.fichasReservadas = new ArrayList<>();
        this.objetivos = new ArrayList<>();
        this.canjeador = canjeador;
        conquisteEnRonda = false;// ver posiblemente hacer esto en batalla/pais/algo no se
        this.observers = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paisesConquistados.add(pais);
    }

    public void setObjetivo(Objetivo objetivo){
        this.objetivos.add(objetivo);
    }


    public int cuantosPaisesConquistados(){
        return paisesConquistados.size();
    }


    public void atacaUnPaisCon(Pais paisAtacante, Pais paisDefensor,Batalla unaBatalla) throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        if (!paisesConquistados.contains(paisAtacante)) {
        // return PaisNoEncontradoExcepcion --> Puede Estar en Juego
        }
        paisAtacante.paisAtacaAPais(paisDefensor,unaBatalla);
    }

    public void comienzaElAtaque(Batalla unaBatalla) {
        // aca deberia estar interactuando con la GUI
    }

    public void reagruparFuerzas() {
    }

    public void solicitarCarta(Carta carta) {
        //cuando hiciste una conquista y te tinen que dar UNA carta
        canjeador.agregarCartaPais(carta);
    }

    public boolean merecesCarta() {
        return conquisteEnRonda;
    }

    public void hacerCanjePorCarta(){
        int numeroDeFichas = this.canjeador.canjearCartas();
        this.fichasReservadas.addAll(this.generarFichas(numeroDeFichas));
    }

    public Color getColor(){
        return this.color;
    }

    public void colocarFichasEnPais(List<Ficha> fichas, Pais pais){
        //verificacion de que pais le pertenece ya se hizo
        pais.agregarFichas(fichas);
    }

    public int contarTotalFichas(){
        int total = this.fichasReservadas.size();

        for (Pais pais : paisesConquistados)
            total += pais.cantidadFichas();

        return total;
    }

    public void quitarPais(Pais pais) {
        // deberia estar ese pais
        this.paisesConquistados.remove(pais);
    }

    public void darFichas(List<Ficha> fichas) {
        this.fichasReservadas.addAll(fichas);
    }

    public List<Ficha> generarFichas(Integer cantFichas){
        List<Ficha> fichas = new ArrayList<>();

        for (int i = 0; i < cantFichas; i++)
            fichas.add(new Ficha(color));

        return fichas;
    }

    public boolean superaCantidadDePaises(int minimoDePaises) {
        return this.paisesConquistados.size() >= minimoDePaises;
    }

    public boolean seguisJugando() {
        return paisesConquistados.size() > 0;
    }

    public void agregarObjetivo(Objetivo objetivo) { objetivos.add(objetivo); }

    public boolean ganador() {
        return objetivos.stream().anyMatch(Objetivo::cumplido);
    }

    public List<Pais> getPaisAtacantes() {
        List<Pais> paises = new ArrayList<>();
        for (Pais pais : paisesConquistados)
            if (pais.fichasSuficientes())
                paises.add(pais);
        return paises;
    }

    public List<Pais> getPaisesConquistados() {
        return paisesConquistados;
    }

    public void agregarFichasReservadasEnPais(Pais pais, Integer cantidad) {
        for (int i = 0; i < cantidad ; i++) {
            pais.agregarFicha(fichasReservadas.remove(0));
        }
        notifyObservers();
//        System.out.println("No seas trampos@");
    }

    public Integer cantidadFichasReservadas() {
        return fichasReservadas.size();
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
