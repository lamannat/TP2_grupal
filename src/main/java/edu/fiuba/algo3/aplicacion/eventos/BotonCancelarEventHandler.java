package edu.fiuba.algo3.aplicacion.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonCancelarEventHandler implements EventHandler<ActionEvent> {

    private Stage ventana;

    public BotonCancelarEventHandler(Stage ventanaSalir){
        this.ventana = ventanaSalir;
    }

    public void handle(ActionEvent arg0) {
        ventana.close();
    }
}
