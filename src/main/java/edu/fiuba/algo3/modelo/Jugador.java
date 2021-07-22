package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.color.Color;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String nombre;
    private final Color color;
    private List<Pais> paises;

    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.paises = new ArrayList<>();
    }

    public void agregarPais(Pais pais){
        pais.asignarJugador(this);
        this.paises.add(pais);
        pais.setColor(this.color);
    }

    public int cuantosPaisesConquistados(){
        return paises.size();
    }

    public void comienzaElAtaque(Dado unDado) {
        List<Pais> copiaPaises = new ArrayList<Pais>(this.paises);

        for (Pais pais : copiaPaises) {
            List<Pais> paisesDisponibles = pais.paisesDisponiblesParaAtacar();
            for (Pais paisAtacado : paisesDisponibles) {
                try {
                    pais.paisAtacaAPais(paisAtacado,unDado);
                } catch (FichasInsuficientesException e) {
                    break;
                } catch (NoEsLimitrofeException | AtaqueAPaisAliadoException e) {
                    continue;
                }
            }
        }
    }

    public void reagruparFuerzas() {
    }

    public void solicitarTarjeta() {
    }
    public Color getColor(){
        return this.color;
    }

    public void colocarFichas(List<Ficha> fichas) {
        // por ahora le agrega las fichas a los paises de forma "aleatoria" FIcsme
        this.paises.get(0).agregarFichas(fichas);
    }

    public int contarTotalFichas(){
        int total = 0;
        for (Pais pais : paises){
            total += pais.cantidadFichas();
        }
        return total;
    }

    public void quitarPais(Pais pais) {
        if(!this.paises.remove(pais))
            System.out.println("Que Pais?");
    }
}
