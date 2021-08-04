package edu.fiuba.algo3.vista.ataque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.BloqueAccion;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BloqueDeAtaque extends BloqueAccion {

    private Juego juego;

    public BloqueDeAtaque(Juego juego) {
        this.juego = juego;
        actualizar();
    }

    @Override
    public void change() {
        // actualizar();
    }

    public void actualizar() {
        BotonAtacar botonAtacar = new BotonAtacar(juego);
        DropDownDefensor paisQueSePuedeAtacar = new DropDownDefensor(juego, botonAtacar);
        DropDownAtacante paisParaAtacar = new DropDownAtacante(juego, paisQueSePuedeAtacar);

        Batalla batalla = juego.getBatalla();
        batalla.addObserver(paisParaAtacar);
        batalla.addObserver(paisQueSePuedeAtacar);
        juego.addObserverAPaises(paisParaAtacar);
        juego.addObserverAPaises(paisQueSePuedeAtacar);

        Label labelPaisAtacar = new Label("Elija pais\ncon cual atacar");
        Label labelPaisDefensor = new Label("Elija pais\na cual atacar");
        labelPaisAtacar.setTextFill(Color.WHITE);
        labelPaisDefensor.setTextFill(Color.WHITE);
        labelPaisAtacar.setStyle("-fx-font-weight: bold");
        labelPaisDefensor.setStyle("-fx-font-weight: bold");

        this.getChildren().clear();
        this.getChildren().addAll(labelPaisAtacar,paisParaAtacar,labelPaisDefensor, paisQueSePuedeAtacar,botonAtacar);

        this.setSpacing(20);
        this.setAlignment(Pos.TOP_CENTER);
    }
}