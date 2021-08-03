package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.layout.VBox;

public class BloqueDeIncorporacion extends VBox implements Observer {
    private Juego juego;
    public BloqueDeIncorporacion(Juego juego) {

        BotonIncorporar incorporar = new BotonIncorporar(juego);
        incorporar.setText("Incorporar");
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego,incorporar);
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(juego,incorporar);

//        juego.addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        this.getChildren().addAll(paisElegido, cantidadFichas, incorporar);
    }

    @Override
    public void change() {

    }
}
