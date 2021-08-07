package edu.fiuba.algo3.vista.batalla;

import javafx.scene.control.ComboBox;

public class DropDownBatalla extends ComboBox {

    public DropDownBatalla(BotonBatalla botonBatalla) {

        this.setPromptText("N° Fichas");

        this.setOnAction(e -> {
            if (this.getValue() == null || Integer.parseInt((String)this.getValue()) <= 0)
                return;

            botonBatalla.setCantidadDeFichas(Integer.parseInt((String)this.getValue()));
        });
    }
}


