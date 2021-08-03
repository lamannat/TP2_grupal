package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownAtacante extends ComboBox implements Observer {

    private final Juego juego;


    public DropDownAtacante(Juego juego, DropDownDefensor dropDownAtacables){
        this.juego = juego;

        Jugador jugador = juego.jugadorActual();

        ObservableList<String> opciones = FXCollections.observableArrayList();

        for (Pais pais: jugador.getPaisesConquistados())
            opciones.add(pais.toString());

        this.getItems().clear();
        this.getItems().addAll(opciones);

        this.setOnAction(e -> {
            Pais paisAtacante = juego.getPaisPorNombre((String)this.getValue());
            if (paisAtacante == null)
                return;

            ObservableList<String> atacables = FXCollections.observableArrayList();
            for (Pais pais: paisAtacante.getPaisesParaAtacar())
                atacables.add(pais.toString());

            dropDownAtacables.getItems().clear();
            dropDownAtacables.getItems().addAll(atacables);
            dropDownAtacables.setPaisAtacante(paisAtacante);

        });
    }


    @Override
    public void change() {
        Jugador jugador = juego.jugadorActual();

        ObservableList<String> opciones = FXCollections.observableArrayList();

        for (Pais pais: jugador.getPaisesConquistados())
            opciones.add(pais.toString());

        this.getItems().clear();
        this.getItems().addAll(opciones);
    }
}
