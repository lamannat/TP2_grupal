package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.layout.VBox;

public class BloqueDeMovimiento extends VBox implements Observer {

    private Juego juego;

    public BloqueDeMovimiento (Juego juego) {
        this.juego = juego;

        BotonMoverTropas moverTropas = new BotonMoverTropas(juego);
        moverTropas.setText("Mover tropas");
        DropDownPaisDestino paisDestino = new DropDownPaisDestino(juego, moverTropas);
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(moverTropas);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego, paisDestino, cantidadFichas, moverTropas);

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        juego.jugadorActual().addObserver(paisDestino);
        this.getChildren().addAll(paisElegido, cantidadFichas, paisDestino, moverTropas);
    }

    @Override
    public void change() {

    }
}
