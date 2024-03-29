package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPaisEventHandler implements EventHandler<ActionEvent> {

    private final VistaJuego vistaJuego;
    private final Pais pais;

    public BotonPaisEventHandler(VistaJuego vistaJuego, Pais pais) {

        this.pais = pais;
        this.vistaJuego = vistaJuego;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.vistaJuego.setDropDown(this.pais);
    }
}
