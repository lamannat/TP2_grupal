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

    public DropDownPaisElegido(Juego juego, BotonIncorporar incorporar) {
        Jugador jugador = juego.jugadorActual();

        ObservableList<String> incorporables = FXCollections.observableArrayList();

        for (Pais pais: jugador.getPaisesConquistados())
            incorporables.add(pais.toString());

        this.getItems().clear();
        this.getItems().addAll(incorporables.sorted());

        this.setOnAction(e -> {
            Pais paisIncorporable = juego.getPaisPorNombre((String)this.getValue());
            if (paisIncorporable == null)
                return;
            incorporar.setPaisIncorporador(paisIncorporable);
            System.out.println("Voy a incorporar Fichas En:" + paisIncorporable);
        });
    }

    @Override
    public void change() { this.getItems().clear(); }
}
