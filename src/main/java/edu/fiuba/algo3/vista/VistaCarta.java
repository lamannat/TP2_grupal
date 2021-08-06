package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.simbolo.Simbolo;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaCarta extends VBox {

    public VistaCarta(Carta carta) {

        Pais paisAMostrar = carta.getPais();
        Simbolo simboloAMostrar = carta.getSimbolo();

        Label nombrePais = new Label(paisAMostrar.toString());
        nombrePais.setTextFill(Color.WHITE);
        this.setId(simboloAMostrar.toString());

        this.getChildren().add(nombrePais);
    }
}
