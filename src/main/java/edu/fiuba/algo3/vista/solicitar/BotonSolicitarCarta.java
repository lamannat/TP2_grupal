package edu.fiuba.algo3.vista.solicitar;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;

public class BotonSolicitarCarta extends Button {

    public BotonSolicitarCarta(Juego juego) {
        this.setText("Dale pedime");

        this.setOnAction(e -> {
            Jugador jugador = juego.jugadorActual();
            juego.cartaParaJugador(jugador);
        });
    }

}
