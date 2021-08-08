package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;


public class VistaTitulo extends Escena {

    private final VBox padre;

    public VistaTitulo(Parent padre, ControladorDeEscena controladorDeEscena) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
    }

    @Override
    public void mostrar(Stage ventana) {
        this.padre.getChildren().clear();
        padre.setStyle("-fx-background-color: #ffcc3d;");

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        // ETIQUETAS
        Label label1 = new Label("A.L.");
        Label label2 = new Label("O");
        label1.setTextFill(Color.BLACK);
        label2.setTextFill(Color.BLACK);
        label1.setStyle("-fx-font-size: 150px;");
        label2.setStyle("-fx-font-size: 150px;");
        label1.setPadding(new Insets(30));
        label2.setPadding(new Insets(30));

        // FOTO
        //File file = new File(("src/main/java/edu/fiuba/algo3/archivos/logo_teg.png"));
        Image image = new Image("logo_teg.png");
        ImageView logo = new ImageView(image);

        // BOTON JUGAR
        BotonJugar botonJugar = new BotonJugar(ventana, controladorDeEscena);

        // BOTON ABOUT
        Button botonAbout = new Button("About");
        botonAbout.getStyleClass().addAll("botonJuego", "hoverOscuro");
        botonAbout.setOnAction(e-> {

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

            //POPUP
            Popup popup = new Popup(ventana, layout);
            popup.setDimensiones(450,300);
            popup.setDistanciaAPrincipal(ventana.getX() + 415,ventana.getY() + 260 );
            popup.crearPopup();

        });

        //HBox para los botones
        HBox botones = new HBox();
        botones.getChildren().addAll(botonJugar,botonAbout);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(20.0);

        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);

        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(titulo, botones);
    }
}
