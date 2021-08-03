package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.layout.VBox;

public class BloqueDeIncorporacion extends VBox implements Observer {
    private Juego juego;
    public BloqueDeIncorporacion(Juego juego) {
        this.juego = juego;
        BotonIncorporar incorporar = new BotonIncorporar(juego);
        incorporar.setText("Incorporar");
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(juego,incorporar);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego,incorporar, cantidadFichas);


        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        this.getChildren().addAll(paisElegido, cantidadFichas, incorporar);
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
        this.getChildren().addAll(paisElegido, cantidadFichas, incorporar);
    }
}
