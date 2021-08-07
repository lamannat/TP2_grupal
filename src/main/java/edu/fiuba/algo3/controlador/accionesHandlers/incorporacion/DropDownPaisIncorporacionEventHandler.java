package edu.fiuba.algo3.controlador.accionesHandlers.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.incorporacion.BotonIncorporar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownPaisIncorporacionEventHandler implements EventHandler {

    private final Juego juego;
    private final DropDownAccion paisElegido;
    private final DropDownAccion cantidadFichas;
    private final BotonIncorporar incorporar;

    public DropDownPaisIncorporacionEventHandler(Juego juego, DropDownAccion paisElegido, DropDownAccion cantidadFichas, BotonIncorporar incorporar) {
        this.juego = juego;
        this.paisElegido = paisElegido;
        this.cantidadFichas = cantidadFichas;
        this.incorporar = incorporar;
    }

    @Override
    public void handle(Event event) {
        Pais paisIncorporable = this.juego.getPaisPorNombre((String)paisElegido.getValue());
        if (paisIncorporable == null)
            return;

        ObservableList<String> cantidadIncorporable = FXCollections.observableArrayList();

        for (Integer i = 1; i <= juego.jugadorActual().cantidadFichasReservadas(); i++)
            cantidadIncorporable.add(i.toString());

        this.cantidadFichas.getItems().clear();
        this.cantidadFichas.getItems().addAll(cantidadIncorporable);

        incorporar.setPaisIncorporador(paisIncorporable);
    }
}
