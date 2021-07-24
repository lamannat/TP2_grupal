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

    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.paisesConquistados = new ArrayList<>();
        this.canjeador = new Canjeador();
        conquisteEnRonda = false;
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paisesConquistados.add(pais);
//        pais.setColor(this.color);
    }

    public int cuantosPaisesConquistados(){
        return paisesConquistados.size();
    }

    public void comienzaElAtaque(Batalla unaBatalla) {
        conquisteEnRonda = false;
        List<Pais> copiaPaises = new ArrayList<Pais>(this.paisesConquistados);

        for (Pais pais : copiaPaises) {
            List<Pais> paisesDisponibles = pais.paisesDisponiblesParaAtacar();
            for (Pais paisAtacado : paisesDisponibles) {
                try {
                    pais.paisAtacaAPais(paisAtacado, unaBatalla);
                    // checkear si conquisto ey
                } catch (FichasInsuficientesException e) {
                    break;
                } catch (NoEsLimitrofeException | AtaqueAPaisAliadoException e) {
                    continue;
                }
//                System.out.printf("Pais atacante: %s\n",pais.nombre);
//                System.out.printf("Pais defensor: %s\n",paisAtacado.nombre);
//                System.out.println();
            }
        }
    }

    public void reagruparFuerzas() {
    }

    public void solicitarCarta(List<Carta> cartas) {
        for (Carta carta : cartas)
            canjeador.agregarCartaPais(carta);
    }

    public boolean merecesCarta() {
        return conquisteEnRonda;
    }

    public void hacerCanje() {
        colocarFichas(canjeador.canjearCartas());
    }

    public Color getColor(){
        return this.color;
    }

    public void colocarFichas(List<Ficha> fichas) {
        // por ahora le agrega las fichas a los paises de forma "aleatoria" FIcsme
        this.paisesConquistados.get(0).agregarFichas(fichas);
    }

    public int contarTotalFichas(){
        int total = 0;
        for (Pais pais : paisesConquistados){
            total += pais.cantidadFichas();
        }
        return total;
    }

    public Integer cantidadDePaisesConquistados() {
        return paisesConquistados.size();
    }

    public void quitarPais(Pais pais) {
        if(!this.paisesConquistados.remove(pais))
            System.out.println("Que Pais?");
    }
}
