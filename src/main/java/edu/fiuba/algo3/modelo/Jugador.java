package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoCompuesto;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Observable {

    private String nombre;
    private Color color;
    private final List<Pais> paisesConquistados;
    private final Canjeador canjeador;
    private boolean mereceCarta;
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
        mereceCarta = false;
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

    public void solicitarCarta(Carta carta) {
        mereceCarta = false;
        if (paisesConquistados.stream().anyMatch(carta::tienePais))
            this.fichasReservadas.addAll(this.generarFichas(2)); // cambiar este numero magico
        canjeador.agregarCartaPais(carta);
    }

    public boolean merecesCarta() {
        return mereceCarta;
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

    public boolean quitarPais(Pais pais) {
        return this.paisesConquistados.remove(pais);
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
        for (int i = 0; i < cantidad ; i++)
            pais.agregarFicha(fichasReservadas.remove(0));
        notifyObservers();
    }

    public void moverTropasAPais(Pais actual, Pais destino, Integer cantidad) {
        for (int i = 0; i < cantidad ; i++)
            actual.moverTropa(destino);
        notifyObservers();
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

    public void merecesConseguirUnaCarta() {
        mereceCarta = true;
    }

    public int cantidadFichasGanadas(Juego juego) {

        float cantPaisesConquistado = this.paisesConquistados.size();
        int fichasPorPaises = (int) Math.max(Math.floor(cantPaisesConquistado/2), 3);
        int fichasPorCartas = this.canjeador.canjearCartas();
        int fichasPorContinentes = juego.fichasPorContinente(this);

        return fichasPorCartas + fichasPorPaises + fichasPorContinentes;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Objetivo getObjetivoCompuesto() {
        return objetivos.get(1);
    }
}
