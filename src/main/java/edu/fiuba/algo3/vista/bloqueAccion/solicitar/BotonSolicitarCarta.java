package edu.fiuba.algo3.vista.bloqueAccion.solicitar;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;

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
