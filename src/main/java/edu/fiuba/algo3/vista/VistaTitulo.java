package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.zip.CheckedOutputStream;

public class VistaTitulo extends Escena {

    private final VBox padre;

    public VistaTitulo(Parent padre, ControladorDeEscena controladorDeEscena, Juego juego) {
        super(padre, controladorDeEscena, juego);
        this.padre = (VBox) padre;
    }

    @Override
    public void mostrar(Stage ventana) {
        this.padre.getChildren().clear();
        padre.setStyle("-fx-background-color: #ffcc3d");

        Button botonJugar;

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
        botonJugar = new Button("JUGAR");
        botonJugar.setPadding(new Insets(-50,250,0,0));
        botonJugar.setScaleX(3);
        botonJugar.setScaleY(3);
        botonJugar.setOnAction(new BotonSiguienteEscenaEventHandler(ventana, this.controladorDeEscena));
        botonJugar.setStyle("-fx-background-color: #000000");
        botonJugar.setTextFill(Color.BLACK);



        // LAYOUT SECUNDARIO
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        titulo.getChildren().addAll(label1,logo,label2);

        padre.setAlignment(Pos.BOTTOM_CENTER);
        padre.getChildren().addAll(titulo, botonJugar);
    }

//    public Scene crearTitulo(Stage ventana){
//        Button botonJugar;
//        Scene primera;
//
//        // ALTEGO
//        Label altego = new Label("A.L.T.E.G.O");
//        altego.setScaleX(20);
//        altego.setScaleY(20);
//        altego.setTextFill(Color.YELLOW);
//        Font font = new Font(10);
//        altego.setFont(font);
//
//        // BOTON JUGAR
//        botonJugar = new Button("JUGAR");
//        botonJugar.setStyle("-fx-background-color: black");
//        botonJugar.setTextFill(Color.WHITE);
//        botonJugar.setScaleX(5);
//        botonJugar.setScaleY(5);
//        botonJugar.setOnAction(new BotonSiguienteEscena(ventana));
//        // LAYOUT INICIAL
//        VBox layout1 = new VBox(250);
//        layout1.getChildren().addAll(altego, botonJugar);
//        layout1.setAlignment(Pos.CENTER);
//        layout1.setStyle("-fx-background-color: #272727");
//        primera = new Scene(layout1, 500, 100);
//
//        return primera;
//    }


}
