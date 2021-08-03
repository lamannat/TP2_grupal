package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.layout.VBox;

public class BloqueDeMovimiento extends BloqueAccion {

    private Juego juego;

    public BloqueDeMovimiento (Juego juego) {
        this.juego = juego;
        actualizar();
    }

    @Override
    public void change() {

    }

    public void actualizar() {
        BotonMoverTropas moverTropas = new BotonMoverTropas(juego);
        moverTropas.setText("Mover tropas");
        DropDownPaisDestino paisDestino = new DropDownPaisDestino(juego, moverTropas);
        DropDownCantidadFichas cantidadFichas = new DropDownCantidadFichas(moverTropas);
        DropDownPaisElegido paisElegido = new DropDownPaisElegido(juego, paisDestino, cantidadFichas, moverTropas);

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        juego.jugadorActual().addObserver(paisDestino);

        this.getChildren().clear();
        this.getChildren().addAll(paisElegido, cantidadFichas, paisDestino, moverTropas);
    }
}
