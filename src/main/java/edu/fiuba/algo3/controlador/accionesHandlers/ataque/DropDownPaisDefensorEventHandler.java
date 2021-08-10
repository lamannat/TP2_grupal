package edu.fiuba.algo3.controlador.accionesHandlers.ataque;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.ataque.BotonAtacar;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownPaisDefensorEventHandler implements EventHandler {

    private final Juego juego;
    private final DropDownAccion dropDownPaisDefensor;
    private final BotonAtacar botonAtacar;

    public DropDownPaisDefensorEventHandler(Juego juego, DropDownAccion dropDownPaisDefensor, BotonAtacar botonAtacar) {
        this.juego = juego;
        this.dropDownPaisDefensor = dropDownPaisDefensor;
        this.botonAtacar = botonAtacar;
    }

    @Override
    public void handle(Event event) {
        Pais paisDefensor = juego.getPaisPorNombre((String)dropDownPaisDefensor.getValue());
        if (paisDefensor == null)
            return;

        botonAtacar.setPaisDefensor(paisDefensor);
    }
}
