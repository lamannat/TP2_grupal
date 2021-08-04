package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BloqueDeIncorporacion extends BloqueAccion {
    private Juego juego;
    public BloqueDeIncorporacion(Juego juego) {
        this.juego = juego;
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(20);

        actualizar();
    }

    @Override
    public void change() {

    }

    public void actualizar() {
        BotonIncorporar incorporar = new BotonIncorporar(juego);
        incorporar.setText("Incorporar");
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(juego,incorporar);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego,incorporar, cantidadFichas);

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        this.getChildren().clear();
        this.getChildren().addAll(cantidadFichas,paisElegido, incorporar);
    }
}
