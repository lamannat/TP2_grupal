package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonObjetivo extends Button {

    private String listaObjetivos = "";
    private Juego juego;

    public BotonObjetivo(Stage ventana, Juego juego){
        this.juego = juego;

        Tooltip unTooltip = new Tooltip("Objetivo Secreto");
        unTooltip.setShowDelay(Duration.millis(10));
        this.setTooltip(unTooltip);
        this.getStyleClass().addAll("botonFoto", "hoverOscuro");

        Image img = new Image("logo_objetivos.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setFitWidth(50);
        view.setPreserveRatio(true);
        this.setGraphic(view);


        this.setOnAction(e -> {
            this.actualizar();

            Label label = new Label(listaObjetivos);
            label.setTextFill(Color.WHITE);
            label.setStyle("-fx-font-size: 20");

            StackPane layout = new StackPane();
            layout.getChildren().add(label);
            layout.setStyle("-fx-background-color: #272727");

            layout.setStyle("-fx-background-color: #272727;" +
                    "-fx-border-color: #ffcc3d;\n" +
                    "-fx-border-style: solid;\n" +
                    "-fx-border-width: 5;");

            //POPUP
            Popup popup = new Popup(layout);
            popup.setDimensiones(450,300);
            popup.setDistanciaAPrincipal(ventana.getX() + 415,ventana.getY() + 260 );
            popup.crearPopup();

        });
    }

    public void actualizar(){
        this.listaObjetivos = "";
        for (Objetivo objetivo : juego.jugadorActual().getObjetivos())
            this.listaObjetivos += objetivo.toString() + "\n\n";
    }
}
