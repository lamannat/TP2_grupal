package edu.fiuba.algo3.aplicacion.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {

    private int cantidad;

    public BotonCantidadEventHandler(int cantidad) {
        this.cantidad = cantidad;
    }

    public void handle(ActionEvent event) {

    }
}
