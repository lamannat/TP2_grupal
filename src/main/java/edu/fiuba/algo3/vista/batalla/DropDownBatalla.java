package edu.fiuba.algo3.vista.batalla;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.vista.movimiento.BotonMoverTropas;
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


