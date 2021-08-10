package edu.fiuba.algo3.modelo.moduloRonda;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class Turno {
    List<Jugador> jugadores;
    private int indice;

    public Turno(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.resetear();
    }

    public Jugador jugadorActual(){
        return jugadores.get(indice);
    }

    //aca todos los jugadores estan vivos
    public Jugador jugadorSiguiente() {
        return jugadores.get((indice + 1) % jugadores.size());
    }

    public void avanzarJugador() {
        Jugador jugadorSiguiente = this.jugadorSiguiente();
        while (!jugadorSiguiente.seguisJugando()){
            indice = (indice + 1) % jugadores.size();
            jugadorSiguiente = this.jugadorSiguiente();

        }
        indice = (indice + 1) % jugadores.size();
    }

    public boolean ultimoJugador() {
        Jugador ultimoVivo = jugadores.get(jugadores.size()-1);
        int indiceUltimoVivo = jugadores.size()-1;
        while(!ultimoVivo.seguisJugando()){
            indiceUltimoVivo  -= 1;
            ultimoVivo = jugadores.get(indiceUltimoVivo);
        }
        return indice == indiceUltimoVivo;
    }

    public void resetear() {
        Jugador primerVivo = jugadores.get(0);
        int indicePrimerVivo = 0;
        while(!primerVivo.seguisJugando()){
            indicePrimerVivo  += 1;
            primerVivo = jugadores.get(indicePrimerVivo);
        }
        indice = indicePrimerVivo;
    }
}
