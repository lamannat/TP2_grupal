package edu.fiuba.algo3.vista.bloqueAccion.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;

public class BotonIncorporar extends Button {

    private final Juego juego;
    private Pais paisIncorporador = null;
    private Integer cantidadDeFichas = null;

    public BotonIncorporar(Juego juego) {

        this.juego = juego;

        this.setOnAction(e -> {
            if(paisIncorporador == null || cantidadDeFichas == null)
                return;

            this.juego.jugadorActual().agregarFichasReservadasEnPais(paisIncorporador,cantidadDeFichas);
            paisIncorporador = null;
            cantidadDeFichas = null;
        });
    }

    public void setPaisIncorporador(Pais paisIncorporador) {
        this.paisIncorporador = paisIncorporador;
    }

    public void setCantidadDeFichas(Integer cantidadDeFichas) {
        this.cantidadDeFichas = cantidadDeFichas;
    }
}
