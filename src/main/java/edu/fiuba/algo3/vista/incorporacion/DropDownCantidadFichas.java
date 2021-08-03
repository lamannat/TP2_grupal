package edu.fiuba.algo3.vista.incorporacion;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownCantidadFichas extends ComboBox implements Observer {
    private Juego juego;

    public DropDownCantidadFichas(Juego juego, BotonIncorporar incorporar) {
        this.juego = juego;
        // Esto no va acá
        Jugador jugadorActual = juego.jugadorActual();
//        jugadorActual.darFichas(jugadorActual.generarFichas(5));
//        System.out.println(jugadorActual.getNombre() + "agregué fichas" );


        this.setOnAction(e -> {
            if (this.getValue() == null || Integer.parseInt((String)this.getValue()) <= 0)
                return;

            incorporar.setCantidadDeFichas(Integer.parseInt((String)this.getValue()));
        });
    }


    @Override
    public void change() {
        Jugador jugadorActual = this.juego.jugadorActual();

        ObservableList<String> cantidadIncorporable = FXCollections.observableArrayList();

        for (Integer i = 1; i <= jugadorActual.cantidadFichasReservadas() ; i++)
            cantidadIncorporable.add(i.toString());

        this.getItems().clear();
        this.getItems().addAll(cantidadIncorporable);
    }
}
