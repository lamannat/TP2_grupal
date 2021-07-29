package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    private App app;
    Integer cantJugadores;

    public BotonComenzarEventHandler(App app) {
        this.app = app;
    }


    @Override
    public void handle(ActionEvent arg0) {
        this.app.ingresarJugadores();
    }
}
