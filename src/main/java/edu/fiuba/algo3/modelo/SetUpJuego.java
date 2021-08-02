package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import edu.fiuba.algo3.modelo.simbolo.Comodin;
import edu.fiuba.algo3.modelo.simbolo.Simbolo;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SetUpJuego implements Observable {
    private final List<Observer> observers;
    private final List<Pair<String, Color>> nombresYColores;
    private int cantidadJugadores;

    public SetUpJuego() {
        observers = new ArrayList<>();
        nombresYColores = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }

    public void asignarCantidadJugadores(int cantidad) {
        this.cantidadJugadores = cantidad;
        this.notifyObservers();
    }

    public int getCantidadJugadores() {
        return this.cantidadJugadores;
    }

    public void agregarJugador(String nombre, Color color) {
        nombresYColores.add(new Pair<>(nombre, color));
    }

    public Juego dameJuego() {

        Mazo mazo = new Mazo();
        List<Jugador> jugadores = new ArrayList<>();
        for (Pair<String, Color> jugador : nombresYColores)
            jugadores.add(new Jugador(jugador.getKey(), jugador.getValue(), new Canjeador(mazo)));

        Turno turno = new Turno(jugadores);
        Tablero tablero = new Tablero();

        List<Pais> paises = new ArrayList<>();
        List<Continente> continentes = this.agregarContinentes(paises);
        this.agregarLimitrofes(paises);

        for (Continente continente : continentes)
            tablero.agregarContinente(continente);

        for (Carta carta :  agregarCartas(paises))
            mazo.agregarCarta(carta);

        return new Juego(tablero, turno, new Batalla(new DadoEstandar()), mazo);
    }

    private List<Carta>  agregarCartas(List<Pais> paises) {
        List<Carta> cartas = new ArrayList<>();

        for (List<String> lineaCartas : LeerArchivo.leerArchivo("tegCartas.txt")) {
            Pais paisActual = buscarPais(paises, lineaCartas.get(0));
            if (paisActual == null)
                continue;
            String nombre = lineaCartas.get(1);

            Carta carta;
            if (nombre.equals("Comodin"))
                carta = new Carta(paisActual, new Comodin(nombre));
            else
                carta = new Carta(paisActual, new SimboloNormal(nombre));
            cartas.add(carta);
        }
        return cartas;
    }

    private void agregarLimitrofes(List<Pais> paises) {
        for (List<String> lineaPaises : LeerArchivo.leerArchivo("paisesLimitrofes.txt"))
        {
            Pais paisActual = buscarPais(paises, lineaPaises.get(0));
            if (paisActual == null)
                continue;
            for (int i = 1; i < lineaPaises.size() - 1; i++) {
                Pais paisVecino = buscarPais(paises, lineaPaises.get(i));
                if (paisVecino == null)
                    continue;
                paisActual.agregarPaisLimitrofe(paisVecino);
            }
        }
    }

    private Pais buscarPais(List<Pais> paises, String nombre) {
        for (Pais pais : paises)
            if (pais.tieneNombre(nombre))
                return pais;
        return null;
    }

    private List<Continente> agregarContinentes(List<Pais> paises) {

        List<Continente> continentes = new ArrayList<>();

        for (List<String> lineaContinente : LeerArchivo.leerArchivo("paisesEnContinentes.txt")) {
            Continente continente = new Continente(lineaContinente.get(0));
            continentes.add(continente);
            for (int i = 1; i < lineaContinente.size() - 1; i++)
            {
                Pais pais = new Pais(lineaContinente.get(i));
                paises.add(pais);
                continente.agregarPais(pais);
            }
        }

        return continentes;
    }
}
