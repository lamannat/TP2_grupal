package edu.fiuba.algo3.aplicacion.eventos;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAceptarEventHandler implements EventHandler<ActionEvent> {

    public void handle(ActionEvent arg0) {
        Platform.exit();
    }
}
