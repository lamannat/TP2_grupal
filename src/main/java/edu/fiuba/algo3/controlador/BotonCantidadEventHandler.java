package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.SetUpJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {
    private final Button botonSiguiente;
    private int cantidadBoton;
    private final SetUpJuego setUp;

    public BotonCantidadEventHandler(SetUpJuego setUp, int unaCantidad, Button botonSiguiente) {
        this.cantidadBoton = unaCantidad;
        this.botonSiguiente = botonSiguiente;
        this.setUp = setUp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonSiguiente.setVisible(true);
        setUp.asignarCantidadJugadores(cantidadBoton);
        //juego.setearJugadores(cantidadBoton); // tal vez cambiar
    }
}
