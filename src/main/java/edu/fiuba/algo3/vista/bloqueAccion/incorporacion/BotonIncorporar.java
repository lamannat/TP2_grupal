package edu.fiuba.algo3.vista.bloqueAccion.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BotonIncorporar extends Button {

    private final Juego juego;
    private Pais paisIncorporador;
    private Integer cantidadDeFichas;

    public BotonIncorporar(Juego juego, Label labelMostrarFichas) {

        this.juego = juego;
        resetear();

        this.setOnAction(e -> {
            if(paisIncorporador == null || cantidadDeFichas == null)
                return;

            this.juego.jugadorActual().agregarFichasReservadasEnPais(paisIncorporador,cantidadDeFichas);

            int cantFichas = juego.jugadorActual().cantidadFichasReservadas();
            if (cantFichas > 0)
                labelMostrarFichas.setText("Tiene " + juego.jugadorActual().cantidadFichasReservadas() + " fichas");
            else
                labelMostrarFichas.setText("Ya no te \nquedan fichas\n\nClikear siguiente\npara continuar");

            resetear();
        });
    }

    private void resetear() {
        paisIncorporador = null;
        cantidadDeFichas = null;
    }

    public void setPaisIncorporador(Pais paisIncorporador) {
        this.paisIncorporador = paisIncorporador;
    }

    public void setCantidadDeFichas(Integer cantidadDeFichas) {
        this.cantidadDeFichas = cantidadDeFichas;
    }
}
