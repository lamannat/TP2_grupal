package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonAbout extends Button {

    public BotonAbout(Stage ventana) {
        //this.getStyleClass().addAll("botonJuego", "hoverOscuro");

        Tooltip unTooltip = new Tooltip("About us");
        unTooltip.setShowDelay(Duration.millis(10));
        this.setTooltip(unTooltip);
        this.getStyleClass().addAll("botonAbout");

        Image img = new Image("logo_about.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);
        this.setGraphic(view);

        this.setOnAction(e-> {

            Label integrantes = new Label("Integrantes");
            integrantes.setTextFill(Color.WHITE);
            integrantes.setStyle("-fx-font-size: 30");

            Label nomsIntegrantes = new Label("-Tobias Lamanna\n-Juan Ignacio Biancuzzo\n-Dolores Levi\n-Valentín Santander");
            nomsIntegrantes.setTextFill(Color.WHITE);
            nomsIntegrantes.setStyle("-fx-font-size: 20");

            VBox layout = new VBox();
            layout.getChildren().addAll(integrantes,nomsIntegrantes);

            layout.setStyle("-fx-background-color: #272727;" +
                    "-fx-border-color: #ffcc3d;\n" +
                    "-fx-border-style: solid;\n" +
                    "-fx-border-width: 5;");

            layout.setAlignment(Pos.CENTER);

            //POPUP
            Popup popup = new Popup(layout);
            popup.setDimensiones(450,300);
            popup.setDistanciaAPrincipal(ventana.getX() + 415,ventana.getY() + 260 );
            popup.crearPopup();

        });
    }
}
