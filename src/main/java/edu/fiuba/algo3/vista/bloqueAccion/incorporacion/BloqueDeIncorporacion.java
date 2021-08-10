package edu.fiuba.algo3.vista.bloqueAccion.incorporacion;

import edu.fiuba.algo3.controlador.accionesHandlers.incorporacion.DropDownCAntidadFichasIncorporarEventHandler;
import edu.fiuba.algo3.controlador.accionesHandlers.incorporacion.DropDownPaisIncorporacionEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.BloqueAccion;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class BloqueDeIncorporacion extends BloqueAccion {
    private final Juego juego;
    private DropDownAccion dropDownPaisesParaIncorporar;
    public BloqueDeIncorporacion(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeIncorporacion");
    }

    @Override
    public void change() {
        this.actualizar();
    }

    public void setDropDown(Pais paisASetear) {
        dropDownPaisesParaIncorporar.setPais(paisASetear);
    }

    public void actualizar() {
        BotonIncorporar incorporar = new BotonIncorporar(juego);
        incorporar.setText("Incorporar");

        DropDownAccion cantidadFichas = new DropDownAccion("N° de Fichas");
        cantidadFichas.setActualizacion(() -> {
            Jugador jugadorActual = this.juego.jugadorActual();

            ObservableList<String> cantidadIncorporable = FXCollections.observableArrayList();

            for (Integer i = 1; i <= jugadorActual.cantidadFichasReservadas() ; i++)
                cantidadIncorporable.add(i.toString());

            cantidadFichas.getItems().clear();
            cantidadFichas.getItems().addAll(cantidadIncorporable);
        });
        cantidadFichas.setOnAction(new DropDownCAntidadFichasIncorporarEventHandler(cantidadFichas, incorporar));

        DropDownAccion paisElegido = new DropDownAccion("Pais Destino");
        paisElegido.setActualizacion(() -> {
            Jugador jugador = juego.jugadorActual();

            ObservableList<String> incorporables = FXCollections.observableArrayList();
            for (Pais pais: jugador.getPaisesIniciales())
                incorporables.add(pais.toString());

            paisElegido.getItems().clear();
            paisElegido.getItems().addAll(incorporables.sorted());
        });
        paisElegido.setOnAction(new DropDownPaisIncorporacionEventHandler(juego, paisElegido, cantidadFichas, incorporar));
        dropDownPaisesParaIncorporar = paisElegido;
        Label labelDestino = new Label("Elija pais\ndestino");
        Label labelCantidadFichas = new Label("Elija cantidad\nde fichas");

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        this.getChildren().clear();
        this.getChildren().addAll(labelDestino,paisElegido, labelCantidadFichas,cantidadFichas, incorporar);
    }
}
