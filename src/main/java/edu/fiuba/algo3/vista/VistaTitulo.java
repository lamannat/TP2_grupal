package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
        BotonSiguiente botonJugar = new BotonSiguiente(ventana, controladorDeEscena);
        botonJugar.getStylesheets().add("estiloBotonJugar.css");


        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);

        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(titulo, botonJugar);
    }
}
