package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;

public class BotonMoverTropas extends Button {

    private Pais paisConFichas = null;
    private Pais paisDestino = null;
    private Integer cantidad = null;

    public BotonMoverTropas(Juego juego) {
        this.setOnAction(e -> {
            if(paisConFichas == null || paisDestino == null || cantidad == null)
                return;

            juego.jugadorActual().moverTropasAPais(paisConFichas, paisDestino, cantidad);

            paisConFichas = null;
            paisDestino = null;
            cantidad = null;
        });
    }

    public void setPaisConFichas(Pais paisConFichas) {
        this.paisConFichas = paisConFichas;
    }

    public void setPaisDestino(Pais paisDestino) {
        this.paisDestino = paisDestino;
    }

    public void setCantidadDeFichas(int cantidad) {
        this.cantidad = cantidad;
    }
}