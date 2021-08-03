package edu.fiuba.algo3.aplicacion.app;

import edu.fiuba.algo3.aplicacion.eventos.BotonCantidadEventHandler;
import javafx.scene.control.Button;

public class BotonCantidad extends Button {
    private int cantidad;

    public BotonCantidad(int cantidad, String text){
        super();
        this.cantidad = cantidad;
        this.setText(text);
        this.setOnAction(new BotonCantidadEventHandler(cantidad));
    }


}
