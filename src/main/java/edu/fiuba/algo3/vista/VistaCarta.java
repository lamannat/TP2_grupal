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

        Image img = new Image("logo_objetivos.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);

        Rectangle rectangulo = new Rectangle(0,0,150,180);

        rectangulo.setFill(Color.WHITE);

        Label nombrePais = new Label(paisAMostrar.toString());
        nombrePais.setTextFill(Color.BLACK);
        nombrePais.setAlignment(Pos.CENTER);

        this.setStyle("-fx-background-color: #fff;");
        this.getChildren().addAll(view,nombrePais);
    }
}
