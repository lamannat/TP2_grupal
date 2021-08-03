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
        label1.setScaleX(5);
        label1.setScaleY(5);
        label2.setScaleX(5);
        label2.setScaleY(5);
        label1.setPadding(new Insets(120));
        label2.setPadding(new Insets(70));
        label1.setStyle("-fx-font-size: 34px;");
        label2.setStyle("-fx-font-size: 34px;");


        // FOTO
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/logo_teg.png");
        Image image = new Image(file.toURI().toString());
        ImageView logo = new ImageView(image);

        // BOTON JUGAR
        BotonSiguiente botonJugar = new BotonSiguiente(ventana, controladorDeEscena);
        botonJugar.setText("Jugar");
        //botonJugar.setPadding(new Insets(-50,250,0,0));
        botonJugar.setScaleX(3);
        botonJugar.setScaleY(3);
        botonJugar.setStyle("-fx-background-color:black");
        botonJugar.setTextFill(Color.WHITE);


        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);

        padre.setAlignment(Pos.CENTER);
        padre.getChildren().addAll(titulo, botonJugar);
    }
}
