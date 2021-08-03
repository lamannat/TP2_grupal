package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;

public class BotonIncorporar extends Button {

    private Juego juego;
    private Pais paisIncorporador = null;
    private Integer cantidadDeFichas = null;

    public BotonIncorporar(Juego juego) {

        this.juego = juego;

        this.setOnAction(e -> {
            if(paisIncorporador == null || cantidadDeFichas == null) {
                return;
            }
            juego.jugadorActual().agregarFichasReservadasEnPais(paisIncorporador,cantidadDeFichas);
        });
    }

    public void setPaisIncorporador(Pais paisIncorporador) {
        this.paisIncorporador = paisIncorporador;
    }

    public void setCantidadDeFichas(Integer cantidadDeFichas) {
        this.cantidadDeFichas = cantidadDeFichas;
    }
}
