package edu.fiuba.algo3.controlador.accionesHandlers.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import edu.fiuba.algo3.vista.bloqueAccion.movimiento.BotonMoverTropas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;

public class DropDownPaisElegidoMovimientoEventHandler implements EventHandler {

    private final Juego juego;
    private final DropDownAccion dropDownPaisElegido;
    private final DropDownAccion cantidadFichas;
    private final DropDownAccion paisDestino;
    private final BotonMoverTropas moverTropas;

    public DropDownPaisElegidoMovimientoEventHandler(Juego juego, DropDownAccion dropDownPaisElegido, DropDownAccion cantidadFichas, DropDownAccion paisDestino, BotonMoverTropas moverTropas) {
        this.juego = juego;
        this.dropDownPaisElegido = dropDownPaisElegido;
        this.cantidadFichas = cantidadFichas;
        this.paisDestino = paisDestino;
        this.moverTropas = moverTropas;
    }

    @Override
    public void handle(Event event) {
        Pais paisElegido = this.juego.getPaisPorNombre((String)dropDownPaisElegido.getValue());
        if (paisElegido == null)
            return;
        moverTropas.setPaisConFichas(paisElegido);

        ObservableList<String> paisesDestino = FXCollections.observableArrayList();
        for (Pais pais : paisElegido.getPaisesAliados())
            paisesDestino.add(pais.toString());

        paisDestino.getItems().clear();
        paisDestino.getItems().addAll(paisesDestino.sorted());


        ObservableList<String> cantidadAMover = FXCollections.observableArrayList();
        for (Integer i = 1; i <= paisElegido.fichasParaMover() ; i++)
            cantidadAMover.add(i.toString());

        cantidadFichas.getItems().clear();
        cantidadFichas.getItems().addAll(cantidadAMover);
    }
}
