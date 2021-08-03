package edu.fiuba.algo3.vista.solicitar;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BloqueSolicitarCarta extends BloqueAccion {

    private Juego juego;

    public BloqueSolicitarCarta(Juego juego) {
        this.juego = juego;
        actualizar();
    }

    public void actualizar() {
        Label estadoDeCarta = new Label("No conquisto en esta ronda");
        estadoDeCarta.setScaleX(1);
        estadoDeCarta.setScaleY(1);
        if (juego.jugadorActual().merecesCarta())
            estadoDeCarta.setText("Mereces carta yey");
        BotonSolicitarCarta botonSolicitarCarta = new BotonSolicitarCarta(juego);

        this.getChildren().clear();
        this.getChildren().addAll(estadoDeCarta, botonSolicitarCarta);
    }

}
