package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.simbolo.Simbolo;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaCarta extends VBox {

    public VistaCarta(Carta carta) {

        Pais paisAMostrar = carta.getPais();
        Simbolo simboloAMostrar = carta.getSimbolo();

        Image img = new Image(simboloAMostrar.toString() + ".png");
        ImageView view = new ImageView(img);
        view.setFitHeight(150);
        view.setFitWidth(150);
        view.setPreserveRatio(true);

        view.setStyle("-fx-border-color: #000;" +
                      "-fx-border-style: solid;" +
                      "-fx-border-width: 1;");

        Label nombrePais = new Label(paisAMostrar.toString());
        nombrePais.setTextFill(Color.BLACK);
        nombrePais.setStyle("-fx-background-color: #fff;");

        VBox epigrafe = new VBox();

        Label estadoCarta = new Label(carta.getEstado().toString());
        estadoCarta.setTextFill(Color.WHITE);
        estadoCarta.setStyle("-fx-font-weight: bold;");

        epigrafe.getChildren().add(estadoCarta);
        epigrafe.setStyle("-fx-background-color: #272727;");
        epigrafe.setAlignment(Pos.CENTER);

        this.setStyle("-fx-background-color: #fff;");

        this.getChildren().addAll(view,nombrePais,epigrafe);
        this.setAlignment(Pos.CENTER);
    }
}
