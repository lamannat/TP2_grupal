package edu.fiuba.algo3.controlador.accionesHandlers.incorporacion;

import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.incorporacion.BotonIncorporar;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownCantidadFichasIncorporarEventHandler implements EventHandler {

    private final DropDownAccion cantidadFichas;
    private final BotonIncorporar incorporar;

    public DropDownCantidadFichasIncorporarEventHandler(DropDownAccion cantidadFichas, BotonIncorporar incorporar) {
        this.cantidadFichas = cantidadFichas;
        this.incorporar = incorporar;
    }

    @Override
    public void handle(Event event) {
        if (cantidadFichas.getValue() == null || Integer.parseInt((String)cantidadFichas.getValue()) <= 0)
            return;

        incorporar.setCantidadDeFichas(Integer.parseInt((String)cantidadFichas.getValue()));
    }
}
