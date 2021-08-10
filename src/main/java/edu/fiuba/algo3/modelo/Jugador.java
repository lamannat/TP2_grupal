package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jugador implements Observable {

    private String nombre;
    private Color color;
    private final List<Pais> paisesIniciales;
    private final Canjeador canjeador;
    private boolean mereceCarta;
    private List<Pais> paisesConquistados;
    private final List<Ficha> fichasReservadas;
    private final List<Objetivo> objetivos;
    private List<Observer> observers;
    private Jugador jugadorAsesino;

    public Jugador(String nombre, Color color, Canjeador canjeador) {
        this.nombre = nombre;
        this.color = color;
        this.paisesIniciales = new ArrayList<>();
        this.fichasReservadas = new ArrayList<>();
        this.objetivos = new ArrayList<>();
        this.canjeador = canjeador;
        this.mereceCarta = false;
        this.paisesConquistados = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.jugadorAsesino = null;
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paisesIniciales.add(pais);
    }

    public void agregarObjetivo(Objetivo objetivo) {
        objetivos.add(objetivo);
    }

    public boolean ganador() {
        return objetivos.stream().anyMatch(Objetivo::cumplido);
    }

    public void atacaUnPaisCon(Pais paisAtacante, Pais paisDefensor, Batalla unaBatalla) throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        paisAtacante.paisAtacaAPais(paisDefensor,unaBatalla);
    }

    public void solicitarCarta(Carta carta) {
        mereceCarta = false;
        canjeador.agregarCartaPais(carta);
        agregaFichasPorCartas();
        notifyObservers();
    }

    public boolean merecesCarta() {
        return mereceCarta;
    }

    public void merecesConseguirUnaCarta(int minPaisesConquistados) {
        this.mereceCarta = (this.paisesConquistados.size() >= minPaisesConquistados);
    }

    public void resetearPaisesConquistados(){
        this.paisesConquistados.clear();
    }

    public void hacerCanjePorCarta(){
        int numeroDeFichas = this.canjeador.canjearCartas();
        this.fichasReservadas.addAll(this.generarFichas(numeroDeFichas));
    }

    public void colocarFichasEnPais(List<Ficha> fichas, Pais pais){
        pais.agregarFichas(fichas);
    }

    public int contarTotalFichas(){
        return paisesIniciales.stream().reduce(this.fichasReservadas.size(), (total, pais) -> total + pais.cantidadFichas(), Integer::sum);
    }

    public boolean quitarPais(Pais pais) {
        return this.paisesIniciales.remove(pais);
    }

    public void darFichas(List<Ficha> fichas) {
        this.fichasReservadas.addAll(fichas);
    }

    public List<Ficha> generarFichas(Integer cantFichas){
        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < cantFichas; i++)
            fichas.add(new Ficha());
        return fichas;
    }

    public boolean superaCantidadDePaises(int minimoDePaises) {
        return this.paisesIniciales.size() >= minimoDePaises;
    }

    public boolean seguisJugando() {
        return this.jugadorAsesino == null;
    }

    public boolean perdistePorJugador(Jugador jugador) {
        return this.jugadorAsesino == jugador;
    }

    public void setAsesino(Jugador jugador) {
        if (paisesIniciales.size() <= 0)
            this.jugadorAsesino = jugador;
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

    public int cantidadFichasGanadas(Juego juego) {
        float cantPaisesConquistado = this.paisesIniciales.size();
        int fichasPorPaises = (int) Math.max(Math.floor(cantPaisesConquistado/2), 3);
        int fichasPorCartas = this.canjeador.canjearCartas();
        int fichasPorContinentes = juego.fichasPorContinente(this);

        return fichasPorCartas + fichasPorPaises + fichasPorContinentes;
    }

    public void agregaFichasPorCartas() {
        canjeador.canjearConCartaPais(paisesIniciales, this);
    }

    public void prepararTropas() {
        paisesIniciales.forEach(Pais::prepararTropas);
    }

    public void agregarPaisConquistado(Pais pais) {
        this.paisesConquistados.add(pais);
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor(){
        return this.color;
    }

    public List<Pais> getPaisAtacantes() {
        return paisesIniciales.stream().filter(Pais::fichasSuficientes).collect(Collectors.toList());
    }

    public List<Pais> getPaisDeReagrupamiento() {
        return paisesIniciales.stream().filter(Pais::fichasSuficientesParaMover).collect(Collectors.toList());
    }

    public List<Pais> getPaisesIniciales() {
        return paisesIniciales;
    }


    public Integer cantidadFichasReservadas() {
        return fichasReservadas.size();
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

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    public List<Carta> getCartas() {
        return this.canjeador.getCartas();
    }
}
