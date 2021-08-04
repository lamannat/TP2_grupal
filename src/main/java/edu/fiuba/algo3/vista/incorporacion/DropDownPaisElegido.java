package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownPaisElegido extends ComboBox implements Observer {
    private Juego juego;

    public DropDownPaisElegido(Juego juego, BotonIncorporar incorporar, ComboBox dropDownCantidadFichas) {
        this.juego = juego;
        Jugador jugador = juego.jugadorActual();

        ObservableList<String> incorporables = FXCollections.observableArrayList();

        for (Pais pais: jugador.getPaisesConquistados())
            incorporables.add(pais.toString());

        this.getItems().clear();
        this.getItems().addAll(incorporables.sorted());

        this.setOnAction(e -> {
            Pais paisIncorporable = this.juego.getPaisPorNombre((String)this.getValue());
            if (paisIncorporable == null)
                return;

            ObservableList<String> cantidadIncorporable = FXCollections.observableArrayList();

            for (Integer i = 1; i <= jugador.cantidadFichasReservadas(); i++)
                cantidadIncorporable.add(i.toString());

            dropDownCantidadFichas.getItems().clear();
            dropDownCantidadFichas.getItems().addAll(cantidadIncorporable);


            incorporar.setPaisIncorporador(paisIncorporable);
        });
    }

    @Override
    public void change() {
        Jugador jugador = juego.jugadorActual();

        ObservableList<String> incorporables = FXCollections.observableArrayList();

        for (Pais pais: jugador.getPaisesConquistados())
            incorporables.add(pais.toString());
        this.getItems().clear();
        this.getItems().addAll(incorporables.sorted());
    }
}
