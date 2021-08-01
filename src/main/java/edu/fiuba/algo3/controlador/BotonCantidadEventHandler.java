package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {
    private final Button botonSiguiente;
    private int cantidadBoton;

    public BotonCantidadEventHandler(int unaCantidad,Button botonSiguiente) {
        this.cantidadBoton = unaCantidad;
        this.botonSiguiente = botonSiguiente;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonSiguiente.setVisible(true);
        //juego.setearJugadores(cantidadBoton); // tal vez cambiar
    }
}
