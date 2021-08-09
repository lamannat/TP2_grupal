package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.fichas.Ficha;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;

import java.util.ArrayList;
import java.util.List;

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
        //despues vamos a editar los constructores
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

    public String getNombre() {
        return nombre;
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paisesIniciales.add(pais);
    }

    public void setObjetivo(Objetivo objetivo){
        this.objetivos.add(objetivo);
    }


//    public int cuantosPaisesConquistados(){
//        return paisesIniciales.size();
//    }


    public void atacaUnPaisCon(Pais paisAtacante, Pais paisDefensor,Batalla unaBatalla) throws FichasInsuficientesException, NoEsLimitrofeException, AtaqueAPaisAliadoException {
        if (!paisesIniciales.contains(paisAtacante)) {
        // return PaisNoEncontradoExcepcion --> Puede Estar en Juego
        }
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

    public Color getColor(){
        return this.color;
    }

    public void colocarFichasEnPais(List<Ficha> fichas, Pais pais){
        //verificacion de que pais le pertenece ya se hizo
        pais.agregarFichas(fichas);
    }

    public int contarTotalFichas(){
        int total = this.fichasReservadas.size();

        for (Pais pais : paisesIniciales)
            total += pais.cantidadFichas();

        return total;
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

    public void agregarObjetivo(Objetivo objetivo) { objetivos.add(objetivo); }

    public boolean ganador() {
        return objetivos.stream().anyMatch(Objetivo::cumplido);
    }

    public List<Pais> getPaisAtacantes() {
        List<Pais> paises = new ArrayList<>();
        for (Pais pais : paisesIniciales)
            if (pais.fichasSuficientes())
                paises.add(pais);
        return paises;
    }

    public List<Pais> getPaisDeReagrupamiento() {
        List<Pais> paises = new ArrayList<>();
        for (Pais pais : paisesIniciales)
            if (pais.fichasSuficientesParaMover())
                paises.add(pais);
        return paises;
    }

    public List<Pais> getPaisesIniciales() {
        return paisesIniciales;
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

    public int cantidadFichasGanadas(Juego juego) {
        float cantPaisesConquistado = this.paisesIniciales.size();
        int fichasPorPaises = (int) Math.max(Math.floor(cantPaisesConquistado/2), 3);
        int fichasPorCartas = this.canjeador.canjearCartas();
        int fichasPorContinentes = juego.fichasPorContinente(this);

        return fichasPorCartas + fichasPorPaises + fichasPorContinentes;
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

    public void agregaFichasPorCartas() {
        canjeador.canjearConCartaPais(paisesIniciales, this);
    }

    public void prepararTropas() {
        for (Pais pais : paisesIniciales)
            pais.prepararTropas();
    }

    public List<Carta> getCartas() {
        return this.canjeador.getCartas();
    }

    public void conquistate(Pais pais) {
        this.paisesConquistados.add(pais);
    }
}
