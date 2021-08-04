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

        this.agregarObjetivos(continentes,jugadores);

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

    private void agregarObjetivos(List<Continente> continentes,List<Jugador> jugadores) {
        List<List<String>> objetivosNoAsignados = LeerArchivo.leerArchivo("objetivos.txt");

        for (Jugador jugadorActual: jugadores) {
            List<Objetivo> subObjetivos = new ArrayList<>();
            jugadorActual.agregarObjetivo(new ObjetivoComun(jugadorActual));

            int indiceRandom = ThreadLocalRandom.current().nextInt(0, objetivosNoAsignados.size());
            List<String> objetivoActual = objetivosNoAsignados.remove(indiceRandom);

            if (objetivoActual.get(0).equals(OBJETIVO_ELIMINACION)) {
                Jugador jugadorRandom = jugadores.get(ThreadLocalRandom.current().nextInt(0, jugadores.size()));
                ObjetivoEliminarJugador objetivoEliminarJugador = new ObjetivoEliminarJugador(jugadorRandom);
                subObjetivos.add(objetivoEliminarJugador);
            }

            else {
                for (int i = 1; i < objetivoActual.size(); i+=2) {
                    Continente continente = this.buscarContinente(continentes,objetivoActual.get(i));
                    Integer cantidadPaises = Integer.parseInt(objetivoActual.get(i+1));
                    Objetivo obj;
                    if(cantidadPaises > 0) {
                        obj = new ObjetivoCantidadPaisesEnContinente(continente, jugadorActual, cantidadPaises);
                    }
                    else {
                        obj = new ObjetivoConquistaContinente(continente, jugadorActual);
                    }
                    subObjetivos.add(obj);
                }
            }
            jugadorActual.agregarObjetivo(new ObjetivoCompuesto(subObjetivos));
        }
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
