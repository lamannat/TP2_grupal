package edu.fiuba.algo3.vista.solicitar;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.bloqueAccion.BloqueAccion;
import javafx.scene.control.Label;

public class BloqueSolicitarCarta extends BloqueAccion {

    private Juego juego;

    public BloqueSolicitarCarta(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueSolicitarCarta");
    }

    public void actualizar() {

        BotonSolicitarCarta botonSolicitarCarta = new BotonSolicitarCarta(juego);
        botonSolicitarCarta.setVisible(false);

        Label estadoDeCarta = new Label("No conquisto\nen esta ronda");
        if (juego.jugadorActual().merecesCarta()) {
            estadoDeCarta.setText("Mereces carta\nyey :D");
            botonSolicitarCarta.setVisible(true);
        }

        Label cartaGanada = new Label();

        this.getChildren().clear();
        this.getChildren().addAll(estadoDeCarta, botonSolicitarCarta, cartaGanada);
    }

}
