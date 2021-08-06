package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BloqueDeIncorporacion extends BloqueAccion {
    private Juego juego;
    public BloqueDeIncorporacion(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeIncorporacion");
        this.getStyleClass().add("bloqueDeAccion");
    }

    @Override
    public void change() {
        this.actualizar();
    }

    public void actualizar() {
        BotonIncorporar incorporar = new BotonIncorporar(juego);
        incorporar.setText("Incorporar");
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(juego,incorporar);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego,incorporar, cantidadFichas);

        Label labelDestino = new Label("Elija pais\ndestino");
        Label labelCantidadFichas = new Label("Elija cantidad\nde fichas");

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        this.getChildren().clear();
        this.getChildren().addAll(labelDestino,paisElegido, labelCantidadFichas,cantidadFichas, incorporar);
    }
}
