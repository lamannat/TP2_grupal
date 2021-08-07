package edu.fiuba.algo3.controlador.accionesHandlers.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.movimiento.BotonMoverTropas;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownPaisDestinoMovimientoEventHandler implements EventHandler {

    private final Juego juego;
    private final DropDownAccion dropDownPaisDestino;
    private final BotonMoverTropas moverTropas;

    public DropDownPaisDestinoMovimientoEventHandler(Juego juego, DropDownAccion dropDownPaisDestino, BotonMoverTropas moverTropas) {
        this.juego = juego;
        this.dropDownPaisDestino = dropDownPaisDestino;
        this.moverTropas = moverTropas;
    }

    @Override
    public void handle(Event event) {
        Pais paisDestino = juego.getPaisPorNombre((String)dropDownPaisDestino.getValue());
        if (paisDestino == null)
            return;

        moverTropas.setPaisDestino(paisDestino);
    }
}
