package edu.fiuba.algo3.controlador;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class ListenerVentanaDesenfocada implements ChangeListener<Boolean> {

    private Stage escena;

    public ListenerVentanaDesenfocada(Stage escena) {
        this.escena = escena;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (aBoolean)
            this.escena.close();
    }
}
