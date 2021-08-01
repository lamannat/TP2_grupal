package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Canjeador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {
    private final Button botonSiguiente;
    private final Juego juego;
    private int cantidadBoton;

    public BotonCantidadEventHandler(int unaCantidad, Juego juego, Button botonSiguiente) {
        this.cantidadBoton = unaCantidad;
        this.botonSiguiente = botonSiguiente;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonSiguiente.setVisible(true);
        juego.agregarJugadores(cantidadBoton); // tal vez cambiar
    }
}
