package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.incorporacion.BotonIncorporar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownCantidadFichas extends ComboBox implements Observer {


    public DropDownCantidadFichas(BotonMoverTropas moverTropas) {

        this.setPromptText("N° Fichas");

        this.setOnAction(e -> {
            if (this.getValue() == null || Integer.parseInt((String)this.getValue()) <= 0)
                return;

            moverTropas.setCantidadDeFichas(Integer.parseInt((String)this.getValue()));
        });
    }

    @Override
    public void change() {
        this.getItems().clear();
    }
}

