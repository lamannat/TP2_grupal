package edu.fiuba.algo3.controlador.accionesHandlers.ataque;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.ataque.BotonAtacar;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DropDownPaisElegidoEventHandler implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final DropDownAccion dropDownElegirPais;
    private final DropDownAccion dropDownAtacables;
    private final BotonAtacar botonAtacar;

    public DropDownPaisElegidoEventHandler(Juego juego, DropDownAccion dropDownElegirPais, DropDownAccion dropDownAtacables, BotonAtacar botonAtacar) {
        this.juego = juego;
        this.dropDownElegirPais = dropDownElegirPais;
        this.dropDownAtacables = dropDownAtacables;
        this.botonAtacar = botonAtacar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String selected = (String)dropDownElegirPais.getValue();


        Pais paisAtacante = juego.getPaisPorNombre((String)dropDownElegirPais.getValue());
        if (paisAtacante == null)
            return;

        ObservableList<String> atacables = FXCollections.observableArrayList();
        for (Pais pais: paisAtacante.getPaisesParaAtacar())
            atacables.add(pais.toString());

        dropDownAtacables.getItems().clear();
        dropDownAtacables.getItems().addAll(atacables.sorted());
        botonAtacar.setPaisAtacante(paisAtacante);
    }
}
