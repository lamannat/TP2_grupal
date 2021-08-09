package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class VistaTitulo extends Escena {

    private final VBox padre;

    public VistaTitulo(Parent padre, ControladorDeEscena controladorDeEscena) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
    }

    @Override
    public void mostrar(Stage ventana) {
        this.padre.getChildren().clear();
        padre.setStyle("-fx-background-color: #272727;");

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        // ETIQUETAS
        Label label1 = new Label("A.L.");
        Label label2 = new Label("O");
        label1.setTextFill(Color.valueOf("#ffcc3d"));
        label2.setTextFill(Color.valueOf("#ffcc3d"));
        label1.setStyle("-fx-font-size: 150px;");
        label2.setStyle("-fx-font-size: 150px;");
        label1.setPadding(new Insets(25));
        label2.setPadding(new Insets(25));

        // FOTO
        //File file = new File(("src/main/java/edu/fiuba/algo3/archivos/logo_teg.png"));
        Image image = new Image("logo_teg.png");
        ImageView logo = new ImageView(image);

        // BOTON JUGAR
        BotonJugar botonJugar = new BotonJugar(ventana, controladorDeEscena);

        // BOTON ABOUT
        BotonAbout botonAbout = new BotonAbout(ventana);

//        botonAbout.getStyleClass().addAll("botonJuego", "hoverOscuro");
//        botonAbout.setOnAction(e-> {
//
//            Label integrantes = new Label("Integrantes");
//            integrantes.setTextFill(Color.WHITE);
//            integrantes.setStyle("-fx-font-size: 30");
//
//            Label nomsIntegrantes = new Label("-Tobias Lamanna\n-Juan Ignacio Biancuzzo\n-Dolores Levi\n-Valentín Santander");
//            nomsIntegrantes.setTextFill(Color.WHITE);
//            nomsIntegrantes.setStyle("-fx-font-size: 20");
//
//            VBox layout = new VBox();
//            layout.getChildren().addAll(integrantes,nomsIntegrantes);
//
//            layout.setStyle("-fx-background-color: #272727;" +
//                    "-fx-border-color: #ffcc3d;\n" +
//                    "-fx-border-style: solid;\n" +
//                    "-fx-border-width: 5;");
//
//            layout.setAlignment(Pos.CENTER);
//
//            //POPUP
//            Popup popup = new Popup(layout);
//            popup.setDimensiones(450,300);
//            popup.setDistanciaAPrincipal(ventana.getX() + 415,ventana.getY() + 260 );
//            popup.crearPopup();
//
//        });

        //BorderPane para los botones
        AnchorPane botones = new AnchorPane();

        botonJugar.setLayoutX(640 - botonJugar.getWidth()/2);
        botonJugar.setLayoutY(botones.getHeight()/2 - botonJugar.getHeight()/2);

        botonAbout.setLayoutX(20);
        botonAbout.setLayoutY(40);

        botones.getChildren().addAll(botonJugar,botonAbout);


        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);


        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(titulo, botones);
    }
}
