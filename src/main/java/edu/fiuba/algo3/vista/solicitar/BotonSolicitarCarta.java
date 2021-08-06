package edu.fiuba.algo3.vista.solicitar;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BotonSolicitarCarta extends Button {

    public BotonSolicitarCarta(Juego juego) {
        this.setText("Solicitar\nTarjeta");
        this.setId("botonSolicitarCarta");

        this.setOnAction(e -> {
            Jugador jugador = juego.jugadorActual();
            juego.cartaParaJugador(jugador);
        });
    }

}
