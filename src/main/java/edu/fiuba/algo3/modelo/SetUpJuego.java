package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Mazo;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.modelo.moduloRonda.RondaAgregarCincoFichas;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
import edu.fiuba.algo3.modelo.objetivos.*;
import edu.fiuba.algo3.modelo.simbolo.Comodin;
import edu.fiuba.algo3.modelo.simbolo.SimboloNormal;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SetUpJuego implements Observable {
    private List<Observer> observers;
    private List<Pair<String, Color>> nombresYColores;
    private int cantidadJugadores;
    private final String OBJETIVO_ELIMINACION = "DESTRUIR";
//    private final String OBJETIVO_DOMINACION = "OCUPAR";   ver si uso
    private Juego juego;

    public SetUpJuego() {
        this.observers = new ArrayList<>();
        this.nombresYColores = new ArrayList<>();
        this.juego = null;
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

    private void resetearJuego() {
        this.observers = new ArrayList<>();
        this.nombresYColores = new ArrayList<>();
        this.juego = null;
    }

    public Juego dameJuego() {

        if (this.juego != null) {
            Juego juegoViejo = this.juego;
            resetearJuego();
            return juegoViejo;
        }

        Mazo mazo = new Mazo();
        List<Jugador> jugadores = listaDeJugadores(mazo);

        Turno turno = new Turno(jugadores);
        Tablero tablero = new Tablero();

        List<Pais> paises = new ArrayList<>();
        List<Continente> continentes = this.agregarContinentes(paises);
        this.agregarLimitrofes(paises);

        for (Continente continente : continentes)
            tablero.agregarContinente(continente);

        for (Carta carta : agregarCartas(paises))
            mazo.agregarCarta(carta);

        this.agregarObjetivos(continentes, turno);

        this.juego = new Juego(tablero, turno, new Batalla(new DadoEstandar()), mazo);
        this.juego.seleccionarRonda(new RondaAgregarCincoFichas(juego));

        return this.juego;
    }

    private List<Jugador> listaDeJugadores(Mazo mazo) {
        List<Jugador> jugadores = new ArrayList<>();

        for (Pair<String, Color> jugador : nombresYColores)
            jugadores.add(new Jugador(jugador.getKey(), jugador.getValue(), new Canjeador(mazo)));

        List<Integer> dadosTirados = new ArrayList<>();
        for (int i = 0; i < jugadores.size(); i++)
            dadosTirados.add(ThreadLocalRandom.current().nextInt(0, 6));
        Integer indiceMasBajo = 0;
        for (int i = 0; i < dadosTirados.size(); i++)
            if (dadosTirados.get(0) > dadosTirados.get(i))
                indiceMasBajo = i;
        for (int i = 0; i < indiceMasBajo; i++)
            jugadores.add(jugadores.remove(0));
        return jugadores;
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
            for (int i = 1; i < lineaPaises.size(); i++) {
                Pais paisVecino = buscarPais(paises, lineaPaises.get(i));
                if (paisVecino == null)
                    continue;
                paisActual.agregarPaisLimitrofe(paisVecino);
            }
        }
    }

    private List<Continente> agregarContinentes(List<Pais> paises) {

        List<Continente> continentes = new ArrayList<>();

        for (List<String> lineaContinente : LeerArchivo.leerArchivo("paisesEnContinentes.txt")) {
            Continente continente = new Continente(lineaContinente.get(0));
            continentes.add(continente);
            continente.setFichasPorConquistado(Integer.parseInt(lineaContinente.get(1)));
            for (int i = 2; i < lineaContinente.size(); i++)
            {
                Pais pais = new Pais(lineaContinente.get(i));
                paises.add(pais);
                continente.agregarPais(pais);
            }
        }

        return continentes;
    }

    private void agregarObjetivos(List<Continente> continentes, Turno turno) {
        List<List<String>> objetivosNoAsignados = LeerArchivo.leerArchivo("listaDeObjetivos.txt");
        Jugador primerJugador = turno.jugadorActual();

        do {
            Jugador jugadorActual = turno.jugadorActual();
            jugadorActual.agregarObjetivo(new ObjetivoComun(jugadorActual));

            List<String> lineaObjetivos = objetivosNoAsignados.remove(ThreadLocalRandom.current().nextInt(objetivosNoAsignados.size()));
            List<Objetivo> subObjetivos = new ArrayList<>();

            for (String lineaObjetivo : lineaObjetivos) {
                List<String> objetivo = new ArrayList<>(List.of(lineaObjetivo.split(":")));
                Objetivo subObjetivo = null;
                switch (objetivo.remove(0)) {
                    case "ocupar continente": subObjetivo = conquistarContiente(continentes, jugadorActual, objetivo); break;
                    case "ocupacion parcial": subObjetivo = conquistarParteDeContinente(continentes, jugadorActual, objetivo); break;
                    case "destruir": subObjetivo = destruirJugador(jugadorActual, turno, objetivo); break;
                }
                if (subObjetivo != null)
                    subObjetivos.add(subObjetivo);
            }
            jugadorActual.agregarObjetivo(new ObjetivoCompuesto(subObjetivos));

            turno.avanzarJugador();
        } while (turno.jugadorActual() != primerJugador);
    }

    private Objetivo destruirJugador(Jugador jugadorActual, Turno turno, List<String> objetivo) {
        String nombreColor = objetivo.get(0);

        Jugador jugadorAEliminar = null;
        turno.avanzarJugador();
        while (jugadorActual != turno.jugadorActual()) {
            if (turno.jugadorActual().getColor().getNombre().equals(nombreColor))
                jugadorAEliminar = turno.jugadorActual();
            turno.avanzarJugador();
        }
        if (jugadorAEliminar == null)
            jugadorAEliminar = turno.jugadorSiguiente();
        return new ObjetivoEliminarJugador(jugadorActual, jugadorAEliminar);
    }

    private Objetivo conquistarParteDeContinente(List<Continente> continentes, Jugador jugadorActual, List<String> objetivo) {
        List<String> detalles = List.of(objetivo.get(0).split(";"));
        Continente continente = buscarContinente(continentes, detalles.get(0));
        int cantidad = Integer.parseInt(detalles.get(1));
        if (continente == null || cantidad < 1)
            return null;
        return new ObjetivoCantidadPaisesEnContinente(continente, jugadorActual, cantidad);
    }

    private Objetivo conquistarContiente(List<Continente> continentes, Jugador jugadorActual, List<String> objetivo) {
        Continente continente = buscarContinente(continentes, objetivo.get(0));
        if (continente == null)
            return null;
        return new ObjetivoConquistaContinente(continente, jugadorActual);
    }

    private Continente buscarContinente(List<Continente> continentes, String nombreContinente) {
        for (Continente continente : continentes)
            if (continente.tieneNombre(nombreContinente))
                return continente;
        return null;
    }


    private Pais buscarPais(List<Pais> paises, String nombre) {
        for (Pais pais : paises)
            if (pais.tieneNombre(nombre))
                return pais;
        return null;
    }
}
