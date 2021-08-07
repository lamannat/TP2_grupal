package edu.fiuba.algo3.controlador.accionesHandlers.movimiento;

import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.movimiento.BotonMoverTropas;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownCantidadFichasMovimientoEventHandler implements EventHandler {

    private final DropDownAccion cantidadFichas;
    private final BotonMoverTropas moverTropas;

    public DropDownCantidadFichasMovimientoEventHandler(DropDownAccion cantidadFichas, BotonMoverTropas moverTropas) {
        this.cantidadFichas = cantidadFichas;
        this.moverTropas = moverTropas;
    }

    @Override
    public void handle(Event event) {
        if (cantidadFichas.getValue() == null || Integer.parseInt((String)cantidadFichas.getValue()) <= 0)
            return;

        moverTropas.setCantidadDeFichas(Integer.parseInt((String)cantidadFichas.getValue()));
    }
}
