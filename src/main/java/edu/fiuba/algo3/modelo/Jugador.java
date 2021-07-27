package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private final Color color;
    private final List<Pais> paisesConquistados;
    private final Canjeador canjeador;
    private boolean conquisteEnRonda;
    private List<Ficha> fichasReservadas;

    public Jugador(String nombre, Color color, Canjeador canjeador) {
        //despues vamos a editar los constructores
        this.nombre = nombre;
        this.color = color;
        this.paisesConquistados = new ArrayList<>();
        this.fichasReservadas = new ArrayList<>();
        this.canjeador = canjeador; //esta malo crear cosas >:(
        conquisteEnRonda = false; //reemplazar tal vez en canjeador ficsmi
    }


    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.paisesConquistados = new ArrayList<>();
        this.fichasReservadas = new ArrayList<>();
        this.canjeador = new Canjeador(); //esta malo crear cosas >:(
        conquisteEnRonda = false; //reemplazar tal vez en canjeador ficsmi
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paisesConquistados.add(pais);
//        pais.setColor(this.color);
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
//        conquisteEnRonda = false;
//        List<Pais> copiaPaises = new ArrayList<Pais>(this.paisesConquistados);
//
//        for (Pais pais : copiaPaises) {
//            List<Pais> paisesDisponibles = pais.paisesDisponiblesParaAtacar();
//            for (Pais paisAtacado : paisesDisponibles) {
//                try {
//                    pais.paisAtacaAPais(paisAtacado, unaBatalla);
//                    // checkear si conquisto ey
//                } catch (FichasInsuficientesException e) {
//                    break;
//                } catch (NoEsLimitrofeException | AtaqueAPaisAliadoException e) {
//                    continue;
//                }
//            }
//        }
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

//    public void hacerCanje() {
//        colocarFichas(canjeador.canjearCartas());
//    }


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

//    public void colocarFichas(List<Ficha> fichas) {
//        // che donde y cuantas ---> poner x fichas en x pais()
//        this.fichasReservadas.addAll(fichas);
//        // por ahora le agrega las fichas a los paises de forma "aleatoria" FIcsme
//        // this.paisesConquistados.get(0).agregarFichas(fichas);
//    }

    public int contarTotalFichas(){
        int total =this.fichasReservadas.size();
        for (Pais pais : paisesConquistados){
            total += pais.cantidadFichas();
        }
        return total;
    }

    public void quitarPais(Pais pais) {
        if(!this.paisesConquistados.remove(pais))
            System.out.println("Que Pais?"); ///////////////hacer algo con esto
    }

    public void darFichas(List<Ficha> fichas) {
        this.fichasReservadas.addAll(fichas);
    }

    public List<Ficha> generarFichas(Integer cantFichas){
        List<Ficha> fichas = new ArrayList<>();

        for (int i = 0; i<cantFichas; i++){
            fichas.add(new Ficha(color));
        }
        return fichas;
    }
}
