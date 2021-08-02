package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class DropDownDeAtacanteEventHandler implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final ComboBox paisParaAtacar;

    public DropDownDeAtacanteEventHandler(Juego juego, ComboBox paisParaAtacar) {
        this.juego = juego;
        this.paisParaAtacar = paisParaAtacar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String paisAtacante = (String) paisParaAtacar.getValue();
        juego.getPaisPorNombre(paisAtacante);
//        System.out.println("Pais elegido: " + paisAtacante);
    }
}
