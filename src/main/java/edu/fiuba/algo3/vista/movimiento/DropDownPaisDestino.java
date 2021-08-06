package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.ataque.DropDownDefensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownPaisDestino extends ComboBox implements Observer {

    public DropDownPaisDestino(Juego juego, BotonMoverTropas moverTropas) {

        this.setPromptText("Destino");

        this.setOnAction(e -> {
            Pais paisDestino = juego.getPaisPorNombre((String)this.getValue());
            if (paisDestino == null)
                return;

            moverTropas.setPaisDestino(paisDestino);
        });
    }

    @Override
    public void change() {
        this.getItems().clear();
    }
}
