package edu.fiuba.algo3.controlador.accionesHandlers.batalla;

import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.batalla.BotonBatalla;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownBatallaEventHandler implements EventHandler {

    private final DropDownAccion dropDown;
    private final BotonBatalla botonBatalla;

    public DropDownBatallaEventHandler(DropDownAccion dropDown, BotonBatalla botonBatalla) {
        this.dropDown = dropDown;
        this.botonBatalla = botonBatalla;
    }

    @Override
    public void handle(Event event) {
        if (dropDown.getValue() == null || Integer.parseInt((String)dropDown.getValue()) <= 0)
            return;

        botonBatalla.setCantidadDeFichas(Integer.parseInt((String)dropDown.getValue()));
    }
}
