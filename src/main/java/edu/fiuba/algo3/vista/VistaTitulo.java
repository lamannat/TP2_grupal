package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        Image image = new Image("logo_teg.png");
        ImageView logo = new ImageView(image);

        // BOTON JUGAR
        BotonJugar botonJugar = new BotonJugar(ventana, controladorDeEscena);

        // BOTON ABOUT
        BotonAbout botonAbout = new BotonAbout(ventana);

        // BOTON SALIR
        BotonSalir botonSalir = new BotonSalir(ventana);

        //BorderPane para los botones
        AnchorPane botones = new AnchorPane();

        botonJugar.setLayoutX(350 - botonJugar.getWidth()/2);
        botonJugar.setLayoutY(botones.getHeight()/2 - botonJugar.getHeight()/2);

        botonSalir.setLayoutX(650 - botonJugar.getWidth()/2);
        botonSalir.setLayoutY(botones.getHeight()/2 - botonJugar.getHeight()/2);

        botonAbout.setLayoutX(20);
        botonAbout.setLayoutY(40);

        botones.getChildren().addAll(botonJugar,botonSalir,botonAbout);


        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);


        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(titulo, botones);
    }
}
